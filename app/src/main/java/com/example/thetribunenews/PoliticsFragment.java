package com.example.thetribunenews;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thetribunenews.Adapters.Adapter1;
import com.example.thetribunenews.model.model;

import java.util.ArrayList;

public class PoliticsFragment extends Fragment {

    RecyclerView recyclerView;
    public PoliticsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_politics,container,false);
        recyclerView = view.findViewById(R.id.recpolitics);
        ArrayList<model> arrayList = new ArrayList<model>();
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

        Adapter1 adapter = new Adapter1(arrayList,getContext());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }
}