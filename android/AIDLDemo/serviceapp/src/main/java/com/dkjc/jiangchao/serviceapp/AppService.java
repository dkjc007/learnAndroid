package com.dkjc.jiangchao.serviceapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class AppService extends Service {
    private String data = "默认信息";
    private boolean running = false;
    public AppService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new IMyAidlInterface.Stub(){
            @Override
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

            }

            @Override
            public void setData(String str) throws RemoteException {
                AppService.this.data = str;
            }

        };
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        intent.putExtra("data",data);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("Service start");
        running = true;
        new Thread(){
            @Override
            public void run() {
                super.run();
                int count = 0;
                while (running){
                    count ++;
                    String str ="第" + count + "次运行："+data;
                    System.out.println(str);

                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Service destroy");
        running = false;
    }
}
