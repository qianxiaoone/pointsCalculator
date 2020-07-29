package com.thoughtworks;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Payment {
    private List<Goods> goodsList = new ArrayList<>();
    private BigDecimal ordinaryAmount = BigDecimal.ZERO;
    private BigDecimal activityAmount = BigDecimal.ZERO;

    public Payment() {
    }

    public void calculateAmount() {
        for (Goods goods : goodsList) {
            if (isInActivity(goods)) {
                activityAmount = activityAmount.add(goods.getGoodsPrice().multiply(BigDecimal.valueOf(goods.getGoodsNumber())));
            } else {
                ordinaryAmount = ordinaryAmount.add(goods.getGoodsPrice().multiply(BigDecimal.valueOf(goods.getGoodsNumber())));
            }
        }
    }

    public BigDecimal getOrdinaryAmount() {
        return ordinaryAmount;
    }

    public void setOrdinaryAmount(BigDecimal ordinaryAmount) {
        this.ordinaryAmount = ordinaryAmount;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public BigDecimal getActivityAmount() {
        return activityAmount;
    }

    public void setActivityAmount(BigDecimal activityAmount) {
        this.activityAmount = activityAmount;
    }

    public boolean isInActivity(Goods goods) {
        for (ActivityGoodsEnum a : ActivityGoodsEnum.values()) {
            if (goods.getGoodsName().equals(a.toString())) {
                return true;
            }
        }
        return false;
    }
}
