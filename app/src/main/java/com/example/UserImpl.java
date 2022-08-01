package com.example;

import android.os.RemoteException;

import com.example.myapplication.IUser;

public class UserImpl extends IUser.Stub {
    @Override
    public boolean login(String username, String password) throws RemoteException {
        return false;
    }
}
