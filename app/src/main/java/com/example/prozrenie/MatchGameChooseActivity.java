package com.example.prozrenie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MatchGameChooseActivity extends AppCompatActivity {
    ArrayList<MatchGameType> gamesList = new ArrayList<>();
    Map<Integer, Integer>[] imageDictionary = new Map[]{
            new HashMap<Integer, Integer>(){{
                put(R.drawable.zaplatka_1, R.drawable.zaplatka_1_1);
                put(R.drawable.zaplatka_2, R.drawable.zaplatka_2_1);
                put(R.drawable.zaplatka_3, R.drawable.zaplatka_3_1);
                put(R.drawable.zaplatka_4, R.drawable.zaplatka_4_1);
            }},
            new HashMap<Integer, Integer>(){{
                put(R.drawable.frog_1, R.drawable.frog_leaf1);
                put(R.drawable.frog_2, R.drawable.frog_leaf2);
                put(R.drawable.frog_3, R.drawable.frog_leaf3);
                put(R.drawable.frog_4, R.drawable.frog_leaf4);
            }},
            new HashMap<Integer, Integer>(){{
                put(R.drawable.dog1, R.drawable.dog_booth1);
                put(R.drawable.dog2, R.drawable.dog_booth2);
                put(R.drawable.dog3, R.drawable.dog_booth3);
                put(R.drawable.dog4, R.drawable.dog_booth4);
            }},
            new HashMap<Integer, Integer>(){{
                put(R.drawable.dress1, R.drawable.dress_bow1);
                put(R.drawable.dress2, R.drawable.dress_bow2);
                put(R.drawable.dress3, R.drawable.dress_bow3);
                put(R.drawable.dress4, R.drawable.dress_bow4);
            }},
            new HashMap<Integer, Integer>(){{
                put(R.drawable.umbr1, R.drawable.umbr_boots1);
                put(R.drawable.umbr2, R.drawable.umbr_boots2);
                put(R.drawable.umbr3, R.drawable.umbr_boots3);
                put(R.drawable.umbr4, R.drawable.umbr_boots4);
            }},
    };

    //TODO GAMES CLASS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_game_choose);
        gamesList.add(new MatchGameType("Подбери заплатку нужной формы", R.drawable.zaplatka_1, imageDictionary[0], R.raw.pohozhi_triangle));
        gamesList.add(new MatchGameType("Найти каждой лягушке листочек такого же оттенка", R.drawable.frog_4, imageDictionary[1], R.raw.pohozhi_triangle));
        gamesList.add(new MatchGameType("Подбери  каждому щенку конуру такого же оттенка", R.drawable.dog1, imageDictionary[2], R.raw.pohozhi_triangle));
        gamesList.add(new MatchGameType("Подбери каждому платью бантик такого же оттенка", R.drawable.dress1, imageDictionary[3], R.raw.pohozhi_triangle));
        gamesList.add(new MatchGameType("Подбери сапожкам зонтик такого же цвета", R.drawable.umbr1, imageDictionary[4], R.raw.pohozhi_triangle));


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