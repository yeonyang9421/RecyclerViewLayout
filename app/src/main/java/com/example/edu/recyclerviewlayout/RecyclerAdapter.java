package com.example.edu.recyclerviewlayout;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    ArrayList<HashMap<String, Object>> arrayList = null;


    public RecyclerAdapter(ArrayList<HashMap<String, Object>> arrayList) {
        this.arrayList = new ArrayList<HashMap<String, Object>>();
        this.arrayList = arrayList;
    }

    public  void addItem(int position, HashMap<String,Object> hashMap){
        this.arrayList.add(hashMap);
        notifyItemInserted(position);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_cardlayout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        HashMap<String, Object> hashMap = arrayList.get(position);
        holder.item_title.setText((String) hashMap.get("title"));
        holder.item_detail.setText((String) hashMap.get("detail"));
        holder.item_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), holder.item_detail.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.item_image.setImageResource((Integer) hashMap.get("image"));
        holder.item_title.setText("0");
        holder.item_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(this, v.getText, Toast.LENGTH_SHORT).show();
                Integer count = Integer.parseInt(((TextView)holder.item_title).getText().toString()) + 1;
                ((TextView) holder.item_title).setText(count.toString());

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView item_image;
        public TextView item_title;
        public TextView item_detail;


        public MyViewHolder(@NonNull View view) {
            super(view);
            item_image = (ImageView) itemView.findViewById(R.id.item_image);
            item_title = (TextView) itemView.findViewById(R.id.item_title);
            item_detail = (TextView) itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    removeItem(position);
                    Log.d("ViewHolder Click", position + "," + getItemId());
                }
            });
        }
    }

    public void removeItem(int position) {
        this.arrayList.remove(position);
        notifyDataSetChanged();
    }
}
