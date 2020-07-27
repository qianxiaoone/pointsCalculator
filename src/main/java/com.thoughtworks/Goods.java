package com.thoughtworks;

import java.math.BigDecimal;

public class Goods {
    private BigDecimal goodsPrice = new BigDecimal(0);
    private int goodsNumber = 1;

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }
}
