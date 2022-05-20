package com.example.prozrenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GamesActivity3_RememberAndChoose extends AppCompatActivity {
    ArrayList<RememberAndRepeatGameType> gamesList = new ArrayList<>();
    Map<Integer, Boolean>[] imageDictionary = new Map[]{
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g_rc_1_1, true);
                put(R.drawable.g_rc_1_2, false);
                put(R.drawable.g_rc_1_3, false);
                put(R.drawable.g_rc_1_4, false);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g_rc_2_1, true);
                put(R.drawable.g_rc_2_2, false);
                put(R.drawable.g_rc_2_3, false);
                put(R.drawable.g_rc_2_4, false);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g_rc_3_1, true);
                put(R.drawable.g_rc_3_2, false);
                put(R.drawable.g_rc_3_3, false);
                put(R.drawable.g_rc_3_4, false);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g_rc_4_1, true);
                put(R.drawable.g_rc_4_2, false);
                put(R.drawable.g_rc_4_3, false);
                put(R.drawable.g_rc_4_4, false);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g_rc_5_1, true);
                put(R.drawable.g_rc_5_2, false);
                put(R.drawable.g_rc_5_3, false);
                put(R.drawable.g_rc_5_4, false);
            }},
    };

    //TODO GAMES CLASS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_right_game_choose);
        gamesList.add(new RememberAndRepeatGameType("Фигуры 1", R.drawable.g_rc_1_1, imageDictionary[0], R.raw.remember_figure));
        gamesList.add(new RememberAndRepeatGameType("Фигуры 2", R.drawable.g_rc_2_1, imageDictionary[1], R.raw.remember_figure));
        gamesList.add(new RememberAndRepeatGameType("Фигуры 3", R.drawable.g_rc_3_1, imageDictionary[2], R.raw.remember_figure));
        gamesList.add(new RememberAndRepeatGameType("Фигуры 4", R.drawable.g_rc_4_1, imageDictionary[3], R.raw.remember_figure));
        gamesList.add(new RememberAndRepeatGameType("Фигуры 5", R.drawable.g_rc_5_1, imageDictionary[4], R.raw.remember_figure));







        RecyclerView rvDocuments = (RecyclerView) findViewById(R.id.games_list);

        // Initialize contacts
        // Create adapter passing in the sample user data
        RememberAndChooseAdapter adapter = new RememberAndChooseAdapter(gamesList);
        // Attach the adapter to the recyclerview to populate items
        rvDocuments.setAdapter(adapter);
        // Set layout manager to position the items
        rvDocuments.setLayoutManager(new LinearLayoutManager(this));
    }
}