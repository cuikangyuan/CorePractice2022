package com.example.myapplication.jvm;

public class Merchant2<T extends Customer>{

    public double actionPrice(double price, T customer) {
		  return 1d;
    }
}
