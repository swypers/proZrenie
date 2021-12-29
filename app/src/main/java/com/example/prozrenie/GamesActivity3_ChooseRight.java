package com.example.prozrenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GamesActivity3_ChooseRight extends AppCompatActivity {
    ArrayList<ChooseRightGameType> gamesList = new ArrayList<>();
    Map<Integer, Boolean>[] imageDictionary = new Map[]{
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g_cr_1_1, true);
                put(R.drawable.g_cr_1_2, false);
                put(R.drawable.g_cr_1_3, false);
                put(R.drawable.g_cr_1_4, false);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g_cr_2_1, false);
                put(R.drawable.g_cr_2_2, false);
                put(R.drawable.g_cr_2_3, true);
                put(R.drawable.g_cr_2_4, false);

            }},
    };

    //TODO GAMES CLASS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_right_game_choose);
        gamesList.add(new ChooseRightGameType("Конфеты", R.drawable.g_cr_1_3, imageDictionary[0], R.raw.choose_candy, false));
        gamesList.add(new ChooseRightGameType("Дома", R.drawable.g_cr_2_2, imageDictionary[1], R.raw.choose_house, false));





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