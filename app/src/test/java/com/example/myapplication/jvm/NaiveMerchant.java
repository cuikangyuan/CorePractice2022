package com.example.myapplication.jvm;

//重写方法的返回类型不一致：
public class NaiveMerchant extends Merchant {

    @Override
    public Double actionPrice(double price, Customer customer) {
        return 1d;
    }
}
