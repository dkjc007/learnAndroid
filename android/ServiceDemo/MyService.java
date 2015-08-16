package com.dkjc.jiangchao.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    //控制服务是否开启的状态
    boolean running = false;
    //前台输入的文字
    String data = "默认数据";
    private CallBack callBack = null;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return new MyService.Binder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("onStartCommand");
        this.data = intent.getStringExtra("data");
        return super.onStartCommand(intent, flags, startId);
    }

    //开始服务之后第一个生命周期状态方法
    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate");
        running = true;

        //建立线程进行后台服务
        new Thread(){
            @Override
            public void run() {
                super.run();

                int i = 0;
                while (running){
                    i ++;
                    String str = i+":::::::"+data;
                    if(callBack != null){
                        callBack.onDataChange(str);
                    }
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
    //开始服务之后最后一个生命周期状态方法
    @Override
    public void onDestroy() {
        super.onDestroy();
        running = false;
    }

    //内部类，重写Binder类，在Activity页面通过使用该类中的binder类，达到数据通信
    public class Binder extends android.os.Binder{
        //设置数据通信的方法，可以通过这个类的方法，获得从Activity过来的binder里面的数据
        public void setData(String str){
            MyService.this.data = str;
        }

        public MyService getService(){
            return MyService.this;
        }
    }

    //内部接口，作用是规定回调函数的功能，利用回调往Activity页面传递后台数据
    public static interface CallBack{
        public void onDataChange(String str);
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public CallBack getCallBack() {
        return callBack;
    }
}
