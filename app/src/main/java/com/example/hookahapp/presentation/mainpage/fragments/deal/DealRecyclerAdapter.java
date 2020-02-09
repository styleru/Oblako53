package com.example.hookahapp.presentation.mainpage.fragments.deal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hookahapp.R;
import com.example.hookahapp.domain.entities.DealDTO;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DealRecyclerAdapter extends RecyclerView.Adapter<DealRecyclerAdapter.ViewHolder> {

    private List<DealDTO> data = new ArrayList<>();
    private RecyclerItemClickListener clickListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.deal_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(v);
        v.setOnClickListener(v1 -> clickListener.itemClicked(v1, viewHolder.getAdapterPosition()));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DealDTO deal = data.get(position);

        holder.dealName.setText(deal.getName());
        Glide.with(holder.itemView.getContext())
                .load(deal.getPhoto())
//                .load(R.drawable.logo_picture)
                .placeholder(R.drawable.placeholder)
                .centerCrop()
                .into(holder.dealImage);
    }
    @Inject
    public DealRecyclerAdapter(RecyclerItemClickListener clickListener){
        this.clickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setItems(List<DealDTO> newData){
        data.clear();
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
            itemView.setClipToOutline(true);
            dealName = itemView.findViewById(R.id.deal_item_text);
            dealImage = itemView.findViewById(R.id.deal_item_image);

        }
    }

    public DealDTO getDeal(int position){
        return data.get(position);
    }
}
