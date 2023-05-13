package com.example.thetribunenews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thetribunenews.Helper.Helper;
import com.example.thetribunenews.Helper.Helper2;

public class SignIn_Form extends AppCompatActivity {
      TextView username,useremail,userpassword;
      Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_form);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        Helper2 helper2 = new Helper2(this);
        username = findViewById(R.id.usersign);
        useremail = findViewById(R.id.emailsign);
        userpassword = findViewById(R.id.passwordsign);
        signin = findViewById(R.id.signinbtn);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = username.getText().toString();
                String uemail = useremail.getText().toString();
                String upass = userpassword.getText().toString();
                if(uname.equals("") || uemail.equals("") || upass.equals("") ){
                    Toast.makeText(SignIn_Form.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean i = helper2.check_email(uemail);
                    if(i == false){
                        boolean insertfun=helper2.createuserSign(uname , uemail ,upass);
                        if(insertfun==true){
                            Toast.makeText(SignIn_Form.this, "Record Saved Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(SignIn_Form.this , HomeActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(SignIn_Form.this, "Failed to Saved Record", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(SignIn_Form.this, "Please choose another email", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}