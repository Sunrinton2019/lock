package com.example.sunrinthon5th;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_normal, btn_rxjava1, btn_rxjava2, btn_windowPermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_normal = findViewById(R.id.btn_normal);
        btn_rxjava1 = findViewById(R.id.btn_rxjava1);
        btn_rxjava2 = findViewById(R.id.btn_rxjava2);
        btn_windowPermission = findViewById(R.id.btn_windowPermission);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = null;
        switch (id) {
            case R.id.btn_normal:
                intent = new Intent(this, NormalActivity.class);
                break;
            case R.id.btn_rxjava1:
                intent = new Intent(this, RxJava1Activity.class);
                break;
            case R.id.btn_rxjava2:
                intent = new Intent(this, RxJava2Activity.class);
                break;

            case R.id.btn_windowPermission:
                intent = new Intent(this, WindowPermissionActivity.class);
                break;

        }
        if (intent != null) {
            startActivity(intent);
        }

    }
}
