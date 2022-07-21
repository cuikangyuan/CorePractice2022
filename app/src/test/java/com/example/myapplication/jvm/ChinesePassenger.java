package com.example.myapplication.jvm;

import org.junit.Test;

public class ChinesePassenger extends Passenger{

    @Override
    void passThroughImmigration() { /* 进中国人通道 */ }
    void visitDutyFreeShops() { /* 逛免税店 */ }

    @Test
    public void test() throws NullPointerException{
        try {
            Passenger passenger = new ChinesePassenger();
            passenger.passThroughImmigration();
            //throw new NullPointerException();
        }  catch (OutOfMemoryError error) {

        } finally {

        }

    }
}
