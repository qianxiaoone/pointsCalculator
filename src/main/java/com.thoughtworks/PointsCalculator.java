package com.thoughtworks;

import java.math.BigDecimal;

public class PointsCalculator {
    private static final BigDecimal AMOUNT_LIMIT = BigDecimal.valueOf(1000);
    private static final BigDecimal ORIDINARY_RATIO = BigDecimal.valueOf(1);
    private static final BigDecimal ACTIVITY_RATIO = BigDecimal.valueOf(2);
    private static final BigDecimal ORIDINARY_LIMIT_RATIO = BigDecimal.valueOf(0.05);
    private static final BigDecimal ACTIVITY_LIMIT_RATIO = BigDecimal.valueOf(1);
    private Payment payment = new Payment();
    private BigDecimal points = BigDecimal.ZERO;

    public PointsCalculator(Payment payment) {
        this.payment = payment;
    }

    public BigDecimal calculatePoints() {
        payment.calculateAmount();
        BigDecimal ordinaryPoints = BigDecimal.ZERO;
        BigDecimal activityPoints = BigDecimal.ZERO;
        BigDecimal ordinaryAmount = payment.getOrdinaryAmount();
        BigDecimal activityAmount = payment.getActivityAmount();

        if (ordinaryAmount.add(activityAmount).compareTo(AMOUNT_LIMIT) > 0) {
            if (activityAmount.compareTo(AMOUNT_LIMIT) >= 0) {
                BigDecimal activityPointsLessLimit = AMOUNT_LIMIT.multiply(ACTIVITY_RATIO);
                BigDecimal activityPointsHigherLimit = activityAmount.subtract(AMOUNT_LIMIT)
                        .multiply(ACTIVITY_LIMIT_RATIO);
                activityPoints = activityPointsLessLimit.add(activityPointsHigherLimit);
                ordinaryPoints = ordinaryAmount.multiply(ORIDINARY_LIMIT_RATIO);
            }else {
                activityPoints = activityAmount.multiply(ACTIVITY_RATIO);
                BigDecimal ordinaryPointsLessLimit = AMOUNT_LIMIT.subtract(activityAmount).multiply(ORIDINARY_RATIO);
                BigDecimal ordinaryPointsHigherLimit = ordinaryAmount.subtract(AMOUNT_LIMIT.subtract(activityAmount)).multiply(ORIDINARY_LIMIT_RATIO);
                ordinaryPoints = ordinaryPointsLessLimit.add(ordinaryPointsHigherLimit);
            }
        } else {
            ordinaryPoints = ordinaryAmount.multiply(ORIDINARY_RATIO);
            activityPoints = activityAmount.multiply(ACTIVITY_RATIO);
        }

        return ordinaryPoints.add(activityPoints).setScale(0, BigDecimal.ROUND_DOWN);
    }
}
