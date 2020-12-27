package com.revolt.primenews;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar = findViewById(R.id.progressbar10);
        progressBar.setVisibility(View.VISIBLE);
        PostDelayedMethod();


    }
    public void PostDelayedMethod()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
                // boolean InternetResult = checkConnection();
                if(checkConnection()){
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    //SplashScreenActivity.this.finish();
                }else
                {
                    // progressBar.setVisibility(View.VISIBLE);
                    // progressBar.setVisibility(View.GONE);
                    DialogAppear();
                }
            }
        },SPLASH_TIME_OUT);
    }


    public void DialogAppear() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
        builder.setCancelable(false);
        builder.setTitle("NETWORK ERROR");
        builder.setMessage("Please Check Your Internet Connectivity");
        builder.setNegativeButton("EXIT",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        builder.setPositiveButton("Retry",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PostDelayedMethod();
                    }
                });
        builder.show();

    }
    protected boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        //noinspection deprecation
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {

            return true;
        }
        else
            return false;
    }

    public boolean checkConnection() {
        return isOnline();
    }
}
