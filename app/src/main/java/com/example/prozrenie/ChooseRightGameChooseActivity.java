package com.example.prozrenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChooseRightGameChooseActivity extends AppCompatActivity {
    ArrayList<ChooseRightGameType> gamesList = new ArrayList<>();
    Map<Integer, Boolean>[] imageDictionary = new Map[]{
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.triangle1, true);
                put(R.drawable.circle1, false);
                put(R.drawable.triangle4, true);
                put(R.drawable.triangle3, true);
                put(R.drawable.square2, false);
                put(R.drawable.square4, false);
                put(R.drawable.rectangle2, false);
                put(R.drawable.rectangle3, false);

            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.square1, true);
                put(R.drawable.triangle3, false);
                put(R.drawable.square2, true);
                put(R.drawable.square4, true);
                put(R.drawable.rectangle2, false);
                put(R.drawable.rectangle3, false);
                put(R.drawable.rectangle4, false);
                put(R.drawable.triangle4, false);

            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.rectangle2, true);
                put(R.drawable.triangle3, false);
                put(R.drawable.rectangle3, true);
                put(R.drawable.rectangle4, true);
                put(R.drawable.circle1, false);
                put(R.drawable.triangle1, false);
                put(R.drawable.circle3, false);
                put(R.drawable.circle4, false);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.circle1, true);
                put(R.drawable.rectangle4, false);
                put(R.drawable.circle3, true);
                put(R.drawable.circle4, true);
                put(R.drawable.rectangle2, false);
                put(R.drawable.triangle3, false);
                put(R.drawable.rectangle3, false);
                put(R.drawable.square4, false);
            }},
            new HashMap<Integer, Boolean>(){{
                put(R.drawable.rectangle_blue, true);
                put(R.drawable.romb_green, false);
                put(R.drawable.triangle_green, false);
                put(R.drawable.triangle_red, false);
            }},
    };

    //TODO GAMES CLASS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_right_game_choose);
        gamesList.add(new ChooseRightGameType("Похожие на треугольник", R.drawable.triangle3, imageDictionary[0], R.raw.pohozhi_triangle, false));
        gamesList.add(new ChooseRightGameType("Похожие на квадрат", R.drawable.square2, imageDictionary[1], R.raw.pohozhi_square, false));
        gamesList.add(new ChooseRightGameType("Похожие на прямоугольник", R.drawable.rectangle2, imageDictionary[2], R.raw.pohozhi_rectangle, false));
        gamesList.add(new ChooseRightGameType("Похожие на круг", R.drawable.circle3, imageDictionary[3], R.raw.pohozhi_circle, false));
        gamesList.add(new ChooseRightGameType("Продолжи ряд по аналогии", R.drawable.ryad_figure, imageDictionary[4], R.raw.prodolzhi_ryad, true));





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