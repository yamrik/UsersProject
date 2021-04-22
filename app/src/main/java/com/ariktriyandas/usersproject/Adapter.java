package com.ariktriyandas.usersproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterHolder> {
    private Context context;
    private List<GetData> datalist;
    public Adapter(Context context, List<GetData> datalist){
        this.context = context;
        this.datalist = datalist;

    }
    @NonNull
    @Override
    public Adapter.AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
        AdapterHolder holder = new AdapterHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.AdapterHolder holder, int position) {
        final GetData getData = datalist.get(position);
        int id = getData.getId();
        String username = getData.getUsername();
        String name = getData.getName();
        String email = getData.getEmail();

        holder.id.setText("ID :" + id);
        holder.username.setText("Username :" + username);
        holder.name.setText("Name :" + name);
        holder.email.setText("Email :" + email);


    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        TextView id,username,name,email;
        ImageView icon;
        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            username = itemView.findViewById(R.id.username);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            icon = itemView.findViewById(R.id.icon);
        }
    }
}
