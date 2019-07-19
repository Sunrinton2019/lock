package com.example.lockscreen;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConfigActivity extends Activity {
    private Button offBtn;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_config);

        Intent intent = new Intent(ConfigActivity.this, ScreenService.class);

        startService(intent);

        offBtn = findViewById(R.id.offbtn);


        offBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfigActivity.this, ScreenService.class);

                stopService(intent);
            }
        });

    }
}