package com.example.prozrenie;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

public class MGChooseAdapter extends RecyclerView.Adapter<MGChooseAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView activity_name;
        public ImageButton activity_button;
        public MatchGameType game_type;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            activity_name = (TextView) itemView.findViewById(R.id.game_name);
            activity_button = (ImageButton) itemView.findViewById(R.id.game_image);
            activity_button.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View view) {
                                                       Context context = view.getContext();
                                                       Intent intent = new Intent(context,
                                                               MatchGameActivity.class);
                                                       intent.putExtra("imageDictionary",
                                                               (new Gson()).toJson(game_type));
                                                       context.startActivity(intent);
                                                   }
                                               }
            );

        }
    }

    @Override
    public MGChooseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View kidsView = inflater.inflate(R.layout.item_game_choose, parent, false);

        // Return a new holder instance
        MGChooseAdapter.ViewHolder viewHolder = new MGChooseAdapter.ViewHolder(kidsView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(MGChooseAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        MatchGameType game_type = mgameActivities.get(position);

        holder.game_type = game_type;

        // Set item views based on your views and data model
        TextView textView = holder.activity_name;
        textView.setText(game_type.getName());
        ImageButton button = holder.activity_button;
        button.setImageResource(game_type.getImage());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mgameActivities.size();
    }
    private List<MatchGameType> mgameActivities;

    // Pass in the contact array into the constructor
    public MGChooseAdapter(List<MatchGameType> gameActivities) {
        mgameActivities = gameActivities;
    }
}