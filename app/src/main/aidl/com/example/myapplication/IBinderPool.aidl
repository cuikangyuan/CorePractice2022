// IBinderPool.aidl
package com.example.myapplication;


interface IBinderPool {
    IBinder queryBinder(int binderCode);
}