package com.example.prozrenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GamesActivity4_FindDescription extends AppCompatActivity {
    ArrayList<MatchGameType> gamesList = new ArrayList<>();
    Map<Integer, Integer>[] imageDictionary = new Map[]{
            new HashMap<Integer, Integer>(){{
                put(R.drawable.g4_descr_w_1, R.drawable.g4_descr_w_1_1);
                put(R.drawable.g4_descr_w_2, R.drawable.g4_descr_w_2_1);
                put(R.drawable.g4_descr_w_3, R.drawable.g4_descr_w_3_1);
            }},
            new HashMap<Integer, Integer>(){{
                put(R.drawable.g4_descr_w2_1, R.drawable.g4_descr_w2_1_1);
                put(R.drawable.g4_descr_w2_2, R.drawable.g4_descr_w2_2_1);
                put(R.drawable.g4_descr_w2_3, R.drawable.g4_descr_w2_3_1);
            }},
    };

    //TODO GAMES CLASS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_game_choose);
        gamesList.add(new MatchGameType("Найди по описанию", R.drawable.g4_descr_w_1_1, imageDictionary[0], R.raw.find_by_descr));
        gamesList.add(new MatchGameType("Найди по описанию", R.drawable.g4_descr_w2_1_1, imageDictionary[1], R.raw.find_by_descr));


        RecyclerView rvDocuments = (RecyclerView) findViewById(R.id.games_list);

        // Initialize contacts
        // Create adapter passing in the sample user data
        MGChooseAdapter adapter = new MGChooseAdapter(gamesList);
        // Attach the adapter to the recyclerview to populate items
        rvDocuments.setAdapter(adapter);
        // Set layout manager to position the items
        rvDocuments.setLayoutManager(new LinearLayoutManager(this));
    }
}