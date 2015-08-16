package com.dkjc.jiangchao.aidldemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.dkjc.jiangchao.serviceapp.IMyAidlInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {
    private Intent intent = null;
    private EditText et = null;
    private TextView tv = null;
    private IMyAidlInterface binder = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent();
        intent.setComponent(new ComponentName("com.dkjc.jiangchao.serviceapp","com.dkjc.jiangchao.serviceapp.AppService"));
        //获得控件
        et = (EditText) findViewById(R.id.etData);
        tv = (TextView) findViewById(R.id.tvOut);
        findViewById(R.id.btnStartOtherAppService).setOnClickListener(this);
        findViewById(R.id.btnStopOtherAppService).setOnClickListener(this);
        findViewById(R.id.btnBindOtherAppService).setOnClickListener(this);
        findViewById(R.id.btnUnbindOtherAppService).setOnClickListener(this);
        findViewById(R.id.btnSync).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStartOtherAppService:
                startService(intent);
                break;
            case R.id.btnStopOtherAppService:
                stopService(intent);
                break;
            case R.id.btnBindOtherAppService:
                bindService(intent,this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btnUnbindOtherAppService:
                unbindService(this);
                binder = null;
                break;
            case R.id.btnSync:
                String str = et.getText().toString();
                if(binder != null){
                    try {
                        binder.setData(str);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("onServiceConnected");
        binder = IMyAidlInterface.Stub.asInterface(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
