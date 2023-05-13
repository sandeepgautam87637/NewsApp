package com.example.thetribunenews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.thetribunenews.Adapters.Adapter1;
import com.example.thetribunenews.ImageSlider.autoImage;
import com.example.thetribunenews.model.model;
import com.google.android.material.tabs.TabLayout;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TabLayout tabLayout;
    FrameLayout frame;
    Button logout;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    SliderView slider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.rec2);
        tabLayout = findViewById(R.id.tablayout);
        frame = findViewById(R.id.frame);
        logout = findViewById(R.id.logout);
        slider = findViewById(R.id.slider);
        int [] images={R.drawable.nwe1,R.drawable.nwe2,R.drawable.nwe3,R.drawable.nwe4,R.drawable.nwe5};
        autoImage autoimage = new autoImage(images);
        slider.setSliderAdapter(autoimage);
        slider.startAutoCycle();
        sp = getSharedPreferences("data",MODE_PRIVATE);
        editor = sp.edit();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new HomeMainFragment()).commit();

        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new HomeMainFragment()).commit();

                        break;
                    case 1:
                    Intent intent = new Intent(HomeActivity.this,CategoriesActivity.class);
                    startActivity(intent);

                    break;
                    case 2:
                        Intent intent2 = new Intent(HomeActivity.this,ContactForm.class);
                        startActivity(intent2);
                    break;

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        ArrayList<model> arrayList = new ArrayList<model>();
//        RequestQueue requestQueue;
//        requestQueue = Volley.newRequestQueue(this);
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=58b7aa36b692416086d76a603042f6d9", null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                try {
//                    for (int i=0; i<response.length();i++){
//                        JSONObject obj = response.getJSONObject(i);
//                        arrayList.add(new model(R.drawable.nw1,obj.getString("title"),obj.getString("id")));
//                    }
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(HomeActivity.this, "Something Error Occure", Toast.LENGTH_SHORT).show();
//            }
//

//    });
//        requestQueue.add(jsonArrayRequest);


        arrayList.add(new model(R.drawable.nw1,"The software's emergence has already ruffled some of the biggest technology firms, prompting Alphabet and Microsoft to hastily debut new functions in Google and ","22 feb 2023"));
        arrayList.add(new model(R.drawable.nw2,"According to a research team led by Penn University that undertook the first study to specifically look at the topic, language models that generate text in response ","22 feb 2023"));
        arrayList.add(new model(R.drawable.nw3,"Twitter on Friday said that it would begin charging users to secure their accounts via SMS-based two-factor authentication. Twitter Blue subscribers will be able to continue","22 feb 2023"));
        arrayList.add(new model(R.drawable.nw4,"ChatGPT could score at or around the approximately 60 per cent passing threshold for the United States Medical Licensing Exam (USMLE), with responses that made coherent,","22 feb 2023"));
        arrayList.add(new model(R.drawable.nw5,"Google is adding more AI-powered features to its native services like Lens and Translate. The tech giant has announced a bunch of new features to Google Translate including","22 feb 2023"));
        arrayList.add(new model(R.drawable.nw6,"Google has rolled out the multi-search feature to Lens on mobile globally. The feature lets users search using Google Lens with both text and pictures simultaneously. ","22 feb 2023"));
        arrayList.add(new model(R.drawable.nw7,"Google has rolled out the multi-search feature to Lens on mobile globally. The feature lets users search using Google Lens with both text and pictures simultaneously.  ","22 feb 2023"));
        arrayList.add(new model(R.drawable.nw8,"ChatGPT owner OpenAI said on Wednesday it is launching a pilot subscription plan for its popular AI-powered chatbot, called ChatGPT Plus, for $20 (nearly Rs. 1,600)","22 feb 2023"));
        arrayList.add(new model(R.drawable.nw9,"Google is reportedly working on a new feature for Chrome that will let users translate text within images with ease. The web browser currently allows users to translate text","22 feb 2023"));
        arrayList.add(new model(R.drawable.nw10,"ChatGPT creator OpenAI on Wednesday released a tool designed to detect AI-generated text. While the tool is in public beta, OpenAI says it is very  on texts","22 feb 2023"));
        arrayList.add(new model(R.drawable.nw11,"India is now becoming a solution to the world's problems, saidPresident Droupadi Murmu while addressing the parliament on the opening day of Budget session.","22 feb 2023"));

        Adapter1 adapter = new Adapter1(arrayList,this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                Toast.makeText(HomeActivity.this, "Scrolling the list", Toast.LENGTH_SHORT).show();
//            }
//        });







    }



    public void logout(){
        editor.clear();
        editor.apply();;
        startActivity(new Intent(HomeActivity.this,Login_Form.class));
        finish();
    }
}