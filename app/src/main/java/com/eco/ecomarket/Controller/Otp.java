package com.eco.ecomarket.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.eco.ecomarket.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Otp extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText pass_1;
    private EditText pass_2;
    private EditText pass_3;
    private EditText pass_4;
    private TextView user_email;
    Intent intent;
    Button verify;
    int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWidgets();
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_otp);
        user_email = findViewById(R.id.user_email);
        String mail = getIntent().getStringExtra("email");
        user_email.setText(mail);
        verify=findViewById(R.id.btn_verify);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyCode();
                if (flag == 1){
                    intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }


            }
        });
    }

    private void verifyCode(){
        FirebaseUser user = auth.getCurrentUser();

        if (user!=null){
            user.reload().addOnCompleteListener(task -> {
                if (user.isEmailVerified()){
                    Toast.makeText(Otp.this,"Email verfied!",Toast.LENGTH_SHORT).show();
                    flag = 1;
                }else{
                    Toast.makeText(Otp.this,"Please, check your email!!",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void initWidgets(){
        auth = FirebaseAuth.getInstance();
        pass_1 = findViewById(R.id.otpET1);
        pass_2 = findViewById(R.id.otpET2);
        pass_3 = findViewById(R.id.otpET3);
        pass_4 = findViewById(R.id.otpET4);
    }



}