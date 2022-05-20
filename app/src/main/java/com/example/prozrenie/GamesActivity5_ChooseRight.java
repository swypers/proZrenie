package com.example.prozrenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GamesActivity5_ChooseRight extends AppCompatActivity {
    ArrayList<ChooseRightGameType> gamesList = new ArrayList<>();
    Map<Integer, Boolean>[] imageDictionary = new Map[]{
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g5_cr_1, true);
                put(R.drawable.g5_cr_2, false);
                put(R.drawable.g5_cr_3, false);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g5_cr2_1, false);
                put(R.drawable.g5_cr2_2, true);
                put(R.drawable.g5_cr2_3, false);
                put(R.drawable.g5_cr2_4, false);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g5_cr3_1, false);
                put(R.drawable.g5_cr3_2, true);
                put(R.drawable.g5_cr3_3, false);
            }},
    };

    //TODO GAMES CLASS

    @Override
    protected void onCreate(Bundle savedInstanceState) { // TODO CHANGE SOUND ->
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_right_game_choose);
        gamesList.add(new ChooseRightGameType("Девочки", R.drawable.g5_main, imageDictionary[0], R.raw.insert_emotion, true));
        gamesList.add(new ChooseRightGameType("Смайлики", R.drawable.g5_main2, imageDictionary[1], R.raw.insert_emotion, true));
        gamesList.add(new ChooseRightGameType("Лягушки", R.drawable.g5_main3, imageDictionary[2], R.raw.insert_emotion, true));






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