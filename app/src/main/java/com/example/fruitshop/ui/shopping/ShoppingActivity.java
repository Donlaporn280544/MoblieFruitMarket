package com.example.fruitshop.ui.shopping;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.fruitshop.LoginActivity;
import com.example.fruitshop.MainActivity;
import com.example.fruitshop.R;
import com.example.fruitshop.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ShoppingActivity extends AppCompatActivity {
    private static final String TAG = "ShoppingActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        setContentView(R.layout.fragment_shopping);
        finish();


    }
}
