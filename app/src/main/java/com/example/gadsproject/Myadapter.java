package com.example.gadsproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    @NonNull
private List<Listitem> listitems;
    private Context context;

    public Myadapter(@NonNull List<Listitem> list, Context context) {
        this.listitems = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.iq_list, parent,false);


        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
Listitem listitem=listitems.get(position);

holder.name1.setText(listitem.getName());
        holder.score.setText(listitem.getScore());
        holder.name2.setText(listitem.getCountry());
        Picasso.with(context).load(listitem.getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name1,name2,score;
        public ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name1=itemView.findViewById(R.id.name1);
            name2=itemView.findViewById(R.id.name2);
            score=itemView.findViewById(R.id.score);
            image=itemView.findViewById(R.id.img);

        }
    }
}
