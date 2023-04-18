package com.example.fruitshop.ui.account;

import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fruitshop.LoginActivity;
import com.example.fruitshop.R;
import com.example.fruitshop.ui.shopping.ShoppingFragment;
import com.example.fruitshop.ui.shopping.ShoppingViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.content.Intent;
import android.util.Log;
public class AccountActivity extends AppCompatActivity {
    private static final String TAG = "PaymentActivity";

    Button Btn_to_payment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_account);
        Btn_to_payment = findViewById(R.id.btn_to_payment);
        Btn_to_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AccountActivity.this, "dddddddddd", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
