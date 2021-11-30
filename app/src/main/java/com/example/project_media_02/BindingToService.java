package com.example.project_media_02;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_media_02.Model.MusicModel;

import java.util.List;

import SepratePackage.aidlInterface;

public class BindingToService extends AppCompatActivity {
    private static volatile BindingToService INSTANC = null;
    private final Context context;

    private aidlInterface aidlObject = null;

    public BindingToService(Context context) {
        this.context = context;
        bindToAIDLService();

    }

    private void bindToAIDLService() {

        Intent aidlServiceIntent = new Intent("connect_to_aidl_service");
        bindService(convertImplicitIntentToExplicitIntent(aidlServiceIntent,this), serviceConnectionObject, BIND_AUTO_CREATE);
    }

    ServiceConnection serviceConnectionObject = new ServiceConnection () {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            aidlObject = aidlInterface.Stub.asInterface(service);
            Toast.makeText(getApplicationContext(),"Service Connected", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(getApplicationContext(),"Service Disconnected", Toast.LENGTH_SHORT).show();

        }
    };


    public Intent convertImplicitIntentToExplicitIntent(Intent implicitIntent, Context context) {
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfoList = pm.queryIntentServices(implicitIntent, 0);

        if (resolveInfoList == null || resolveInfoList.size() != 1) {
            return null;
        }
        ResolveInfo serviceInfo = resolveInfoList.get(0);
        ComponentName component = new ComponentName(serviceInfo.serviceInfo.packageName, serviceInfo.serviceInfo.name);
        Intent explicitIntent = new Intent(implicitIntent);
        explicitIntent.setComponent(component);
        return explicitIntent;





    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_binding_to_service );
    }
    public static BindingToService getInstance(Context context){
        if (INSTANC ==null){
            synchronized (MusicModel.class)
            {
                if (INSTANC == null)
                    INSTANC = new BindingToService ( context );
            }
        }
        return INSTANC;
    }
}