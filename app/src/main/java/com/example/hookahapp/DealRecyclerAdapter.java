package com.example.hookahapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import data.DealDTO;

class DealRecyclerAdapter extends RecyclerView.Adapter<DealRecyclerAdapter.ViewHolder> {

    private List<DealDTO> data = new ArrayList<>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.deal_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DealDTO deal = data.get(position);
        holder.dealName.setText(deal.getDealName());
        Glide.with(holder.itemView.getContext())
                .load(deal.getPicAdress())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.dealImage);
    }
    @Inject
    public DealRecyclerAdapter(){
        DealDTO temp = new DealDTO();
        temp.setDealName("aaaaaaaaaaaaaa");
        data.add(temp);
        data.add(temp);
        data.add(temp);
        data.add(temp);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setItems(List<DealDTO> newData){
        data.addAll(newData);
        notifyDataSetChanged();
    }

    public void addNewDeal(DealDTO newDeal){
        data.add(0, newDeal);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView dealName;
        ImageView dealImage;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            dealName = itemView.findViewById(R.id.deal_item_text);
            dealImage = itemView.findViewById(R.id.deal_item_image);
        }
    }
}
