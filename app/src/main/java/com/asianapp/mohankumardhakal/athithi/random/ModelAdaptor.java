package com.asianapp.mohankumardhakal.athithi.random;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asianapp.mohankumardhakal.athithi.R;

import java.util.List;

public class ModelAdaptor extends RecyclerView.Adapter<ModelAdaptor.ModelRecycleViewHolder> {

    Context mContext;
    List<ModelClass> itemList;

    public ModelAdaptor(Context mContext, List<ModelClass> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ModelRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_items, parent, false);
        return new ModelRecycleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelRecycleViewHolder holder, int position) {
        holder.title.setText(itemList.get(position).getTitle());
        holder.image.setImageResource(itemList.get(position).getImageId());
//        holder.description.setText(itemList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ModelRecycleViewHolder extends RecyclerView.ViewHolder {
        TextView title, description;
        ImageView image;

        public ModelRecycleViewHolder(@NonNull View itemView) {
            super(itemView);
//            description = itemView.findViewById(R.id.description);
            title = (TextView) itemView.findViewById(R.id.title);
            image = (ImageView) itemView.findViewById(R.id.hotelImage);
        }
    }

}
