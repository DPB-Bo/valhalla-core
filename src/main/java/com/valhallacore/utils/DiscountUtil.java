package com.valhallacore.utils;

public class DiscountUtil {
    public static double getDiscountPercentage(double originalPrice, double salePrice) {
//        double discountPercentage = (originalPrice - salePrice) / originalPrice * 100;
        double discountPercentage =100 - (salePrice / (originalPrice/ 100) );
        return Math.round(discountPercentage * 100.0) / 100.0;
    }
}
