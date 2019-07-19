package com.example.lockscreen;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class ScreenReceiver extends BroadcastReceiver {
    public static int iffloting=0;

    IntentFilter intentFilter = new IntentFilter();
    IntentFilter powerFilter = new IntentFilter(Intent.ACTION_SCREEN_OFF);





    private KeyguardManager km = null;

    private KeyguardManager.KeyguardLock keyLock = null;


    @Override

    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {

            if (km == null)

                km = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);


            if (keyLock == null)

                keyLock = km.newKeyguardLock(Context.KEYGUARD_SERVICE);


            disableKeyguard();

            if(iffloting==0){
                Intent i = new Intent(context, LockScreenActivity.class);

                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }

            iffloting=1;



        }

    }


    public void reenableKeyguard() {

        keyLock.reenableKeyguard();

    }


    public void disableKeyguard() {

        keyLock.disableKeyguard();

    }

    class ScreenOnReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();


            if (action.equals(Intent.ACTION_SCREEN_ON)) {
                Log.i("on", "yes");

            } else if (action.equals(Intent.ACTION_SCREEN_OFF)) {

                Log.i("off?", "yes");


            } else if (action.equals(Intent.ACTION_SHUTDOWN)) {

            } else if (action.equals(Intent.ACTION_BOOT_COMPLETED)) {

            }
        }
    }
}
