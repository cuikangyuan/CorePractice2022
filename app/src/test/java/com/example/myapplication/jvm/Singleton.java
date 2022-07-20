package com.example.myapplication.jvm;

//-XX：+TraceClassLoading 可以看到类加载过程
public class Singleton {

    private Singleton() {
    }

    private static class LazyHolder {
        static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }

//    public void fly(int a) {
//
//    }
//
//    public int fly(int b) {
//        return 0;
//    }
}
