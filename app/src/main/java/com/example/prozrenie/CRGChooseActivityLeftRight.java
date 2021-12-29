package com.example.prozrenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CRGChooseActivityLeftRight extends AppCompatActivity {
    ArrayList<ChooseRightGameType> gamesList = new ArrayList<>();
    Map<Integer, Boolean>[] imageDictionary = new Map[]{
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.left1, true);
                put(R.drawable.left2, true);
                put(R.drawable.right1, false);
                put(R.drawable.left3, true);

            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.right1, false);
                put(R.drawable.right2, false);
                put(R.drawable.left1, true);
                put(R.drawable.left4, true); // TODO AddGame FOR RIGHT GOING CARS + SOUND

            }},
    };

    //TODO GAMES CLASS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_right_game_choose);
        gamesList.add(new ChooseRightGameType("Лево", R.drawable.left1, imageDictionary[0], R.raw.left_right, false));
        gamesList.add(new ChooseRightGameType("Право", R.drawable.right1, imageDictionary[1], R.raw.left_right, false));





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