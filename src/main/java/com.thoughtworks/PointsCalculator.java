package com.thoughtworks;

import java.math.BigDecimal;

public class PointsCalculator {
    private static final int amountLimit = 1000;
    private static final int oridinaryRatio = 1;
    private static final int activityRatio = 2;
    private static final double oridinaryLimitRatio = 0.05;
    private Payment payment = new Payment();
    private BigDecimal points = BigDecimal.ZERO;

    public PointsCalculator(Payment payment) {
        this.payment = payment;
    }

    public BigDecimal calculatePoints() {
        payment.calculateAmount();
        BigDecimal ordinaryPoints = BigDecimal.ZERO;
        BigDecimal activityPoints = BigDecimal.ZERO;

        ordinaryPoints = payment.getOrdinaryAmount().multiply(BigDecimal.valueOf(oridinaryRatio));
        activityPoints = payment.getActivityAmount().multiply(BigDecimal.valueOf(activityRatio));

        return ordinaryPoints.add(activityPoints).setScale(0, BigDecimal.ROUND_DOWN);
    }
}
