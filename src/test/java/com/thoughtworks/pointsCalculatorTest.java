package com.thoughtworks;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class pointsCalculatorTest {
    @Test
    public void should_get_100_points_when_buy_100_goods() {
        Goods goods = new Goods();
        goods.setGoodsPrice(BigDecimal.valueOf(100));
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(goods);
        Payment payment = new Payment(goodsList);
        PointsCalculator pointsCalculator = new PointsCalculator(payment);
        BigDecimal points = pointsCalculator.calculatePoints();
        Assert.assertEquals(BigDecimal.valueOf(100), points);
    }
    @Test
    public void should_get_110_points_when_buy_110_goods() {
        Goods goods = new Goods();
        goods.setGoodsPrice(BigDecimal.valueOf(110));
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(goods);
        Payment payment = new Payment(goodsList);
        PointsCalculator pointsCalculator = new PointsCalculator(payment);
        BigDecimal points = pointsCalculator.calculatePoints();
        Assert.assertEquals(BigDecimal.valueOf(110), points);
    }
}
