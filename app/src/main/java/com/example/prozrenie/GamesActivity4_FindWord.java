package com.example.prozrenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GamesActivity4_FindWord extends AppCompatActivity {
    ArrayList<MatchGameType> gamesList = new ArrayList<>();
    Map<Integer, Integer>[] imageDictionary = new Map[]{
            new HashMap<Integer, Integer>(){{
                put(R.drawable.g4_words_1, R.drawable.g4_words_1_1);
                put(R.drawable.g4_words_2, R.drawable.g4_words_2_1);
                put(R.drawable.g4_words_3, R.drawable.g4_words_3_1);
                put(R.drawable.g4_words_4, R.drawable.g4_words_4_1);
            }},
            new HashMap<Integer, Integer>(){{
                put(R.drawable.g4_words2_1, R.drawable.g4_words2_1_1);
                put(R.drawable.g4_words2_2, R.drawable.g4_words2_2_2);
                put(R.drawable.g4_words2_3, R.drawable.g4_words2_3_1);
            }},
    };

    //TODO GAMES CLASS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_game_choose);
        gamesList.add(new MatchGameType("Сложные слова 1", R.drawable.g4_words_1_1, imageDictionary[0], R.raw.find_similar_words));
        gamesList.add(new MatchGameType("Сложные слова 2", R.drawable.g4_words2_1_1, imageDictionary[1], R.raw.find_similar_words));

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