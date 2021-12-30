package com.example.prozrenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GamesActivity3_RepeatImage extends AppCompatActivity {
    ArrayList<RepeateImageGameType> gamesList = new ArrayList<>();
    Map<Integer, Integer[]>[] imageDictionary = new Map[]{
            new HashMap<Integer, Integer[]>(){{
                put(R.drawable.ri_images1, new Integer[]{1});
                put(R.drawable.ri_images2, new Integer[]{3});
                put(R.drawable.ri_images3, new Integer[]{8});
                put(R.drawable.ri_images4, new Integer[]{1});
            }},
            new HashMap<Integer, Integer[]>(){{
                put(R.drawable.ri_image_2_1, new Integer[]{1});
                put(R.drawable.ri_image_2_2, new Integer[]{6});
                put(R.drawable.ri_image_2_3, new Integer[]{7});
            }},
            new HashMap<Integer, Integer[]>(){{
                put(R.drawable.ri_1im, new Integer[]{1, 3, 8});
            }},
            new HashMap<Integer, Integer[]>(){{
                put(R.drawable.ri_1im, new Integer[]{2, 6, 7});
            }},
            new HashMap<Integer, Integer[]>(){{
                put(R.drawable.ri_1im, new Integer[]{3, 5, 7});
            }},
    };

    //TODO GAMES CLASS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_right_game_choose);
        gamesList.add(new RepeateImageGameType("Фигуры", R.drawable.ri_scheme, imageDictionary[0], R.raw.repeat_image, true,
                new Integer[]{3,3}));
        gamesList.add(new RepeateImageGameType("Пирожные", R.drawable.ri_scheme2, imageDictionary[1], R.raw.repeat_image, true,
                new Integer[]{3,3}));
        gamesList.add(new RepeateImageGameType("Точки (1)", R.drawable.ri_1im_sch_1, imageDictionary[2], R.raw.repeat_image, true,
                new Integer[]{3,3}));
        gamesList.add(new RepeateImageGameType("Точки (2)", R.drawable.ri_1im_sch_2, imageDictionary[3], R.raw.repeat_image, true,
                new Integer[]{3,3}));
        gamesList.add(new RepeateImageGameType("Точки (3)", R.drawable.ri_1im_sch_3, imageDictionary[4], R.raw.repeat_image, true,
                new Integer[]{3,3}));






        RecyclerView rvDocuments = (RecyclerView) findViewById(R.id.games_list);

        // Initialize contacts
        // Create adapter passing in the sample user data
        RepeatImageChooseAdapter adapter = new RepeatImageChooseAdapter(gamesList);
        // Attach the adapter to the recyclerview to populate items
        rvDocuments.setAdapter(adapter);
        // Set layout manager to position the items
        rvDocuments.setLayoutManager(new LinearLayoutManager(this));
    }
}