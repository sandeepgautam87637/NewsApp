package com.example.thetribunenews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thetribunenews.Helper.Helper;
import com.google.android.material.snackbar.Snackbar;

public class ContactForm extends AppCompatActivity {
    EditText email,name,phone;
    Button send;
    TextView back;
    ImageView backimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_form);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phonenumber);
        send = findViewById(R.id.send);
        back = findViewById(R.id.back);
        backimg = findViewById(R.id.backimg);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactForm.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactForm.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        Helper helper = new Helper(this);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname, uemail, uphone;
                uname = name.getText().toString();
                uemail = email.getText().toString();
                uphone = phone.getText().toString();
                if (uname.equals("") || uemail.equals("") || uphone.equals("")) {
                    Snackbar.make(view,"Please fill all details",Snackbar.LENGTH_SHORT).setAction("Action",null).show();


                } else {
                    boolean insertfun = helper.InsertContact(uname, uemail, uphone);
                    if (insertfun == true) {
                        Snackbar.make(view,"Record Saved Successfully",Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                        name.setText("");
                        email.setText("");
                        phone.setText("");
                    } else {
                        Snackbar.make(view,"Failed",Snackbar.LENGTH_SHORT).setAction("Action",null).show();

                    }

                }
            }


        });

    }
}