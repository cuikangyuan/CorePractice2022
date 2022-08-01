package com.example;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.myapplication.IBinderPool;

import java.util.concurrent.CountDownLatch;

public class BinderPool {

    private static volatile BinderPool sInstance;
    private Context mContext;
    private CountDownLatch mConnectBinderPoolCountDownLatch;
    private IBinderPool mBinderPool;

    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mBinderPool = IBinderPool.Stub.asInterface(iBinder);
            try {
                mBinderPool.asBinder().linkToDeath(mBinderPoolDeathRecipient, 0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            mConnectBinderPoolCountDownLatch.countDown();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    private IBinder.DeathRecipient mBinderPoolDeathRecipient = new IBinder.DeathRecipient() {
        @Override
        public void binderDied() {
            mBinderPool.asBinder().unlinkToDeath(mBinderPoolDeathRecipient, 0);
            mBinderPool = null;
            connectService();
        }
    };

    private BinderPool(Context context) {
        mContext = context;
        connectService();
    }

    public static BinderPool getInstance(Context context) {
        if (sInstance == null) {
            synchronized (BinderPool.class) {
                if(sInstance == null) {
                    sInstance = new BinderPool(context);
                }
            }
        }
        return sInstance;
    }


    private void connectService() {
        mConnectBinderPoolCountDownLatch = new CountDownLatch(1);
        Intent intent = new Intent(mContext, BinderPoolService.class);
        mContext.bindService(intent, conn, Context.BIND_AUTO_CREATE);
        try {
            mConnectBinderPoolCountDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public IBinder queryBinder(int code) {
        if(mBinderPool == null) {
            return null;
        }
        try {
            return mBinderPool.queryBinder(code);
        } catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }



    //binder code
    public static final int BINDER_USER = 0;
    public static final int BINDER_COMPUTE = 1;

    public static class BinderPoolImpl extends IBinderPool.Stub {
        @Override
        public IBinder queryBinder(int binderCode) throws RemoteException {
            switch (binderCode) {
                case BINDER_COMPUTE:
                    return new ComputeImpl();
                case BINDER_USER:
                    return new UserImpl();
                default:
                    return null;
            }
        }
    }
}
