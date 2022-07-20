package com.example.myapplication.jvm;

//范型参数类型造成的方法参数类型不一致
public class VIPOnlyMerchant extends Merchant2<VIP> {
    @Override
    public double actionPrice(double price, VIP customer) {
        return 1d;
    }
}