package com.eco.ecomarket.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.eco.ecomarket.R;

public class GetStarted extends AppCompatActivity {
    private Button login,signUp;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_get_started);
        initWidget();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });


    }
    void initWidget(){
        login=findViewById(R.id.btnLogin);
        signUp=findViewById(R.id.btnSignup);
    }
}