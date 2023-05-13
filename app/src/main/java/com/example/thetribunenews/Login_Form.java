package com.example.thetribunenews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thetribunenews.Helper.Helper;
import com.example.thetribunenews.Helper.Helper2;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Form extends AppCompatActivity {
   EditText email,password;
   Button login;
   TextView signin;
   CheckBox checkBox;
   SharedPreferences sp;
   SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signin = findViewById(R.id.forget);
        login = findViewById(R.id.login);
        checkBox = findViewById(R.id.checkBox);
        sp = getSharedPreferences("data",MODE_PRIVATE);
        editor = sp.edit();
        boolean logins = sp.getBoolean("Islogged",false);
        if(logins == true){
            startActivity(new Intent(Login_Form.this,HomeActivity.class));
        }
        Helper2 helper2 = new Helper2(this);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Form.this, SignIn_Form.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uemail = email.getText().toString();
                String upassword = password.getText().toString();
                boolean log = helper2.checkemailandpassword(uemail, upassword);
                if (uemail.equals("") || upassword.equals("")) {
                    Toast.makeText(Login_Form.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean loged = helper2.checkemailandpassword(uemail, upassword);
                    if (loged == true) {
                     if(checkBox.isChecked()){
                         editor.putString("username",uemail);
                         editor.putString("userpass",upassword);
                         editor.putBoolean("Islogged",true);
                         editor.apply();
                         Toast.makeText(Login_Form.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                     }
                        Intent intent = new Intent(Login_Form.this, HomeActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Login_Form.this, "Please fill correct email and password", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


    }
}