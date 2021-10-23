package com.example.prozrenie;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class AudioStoryAdapter extends RecyclerView.Adapter<AudioStoryAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView story_name;
        public ImageButton story_button;
        public AudioStories audio_story;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            story_name = (TextView) itemView.findViewById(R.id.story_name);
            story_button = (ImageButton) itemView.findViewById(R.id.story_button);
            story_button.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View view) {
                                                       Context context = view.getContext();
                                                       Intent intent = new Intent(context, StoryListenActivity.class);
                                                       intent.putExtra("name", audio_story.getName());
                                                       intent.putExtra("image", audio_story.getImage());
                                                       intent.putExtra("source", audio_story.getSource());
                                                       context.startActivity(intent);

                                                   }
                                               }
            );

        }
    }

    @Override
    public AudioStoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View storyView = inflater.inflate(R.layout.item_stories, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(storyView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(AudioStoryAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        AudioStories audio_story = mStoriesList.get(position);

        holder.audio_story = audio_story;

        // Set item views based on your views and data model
        TextView textView = holder.story_name;
        textView.setText(audio_story.getName());
        ImageButton button = holder.story_button;
        button.setImageResource(audio_story.getImage());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mStoriesList.size();
    }
    private List<AudioStories> mStoriesList;

    // Pass in the contact array into the constructor
    public AudioStoryAdapter(List<AudioStories> Stories) {
        mStoriesList = Stories;
    }
}