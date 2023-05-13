package com.example.thetribunenews.ImageSlider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thetribunenews.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class autoImage extends SliderViewAdapter<autoImage.SliderViewHolder> {

    int [] images;

    public autoImage(int[] images) {
        this.images = images;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.autoimageslide , parent , false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {

        viewHolder.img.setImageResource(images[position]);

    }

    @Override
    public int getCount() {
        return images.length;
    }

    public class SliderViewHolder extends SliderViewAdapter.ViewHolder{

        ImageView img;
        public SliderViewHolder(View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.imageslide);
        }
    }
}