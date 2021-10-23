package com.example.prozrenie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class KidActivityAdapter extends RecyclerView.Adapter<KidActivityAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView activity_name;
        public ImageButton activity_button;
        public KidActivity kid_activity;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            activity_name = (TextView) itemView.findViewById(R.id.activity_name);
            activity_button = (ImageButton) itemView.findViewById(R.id.activity_image);
            activity_button.setOnClickListener(new View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View view) {
                                                      Context context = view.getContext();
                                                      Class ch_class = kid_activity.getmClass();
                                                      Intent intent = new Intent(context, ch_class);
                                                      context.startActivity(intent);

                                                  }
                                              }
            );

        }
    }

    @Override
    public KidActivityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View kidsView = inflater.inflate(R.layout.item_kids_choose, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(kidsView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(KidActivityAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        KidActivity kid_activity = mkidActivities.get(position);

        holder.kid_activity = kid_activity;

        // Set item views based on your views and data model
        TextView textView = holder.activity_name;
        textView.setText(kid_activity.getName());
        ImageButton button = holder.activity_button;
        button.setImageResource(kid_activity.getImage());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mkidActivities.size();
    }
    private List<KidActivity> mkidActivities;

    // Pass in the contact array into the constructor
    public KidActivityAdapter(List<KidActivity> kidActivities) {
        mkidActivities = kidActivities;
    }
}

