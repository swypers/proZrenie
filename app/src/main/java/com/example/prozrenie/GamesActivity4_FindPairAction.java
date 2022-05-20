package com.example.prozrenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GamesActivity4_FindPairAction extends AppCompatActivity {
    ArrayList<MatchGameType> gamesList = new ArrayList<>();
    Map<Integer, Integer>[] imageDictionary = new Map[]{
            new HashMap<Integer, Integer>(){{
                put(R.drawable.g4_act_1, R.drawable.g4_action_3);
                put(R.drawable.g4_act_2, R.drawable.g4_action_1);
                put(R.drawable.g4_act_3, R.drawable.g4_action_2);
                put(R.drawable.g4_act_4, R.drawable.g4_action_4);
            }},
            new HashMap<Integer, Integer>(){{
                put(R.drawable.g4_act2_1, R.drawable.g4_action2_1);
                put(R.drawable.g4_act2_2, R.drawable.g4_action2_2);
                put(R.drawable.g4_act2_3, R.drawable.g4_action2_3);
                put(R.drawable.g4_act2_4, R.drawable.g4_action2_4);
            }},
    };

    //TODO GAMES CLASS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_game_choose);
        gamesList.add(new MatchGameType("Животные 1", R.drawable.g4_act_1, imageDictionary[0], R.raw.find_action));
        gamesList.add(new MatchGameType("Животные 2", R.drawable.g4_act2_2, imageDictionary[1], R.raw.find_action));



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