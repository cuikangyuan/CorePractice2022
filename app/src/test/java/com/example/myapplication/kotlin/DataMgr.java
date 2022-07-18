package com.example.myapplication.kotlin;


public class DataMgr {

    private static volatile DataMgr instance;

    private DataMgr() {

    }

    public static DataMgr getInstance() {
        if (instance == null) {
            synchronized (DataMgr.class) {
                if (instance == null) {
                    instance = new DataMgr();
                }
            }
        }

        return instance;
    }
}
