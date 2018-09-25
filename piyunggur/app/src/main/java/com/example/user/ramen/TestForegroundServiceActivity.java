package com.example.user.ramen;

import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TestForegroundServiceActivity extends AppCompatActivity {


    private EditText editTextInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test_foreground_service);


        editTextInput = findViewById(R.id.foreground_input);

    }



    public void startService(View view) {


        String input = editTextInput.getText().toString();


        Intent serviceIntent = new Intent(this, ExampleService.class);
        serviceIntent.putExtra("inputExtra", input);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            ContextCompat.startForegroundService(this, serviceIntent);
        }

    }


    public void stopService(View view) {


        Intent serviceIntent = new Intent(this, ExampleService.class);
        stopService(serviceIntent);

    }


}
