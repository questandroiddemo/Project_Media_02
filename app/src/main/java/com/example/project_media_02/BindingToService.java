package com.example.project_media_02;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import SepratePackage.aidlInterface;


public class BindingToService {

    private static volatile BindingToService INSTANCE = null;
    private final Context context;

    public aidlInterface aidlObject;




    public static BindingToService getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (aidlInterface.class) {
                if (INSTANCE == null)
                    INSTANCE = new BindingToService(context);
            }

        }
        return INSTANCE;

    }

    private BindingToService(Context context){
        this.context = context;
        bindTOAIDLService();

    }


    public void bindTOAIDLService() {
        Intent intent = new Intent();
        intent.setClassName("SepratePackage","com.example.service");
        context.bindService(intent,serviceConnection,Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            aidlObject = aidlInterface.Stub.asInterface(service);


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {


        }
    };

}
