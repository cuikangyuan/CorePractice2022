package com.example;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.myapplication.ICompute;
import com.example.myapplication.IUser;

public class SecondActivity extends Activity {

    private void testBinderPool() {
        BinderPool mBinderPool = BinderPool.getInstance(SecondActivity.this);
        //测试ICompute
        IBinder mComputeBinder = mBinderPool.queryBinder(BinderPool.BINDER_COMPUTE);
        ICompute mCompute = ICompute.Stub.asInterface(mComputeBinder);
        try {
            Log.i("chenming", "1+2 = " + mCompute.add(1, 2));
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        //测试IUser
        IBinder mUserBinder = mBinderPool.queryBinder(BinderPool.BINDER_USER);
        IUser mUser = IUser.Stub.asInterface(mUserBinder);
        try {
            Log.i("chenming", "login " + mUser.login("user", "psd"));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
