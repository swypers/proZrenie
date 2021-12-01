package com.example.prozrenie;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChooseRightGameChooseActivityNoisy extends AppCompatActivity {
    TextView header;
    ArrayList<ChooseRightGameType> gamesList = new ArrayList<>();
    Map<Integer, Boolean>[] imageDictionary = new Map[]{
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.noisy_animals1, true);
                put(R.drawable.noisy_animals2, true);
                put(R.drawable.noisy_animals3, true);
                put(R.drawable.noisy_animals4, true);
                put(R.drawable.noisy_animals5, false);
                put(R.drawable.noisy_animals6, true);
                put(R.drawable.noisy_animals7, false);
                put(R.drawable.noisy_toys1, false);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.noisy_toys1, true);
                put(R.drawable.noisy_toys2, true);
                put(R.drawable.noisy_toys3, true);
                put(R.drawable.noisy_toys4, true);
                put(R.drawable.noisy_toys5, true);
                put(R.drawable.noisy_toys6, false);
                put(R.drawable.noisy_toys7, false);
                put(R.drawable.noisy_animals6, false);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.noisy_veget1, true);
                put(R.drawable.noisy_veget2, true);
                put(R.drawable.noisy_veget3, true);
                put(R.drawable.noisy_veget4, true);
                put(R.drawable.noisy_veget5, true);
                put(R.drawable.noisy_veget6, false);
                put(R.drawable.noisy_veget7, false);
                put(R.drawable.noisy_animals2, false);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.noisy_dish1, true);
                put(R.drawable.noisy_dish2, true);
                put(R.drawable.noisy_dish3, true);
                put(R.drawable.noisy_dish4, true);
                put(R.drawable.noisy_dish5, false);
                put(R.drawable.noisy_dish6, true);
                put(R.drawable.noisy_dish7, false);
                put(R.drawable.noisy_animals2, false);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.noisy_transp1, true);
                put(R.drawable.noisy_transp2, true);
                put(R.drawable.noisy_transp3, true);
                put(R.drawable.noisy_transp4, true);
                put(R.drawable.noisy_transp5, false);
                put(R.drawable.noisy_transp6, false);
                put(R.drawable.noisy_transp7, true);
                put(R.drawable.noisy_toys3, false);
            }},
    };

    //TODO GAMES CLASS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_right_game_choose);
        gamesList.add(new ChooseRightGameType("Животные", R.drawable.noisy_animals, imageDictionary[0], R.raw.noisy_images_sound, true));
        gamesList.add(new ChooseRightGameType("Игрушки", R.drawable.noisy_toys, imageDictionary[1], R.raw.noisy_images_sound, true));
        gamesList.add(new ChooseRightGameType("Овощи", R.drawable.noisy_veget, imageDictionary[2], R.raw.noisy_images_sound, true));
        gamesList.add(new ChooseRightGameType("Посуда", R.drawable.noisy_dish, imageDictionary[3], R.raw.noisy_images_sound, true));
        gamesList.add(new ChooseRightGameType("Транспорт", R.drawable.noisy_transp, imageDictionary[4], R.raw.noisy_images_sound, true));
        header = findViewById(R.id.header);
        header.setText("Зашумленные изображения");







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