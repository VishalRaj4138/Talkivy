package com.example.talkivy;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{

    Context context;
    ArrayList<String> usernameslist;

    public MyAdapter(Context context, ArrayList<String> usernameslist) {
        this.context = context;
        this.usernameslist = usernameslist;
    }

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.recycler_item,parent,false);

        return new MyViewHolder(view);

    }


    //here u can make the on click to the desired layout u want

    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position)
    {

        holder.textView.setText(usernameslist.get(position).toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context,"Going to "+holder.textView.getText().toString(),Toast.LENGTH_SHORT).show();

                //you can add the intent part for Navigation...................


            }
        });

    }


    public int getItemCount()
    {
        return usernameslist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {


        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.recycleritem_username);

        }
    }
}

