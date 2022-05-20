package com.example.prozrenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GamesActivity4_FirstSound extends AppCompatActivity {
    ArrayList<ChooseRightGameType> gamesList = new ArrayList<>();
    Map<Integer, Boolean>[] imageDictionary = new Map[]{
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g4_fs_a_1, true);
                put(R.drawable.g4_fs_a_2, false);
                put(R.drawable.g4_fs_a_3, false);
                put(R.drawable.g4_fs_a_4, true);
                put(R.drawable.g4_fs_a_5, true);
                put(R.drawable.g4_fs_a_6, true);
                put(R.drawable.g4_fs_a_7, true);
                put(R.drawable.g4_fs_a_8, true);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g4_fs_b_1, false);
                put(R.drawable.g4_fs_b_2, true);
                put(R.drawable.g4_fs_b_3, true);
                put(R.drawable.g4_fs_b_4, true);
                put(R.drawable.g4_fs_b_5, true);
                put(R.drawable.g4_fs_b_6, true);
                put(R.drawable.g4_fs_b_7, false);
                put(R.drawable.g4_fs_b_8, false);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g4_fs_m_1, false);
                put(R.drawable.g4_fs_m_2, true);
                put(R.drawable.g4_fs_m_3, true);
                put(R.drawable.g4_fs_m_4, true);
                put(R.drawable.g4_fs_m_5, true);
                put(R.drawable.g4_fs_m_6, true);
                put(R.drawable.g4_fs_m_7, false);
                put(R.drawable.g4_fs_m_8, false);
            }},
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_right_game_choose);
        gamesList.add(new ChooseRightGameType("Звук A", R.drawable.g4_fs_a_8, imageDictionary[0], R.raw.first_sound_a, false));
        gamesList.add(new ChooseRightGameType("Звук Б", R.drawable.g4_fs_b_4, imageDictionary[1], R.raw.first_sound_b, false));
        gamesList.add(new ChooseRightGameType("Звук М", R.drawable.g4_fs_m_4, imageDictionary[2], R.raw.first_sound_m, false));







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