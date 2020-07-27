package com.thoughtworks;

import java.math.BigDecimal;

public class PointsCalculator {
    private Payment payment = new Payment();
    private BigDecimal points = new BigDecimal(0);

    public PointsCalculator(Payment payment) {
        this.payment = payment;
    }

    public BigDecimal calculatePoints() {
        payment.calculateAmount();
        points = payment.getOrdinaryAmount().setScale(0, BigDecimal.ROUND_FLOOR);
        return points;
    }
}
