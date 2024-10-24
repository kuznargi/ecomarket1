package com.eco.ecomarket.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.eco.ecomarket.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private Button signUp;
    private Intent intent;
    private EditText email,password;
    private FirebaseAuth auth;
    private TextView loginRedirect;
    private ImageView previousPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        initWidgets();
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user =email.getText().toString().trim();
                String pass=password.getText().toString().trim();
                if(user.isEmpty()){
                    email.setError("Email cannot be empty");

                }
                else if(pass.isEmpty()){
                    password.setError("Password connot be empty");
                }
                else {
                    auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                          if(task.isSuccessful()){
                              Toast.makeText(getApplicationContext(),"Sign Up successful",Toast.LENGTH_SHORT).show();
                              intent=new Intent(getApplicationContext(), Otp.class);
                              intent.putExtra("email",user);
                              startActivity(intent);
                          }
                          else {
                              Toast.makeText(getApplicationContext(),"Sign Up failed",Toast.LENGTH_SHORT).show();
                          }
                        }
                    });
                }




            }
        });
        loginRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               intent=new Intent(getApplicationContext(), Login.class);
               startActivity(intent);
            }
        });
        previousPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           finish();
            }
        });

    }
    void initWidgets(){
        auth=FirebaseAuth.getInstance();
        signUp=findViewById(R.id.signUpBtn);
        email=findViewById(R.id.edit_email);
        password=findViewById(R.id.edit_password);
        previousPage=findViewById(R.id.previous_page);
        loginRedirect=findViewById(R.id.login_redirectTV);
    }
}