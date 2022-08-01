package com.example;

import android.os.RemoteException;

import com.example.myapplication.ICompute;

public class ComputeImpl extends ICompute.Stub {
    @Override
    public int add(int x, int y) throws RemoteException {
        return 0;
    }
}
