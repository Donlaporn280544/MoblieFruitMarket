package com.example.fruitshop;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.util.Log;

public class RegistrationActivity extends AppCompatActivity {
    private static final String TAG = "SignUpActivity";
    EditText email1,password1;
    Button signUpButton;
    Button signinButton;
    public FirebaseAuth mAuth;
    //firebase auth object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_registration);
        email1 = findViewById(R.id.email_register);
        password1 = findViewById(R.id.password_register);
        mAuth = FirebaseAuth.getInstance();
        signUpButton = findViewById(R.id.signup_reg_Button);
        signinButton = findViewById(R.id.signin_reg_Button);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailText = email1.getText().toString();
                String passwordText = password1.getText().toString();
                if ( emailText.isEmpty() || passwordText.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Please enter all the details", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.createUserWithEmailAndPassword(emailText, passwordText)
                            .addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "createUserWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Toast.makeText(RegistrationActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(RegistrationActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
            }
        });
    }
}

