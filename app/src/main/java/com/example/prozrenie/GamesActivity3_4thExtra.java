package com.example.prozrenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GamesActivity3_4thExtra extends AppCompatActivity {
    ArrayList<ChooseRightGameType> gamesList = new ArrayList<>();
    Map<Integer, Boolean>[] imageDictionary = new Map[]{
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g4th_1_1, true);
                put(R.drawable.g4th_1_2, false);
                put(R.drawable.g4th_1_3, false);
                put(R.drawable.g4th_1_4, false);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g4th_2_1, true);
                put(R.drawable.g4th_2_2, false);
                put(R.drawable.g4th_2_3, false);
                put(R.drawable.g4th_2_4, false);

            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g4th_3_1, true);
                put(R.drawable.g4th_3_2, false);
                put(R.drawable.g4th_3_3, false);
                put(R.drawable.g4th_3_4, false);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g4th_4_1, true);
                put(R.drawable.g4th_4_2, false);
                put(R.drawable.g4th_4_3, false);
                put(R.drawable.g4th_4_4, false);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g4th_5_1, false);
                put(R.drawable.g4th_5_2, false);
                put(R.drawable.g4th_5_3, true);
                put(R.drawable.g4th_5_4, false);
            }},
    };

    //TODO GAMES CLASS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_right_game_choose);
        gamesList.add(new ChooseRightGameType("Одежда", R.drawable.g4th_1_4, imageDictionary[0], R.raw.g4th_extra, false));
        gamesList.add(new ChooseRightGameType("Рыбы", R.drawable.g4th_2_3, imageDictionary[1], R.raw.g4th_extra, false));
        gamesList.add(new ChooseRightGameType("Бытовые предметы", R.drawable.g4th_3_3, imageDictionary[2], R.raw.g4th_extra, false));
        gamesList.add(new ChooseRightGameType("Инструменты", R.drawable.g4th_4_3, imageDictionary[3], R.raw.g4th_extra, false));
        gamesList.add(new ChooseRightGameType("Фрукты", R.drawable.g4th_5_1, imageDictionary[4], R.raw.g4th_extra, false));





        RecyclerView rvDocuments = (RecyclerView) findViewById(R.id.games_list);

        // Initialize contacts
        // Create adapter passing in the sample user data
        CRGChooseAdapter adapter = new CRGChooseAdapter(gamesList);
        // Attach the adapter to the recyclerview to populate items
        rvDocuments.setAdapter(adapter);
        // Set layout manager to position the items
        rvDocuments.setLayoutManager(new LinearLayoutManager(this));
    }
}