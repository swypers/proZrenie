package com.example.prozrenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GamesActivity2 extends AppCompatActivity {
    ArrayList<Games> gamesList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        gamesList.add(new Games("Право-Лево", R.drawable.left3, CRGChooseActivityLeftRight.class));
        gamesList.add(new Games("Соотнеси схеме", R.drawable.schm_1, MatchGameSchemeChooseActivity.class));
        RecyclerView rvDocuments = (RecyclerView) findViewById(R.id.games_list);

        GamesActivityAdapter adapter = new GamesActivityAdapter(gamesList);
        rvDocuments.setAdapter(adapter);
        rvDocuments.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}