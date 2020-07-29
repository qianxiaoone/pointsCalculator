package com.thoughtworks;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pointsCalculatorTest {
    @Test
    public void should_get_100_points_when_buy_100_goods() {
        Goods goods = new Goods();
        goods.setGoodsPrice(BigDecimal.valueOf(100));
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(goods);
        Payment payment = new Payment();
        payment.setGoodsList(goodsList);
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
        Payment payment = new Payment();
        payment.setGoodsList(goodsList);
        PointsCalculator pointsCalculator = new PointsCalculator(payment);
        BigDecimal points = pointsCalculator.calculatePoints();
        Assert.assertEquals(BigDecimal.valueOf(110), points);
    }

    @Test
    public void should_get_100_points_when_buy_40_activityGoods_20_ordinaryGoods() {
        Goods apple = new Goods();
        apple.setGoodsName("APPLE");
        apple.setGoodsPrice(BigDecimal.valueOf(10));
        Goods watermelon = new Goods();
        watermelon.setGoodsName("WATERMELON");
        watermelon.setGoodsPrice(BigDecimal.valueOf(30));
        Goods washingLiquid = new Goods();
        washingLiquid.setGoodsName("WASHINGLIQUID");
        washingLiquid.setGoodsPrice(BigDecimal.valueOf(20));
        List<Goods> goodsList = Arrays.asList(apple,watermelon,washingLiquid);
        Payment payment = new Payment();
        payment.setGoodsList(goodsList);
        PointsCalculator pointsCalculator = new PointsCalculator(payment);
        BigDecimal points = pointsCalculator.calculatePoints();
        Assert.assertEquals(BigDecimal.valueOf(100), points);
    }

    @Test
    public void should_get_1067_points_when_buy_2350_goods() {
        Goods refrigerator = new Goods();
        refrigerator.setGoodsName("REFRIGERATOR");
        refrigerator.setGoodsPrice(BigDecimal.valueOf(2350));
        List<Goods> goodsList = Arrays.asList(refrigerator);
        Payment payment = new Payment();
        payment.setGoodsList(goodsList);
        PointsCalculator pointsCalculator = new PointsCalculator(payment);
        BigDecimal points = pointsCalculator.calculatePoints();
        Assert.assertEquals(BigDecimal.valueOf(1067), points);
    }
}
