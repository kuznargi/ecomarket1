package com.eco.ecomarket.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.eco.ecomarket.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {
    private FirebaseAuth auth;
    private TextView forgot_password,signUp_redirect;
    private EditText email,password;
    private Button btn_login;
    private Intent intent;
    private ImageView previousPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        initWidgets();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = email.getText().toString();
                String userPassword = password.getText().toString();
                if (!userPassword.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
                    if (!userPassword.isEmpty()) {
                        auth.signInWithEmailAndPassword(userEmail, userPassword)
                                .addOnSuccessListener(
                                        new OnSuccessListener<AuthResult>() {
                                            @Override
                                            public void onSuccess(AuthResult authResult) {
                                                Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                                finish();

                                            }
                                        }
                                ).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                                    }
                                });

                    }
                }
            }
        });
        previousPage.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );
        signUp_redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
            }
        });

    }  public void initWidgets(){
        auth=FirebaseAuth.getInstance();
        forgot_password=findViewById(R.id.txt_forgot_password);
        signUp_redirect=findViewById(R.id.signUp_redirectTV);
        btn_login=findViewById(R.id.btn_login);
        email=findViewById(R.id.edit_email);
        password=findViewById(R.id.edit_password);
        previousPage=findViewById(R.id.previous_page);
    }

}


