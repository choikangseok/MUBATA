package com.example.termproject;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class StopWatch extends AppCompatActivity {
    private MyBoundService.MyBinder myService = null;
    boolean bindState = false;

    public boolean updating = true;
    public boolean isplaying = false;

    private TextView timerText;

    private Button startButton;
    private Button pauseButton;
    private Button lapButton;
    private Button resumeButton;
    private Button resetButton;
    private LinearLayout lapLayout;
    private LinearLayout lapContainer;


    static int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        i = 1;

        Intent intent = new Intent(this, MyBoundService.class);
        startService(intent);

        bindService(new Intent(this, MyBoundService.class),serviceConnection, Context.BIND_AUTO_CREATE);

        this.timerText = (TextView) findViewById(R.id.timerText);
        this.startButton = (Button) findViewById(R.id.buttonStart);
        this.resumeButton = (Button) findViewById(R.id.buttonResume);
        this.pauseButton = (Button) findViewById(R.id.buttonPause);
        this.resetButton = (Button) findViewById(R.id.buttonReset);
        this.lapButton = (Button) findViewById(R.id.buttonLap);
        this.lapLayout = (LinearLayout) findViewById(R.id.lapLayout);
        this.lapContainer = (LinearLayout) findViewById(R.id.lapContainer);
    }

    public void buttonStart(View view) {

        startButton.setVisibility(View.GONE);
        pauseButton.setVisibility(View.VISIBLE);
        lapButton.setVisibility(View.VISIBLE);

        isplaying = true;
        myService.start();

        updating = true;
        updateThread();
    }

    public void buttonPause(View view) {
        pauseButton.setVisibility(View.GONE);
        lapButton.setVisibility(View.GONE);
        resumeButton.setVisibility(View.VISIBLE);
        resetButton.setVisibility(View.VISIBLE);
        myService.pause();
        updating = false;
    }

    public void buttonLap(View view) {
        lapContainer.setVisibility(View.VISIBLE);

        LinearLayout ll = new LinearLayout(StopWatch.this);
        ll.setOrientation(LinearLayout.HORIZONTAL);

        TextView lapNo = new TextView(StopWatch.this);
        lapNo.setText(""+i++);
        lapNo.setTextSize(20);
        lapNo.setGravity(Gravity.CENTER | Gravity.CENTER);

        lapNo.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT, 1f));

        TextView lapTime = new TextView(StopWatch.this);

        lapTime.setText(myService.getString());
        lapTime.setTextSize(20);
        lapTime.setGravity(Gravity.CENTER | Gravity.CENTER);
        lapTime.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT, 1f));

        ll.addView(lapNo);
        ll.addView(lapTime);

        lapLayout.addView(ll,0);


    }

    public void buttonResume(View view) {
        resumeButton.setVisibility(View.GONE);
        resetButton.setVisibility(View.GONE);
        pauseButton.setVisibility(View.VISIBLE);
        lapButton.setVisibility(View.VISIBLE);
        myService.start();
        updating = true;
        updateThread();
    }

    public void buttonReset(View view) {
        timerText.setText("00:00:000");
        resumeButton.setVisibility(View.GONE);
        startButton.setVisibility(View.VISIBLE);
        resetButton.setVisibility(View.GONE);
        lapContainer.setVisibility(View.GONE);
        lapLayout.removeAllViews();

        myService.reset();

        i = 1;
    }

    public void updateThread(){

        new Thread(new Runnable () {
            public void run() {
                while(updating) {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            timerText.setText(myService.getString());
                        }
                    });
                    try {
                        Thread.sleep(1);
                    } catch (Exception e) {
                        return;
                    }
                }
            }
        }).start();
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName classname, IBinder service) {
            myService = (MyBoundService.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myService = null;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(isplaying == true) {
            unbindService(serviceConnection);
            Intent intent = new Intent(this, MyBoundService.class);
            stopService(intent);
            isplaying = false;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        /*if(isplaying == true) {
            unbindService(serviceConnection);
            Intent intent = new Intent(this, MyBoundService.class);
            stopService(intent);
            isplaying = false;
            updating = false;
        }*/
    }

}
