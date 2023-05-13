package com.example.thetribunenews.ViewHolders;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thetribunenews.R;
import com.example.thetribunenews.UrlActivity;
import com.example.thetribunenews.model.model;

import java.util.ArrayList;
import java.util.List;

public class MyHolder1 extends RecyclerView.ViewHolder implements View.OnClickListener{
    public ImageView image;
   public TextView newst, dat;
   public List<model> arrcon;
   Context context;

    public MyHolder1(@NonNull View itemView) {
        super(itemView);
//        itemView.setOnClickListener(this);
        image = itemView.findViewById(R.id.nimg);
        newst = itemView.findViewById(R.id.newstxt);
        dat = itemView.findViewById(R.id.date);
    }

    @Override
    public void onClick(View view) {
        int position = this.getAdapterPosition();
        model con = arrcon.get(position);
        Toast.makeText(context, "Position is " + con, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context,UrlActivity.class);
        context.startActivity(intent);
    }
}
