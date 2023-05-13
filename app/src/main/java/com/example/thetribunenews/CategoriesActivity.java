package com.example.thetribunenews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class CategoriesActivity extends AppCompatActivity {

    Button politics,business,travel,foods,enterntainement,health,sports,technology,education,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.framel, new PoliticsFragment()).commit();

        }

        politics = findViewById(R.id.politics);
        business = findViewById(R.id.business);
        travel = findViewById(R.id.travel);
        foods = findViewById(R.id.foods);
        enterntainement = findViewById(R.id.enterntainment);
        health = findViewById(R.id.health);
        education = findViewById(R.id.education);
        technology = findViewById(R.id.technology);
        sports = findViewById(R.id.sports);
        back = findViewById(R.id.backbtn);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoriesActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });


        politics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framel,new PoliticsFragment()).commit();

            }
        });

        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framel,new BusinessFragment()).commit();

            }
        });
        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framel,new TravelFragment()).commit();

            }
        });
        foods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framel,new FoodFragment()).commit();

            }
        });
        enterntainement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framel,new EnterntainmentFragment()).commit();

            }
        });
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framel,new HealthFragment()).commit();

            }
        });
        technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framel,new TechnologyFragment()).commit();

            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framel,new sportsFragment()).commit();

            }
        });
        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framel,new EducationFragment()).commit();

            }
        });

    }
}