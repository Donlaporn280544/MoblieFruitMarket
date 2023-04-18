package com.example.fruitshop;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LogoutActivity extends AppCompatActivity {
    private static final String TAG = "LogoutActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();



    }


}
