package com.eco.ecomarket.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eco.ecomarket.Model.ProfileWidgetModel;
import com.eco.ecomarket.R;
import com.eco.ecomarket.Interface.RecyclerViewInterface;

import java.util.ArrayList;


public class ProfileWidgetAdapter extends RecyclerView.Adapter<ProfileWidgetAdapter.MyViewHolder>{
    private final RecyclerViewInterface recyclerViewInterface;
    private Context context;
    private ArrayList<ProfileWidgetModel> profileWidgetModels;

    public ProfileWidgetAdapter(Context context,ArrayList<ProfileWidgetModel> profileWidgetModels,RecyclerViewInterface recyclerViewInterface) {
    this.context=context;
    this.profileWidgetModels=profileWidgetModels;
    this.recyclerViewInterface=recyclerViewInterface;
    }

    @NonNull
    @Override
    public ProfileWidgetAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.profile_layout,parent,false);
        return new ProfileWidgetAdapter.MyViewHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileWidgetAdapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(profileWidgetModels.get(position).getIcon());
        holder.title.setText(profileWidgetModels.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return profileWidgetModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title;
        public MyViewHolder(@NonNull View itemView,RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageView=itemView.findViewById(R.id.widget_image);
            title=itemView.findViewById(R.id.profile_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface !=null){
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            recyclerViewInterface.OnItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
