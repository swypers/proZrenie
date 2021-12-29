package com.example.prozrenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GamesActivity3_FindPair extends AppCompatActivity {
    ArrayList<MatchGameType> gamesList = new ArrayList<>();
    Map<Integer, Integer>[] imageDictionary = new Map[]{
            new HashMap<Integer, Integer>(){{
                put(R.drawable.find_pair_1_1, R.drawable.find_pair_1_1_1);
                put(R.drawable.find_pair_1_2, R.drawable.find_pair_1_2_1);
                put(R.drawable.find_pair_1_3, R.drawable.find_pair_1_3_1);
                put(R.drawable.find_pair_1_4, R.drawable.find_pair_1_4_1);
            }},
            new HashMap<Integer, Integer>(){{
                put(R.drawable.find_pair_2_1, R.drawable.find_pair_2_1_1);
                put(R.drawable.find_pair_1_2, R.drawable.find_pair_1_2_1);
                put(R.drawable.find_pair_2_2, R.drawable.find_pair_2_2_1);
                put(R.drawable.find_pair_1_4, R.drawable.find_pair_1_4_1);
            }},
    };

    //TODO GAMES CLASS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_game_choose);
        gamesList.add(new MatchGameType("Подбери пару", R.drawable.find_pair_1_3, imageDictionary[0], R.raw.find_pair));
        gamesList.add(new MatchGameType("Материалы", R.drawable.find_pair_2_2_1, imageDictionary[1], R.raw.find_pair));


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