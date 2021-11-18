package com.example.prozrenie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class GamesActivity extends AppCompatActivity {
    ArrayList<Games> gamesList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        gamesList.add(new Games("Найди пару", R.drawable.match_logo, MatchGameChooseActivity.class));
        gamesList.add(new Games("Выбери нужное", R.drawable.match_logo, ChooseRightGameChooseActivity.class));
        RecyclerView rvDocuments = (RecyclerView) findViewById(R.id.games_list);

        // Initialize contacts
        // Create adapter passing in the sample user data
        GamesActivityAdapter adapter = new GamesActivityAdapter(gamesList);
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