package com.example.thetribunenews.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.thetribunenews.R;
import com.example.thetribunenews.UrlActivity;
import com.example.thetribunenews.ViewHolders.MyHolder1;
import com.example.thetribunenews.model.model;

import java.util.ArrayList;

public class Adapter1 extends RecyclerView.Adapter<MyHolder1> {
    ArrayList<model> arrayList = new ArrayList<model>();
    Context context;

    public Adapter1(ArrayList<model> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row,parent,false);
        return new MyHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder1 holder, int position) {

      holder.image.setImageResource(arrayList.get(position).getImg());
      holder.newst.setText(arrayList.get(position).getNewstext());
      holder.dat.setText(arrayList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    }



