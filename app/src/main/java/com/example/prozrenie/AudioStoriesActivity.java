package com.example.prozrenie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AudioStoriesActivity extends AppCompatActivity {
    ArrayList<AudioStories> storiesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_stories);
        storiesList.add(new AudioStories("Сказка про белочку-припевочку", R.drawable.squirrel, R.raw.story_about_belochka_prip));
        storiesList.add(new AudioStories("Сказка \"Случай в лесу\"", R.drawable.hare, R.raw.situation_in_forest));
        storiesList.add(new AudioStories("Сказка про ёжика Витю", R.drawable.hedgehog, R.raw.story_about_ezhik_vitya));
        storiesList.add(new AudioStories("Сказка \"О медвежонке\"", R.drawable.bear, R.raw.story_about_small_bear));
        storiesList.add(new AudioStories("Сказка \"О маленьком тигренке\"", R.drawable.tiger, R.raw.story_about_small_tiger));
        storiesList.add(new AudioStories("Сказка про Тобика", R.drawable.dog, R.raw.story_about_tobik));
        storiesList.add(new AudioStories("Сказка \"Роза и ромашка\"", R.drawable.rose_and_romashka, R.raw.story_rose_romashka));
        storiesList.add(new AudioStories("Сказка \"О маленьком гноме\"", R.drawable.gnome, R.raw.story_small_gnom));


        RecyclerView rvDocuments = (RecyclerView) findViewById(R.id.stories_list);

        // Initialize contacts
        // Create adapter passing in the sample user data
        AudioStoryAdapter adapter = new AudioStoryAdapter(storiesList);
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