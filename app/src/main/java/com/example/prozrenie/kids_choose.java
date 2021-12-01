package com.example.prozrenie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class kids_choose extends AppCompatActivity {
    ArrayList<KidActivity> kid_activities = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_choose);
        kid_activities.add(new KidActivity("Игры", R.drawable.kids_game, GamesActivity.class));
        kid_activities.add(new KidActivity("Аудио сказки", R.drawable.music_logo, AudioStoriesActivity.class));
        RecyclerView rvDocuments = (RecyclerView) findViewById(R.id.kids_activities_list);

        // Initialize contacts
        // Create adapter passing in the sample user data
        KidActivityAdapter adapter = new KidActivityAdapter(kid_activities);
        // Attach the adapter to the recyclerview to populate items
        rvDocuments.setAdapter(adapter);
        // Set layout manager to position the items
        rvDocuments.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}