package com.example.prozrenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GamesActivity5_ChooseEmotion extends AppCompatActivity {
    ArrayList<ChooseRightGameType> gamesList = new ArrayList<>();
    Map<Integer, Boolean>[] imageDictionary = new Map[]{
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g5_ce1_1, true);
                put(R.drawable.g5_ce1_2, false);
                put(R.drawable.g5_ce1_3, false);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g5_ce2_1, false);
                put(R.drawable.g5_ce2_2, false);
                put(R.drawable.g5_ce2_3, true);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g5_ce3_1, false);
                put(R.drawable.g5_ce3_2, false);
                put(R.drawable.g5_ce3_3, true);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g5_ce4_1, false);
                put(R.drawable.g5_ce4_2, true);
                put(R.drawable.g5_ce4_3, false);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g5_ce5_1, false);
                put(R.drawable.g5_ce5_2, false);
                put(R.drawable.g5_ce5_3, true);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g5_ce6_1, true);
                put(R.drawable.g5_ce6_2, false);
                put(R.drawable.g5_ce6_3, false);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.g5_ce7_1, true);
                put(R.drawable.g5_ce7_2, false);
                put(R.drawable.g5_ce7_3, false);
            }},
    };

    //TODO GAMES CLASS

    @Override
    protected void onCreate(Bundle savedInstanceState) { // TODO CHANGE SOUND ->
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_right_game_choose);
        gamesList.add(new ChooseRightGameType("Грусть", R.drawable.g5_ce_main1, imageDictionary[0], R.raw.insert_emotion, true));
        gamesList.add(new ChooseRightGameType("Смущение", R.drawable.g5_ce_main2, imageDictionary[1], R.raw.insert_emotion, true));
        gamesList.add(new ChooseRightGameType("Обида", R.drawable.g5_ce_main3, imageDictionary[2], R.raw.insert_emotion, true));
        gamesList.add(new ChooseRightGameType("Недовольство", R.drawable.g5_ce_main4, imageDictionary[3], R.raw.insert_emotion, true));
        gamesList.add(new ChooseRightGameType("Счастье", R.drawable.g5_ce_main5, imageDictionary[4], R.raw.insert_emotion, true));
        gamesList.add(new ChooseRightGameType("Страх", R.drawable.g5_ce_main6, imageDictionary[5], R.raw.insert_emotion, true));
        gamesList.add(new ChooseRightGameType("Радость", R.drawable.g5_ce_main7, imageDictionary[6], R.raw.insert_emotion, true));








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