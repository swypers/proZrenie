package com.example.prozrenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GamesActivity3_Maze extends AppCompatActivity {
    ArrayList<RepeateImageGameType> gamesList = new ArrayList<>();
    Map<Integer, Integer[]>[] imageDictionary = new Map[]{
            new HashMap<Integer, Integer[]>(){{
                put(R.drawable.labyrint_1_1, new Integer[]{3});
                put(R.drawable.labyrint_1_2, new Integer[]{2});
                put(R.drawable.labyrint_1_3, new Integer[]{1});
            }},
    };

    //TODO GAMES CLASS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_right_game_choose);
        gamesList.add(new RepeateImageGameType("Фигуры", R.drawable.labyrint_1, imageDictionary[0], R.raw.repeat_image, true,
                new Integer[]{3,1}));
        RecyclerView rvDocuments = (RecyclerView) findViewById(R.id.games_list);

        // Initialize contacts
        // Create adapter passing in the sample user data
        MazeChooseAdapter adapter = new MazeChooseAdapter(gamesList);
        // Attach the adapter to the recyclerview to populate items
        rvDocuments.setAdapter(adapter);
        // Set layout manager to position the items
        rvDocuments.setLayoutManager(new LinearLayoutManager(this));
    }
}