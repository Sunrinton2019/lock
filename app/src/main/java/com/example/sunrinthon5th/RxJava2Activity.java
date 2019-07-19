package com.example.sunrinthon5th;


import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class RxJava2Activity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TedRx2Permission.with(this)
                .setRationaleTitle(R.string.rationale_title)
                .setRationaleMessage(R.string.rationale_message) // "we need permission for read contact and find your location"
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION)
                .request()
                .subscribe(tedPermissionResult -> {
                    if (tedPermissionResult.isGranted()) {
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this,
                                "Permission Denied\n" + tedPermissionResult.getDeniedPermissions().toString(), Toast.LENGTH_SHORT)
                                .show();
                    }
                }, throwable -> {
                });


    }
}