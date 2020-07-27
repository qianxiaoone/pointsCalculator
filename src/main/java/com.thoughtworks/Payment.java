package com.thoughtworks;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Payment {
    private List<Goods> goodsList = new ArrayList<>();
    private BigDecimal ordinaryAmount = new BigDecimal(0);

    public Payment() {
    }

    public Payment(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public BigDecimal calculateAmount() {
        for (Goods goods : goodsList
        ) {
            ordinaryAmount = ordinaryAmount.add(goods.getGoodsPrice().multiply(BigDecimal.valueOf(goods.getGoodsNumber())));
        }
        return ordinaryAmount;
    }

    public BigDecimal getOrdinaryAmount() {
        return ordinaryAmount;
    }

    public void setOrdinaryAmount(BigDecimal ordinaryAmount) {
        this.ordinaryAmount = ordinaryAmount;
    }
}
