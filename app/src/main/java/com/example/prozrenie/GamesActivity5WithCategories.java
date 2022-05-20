package com.example.prozrenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GamesActivity5WithCategories extends AppCompatActivity {
    ArrayList<GameCategory> gamesList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gametype_choose);
        gamesList.add(new GameCategory("Вставь пропущенную картинку", R.drawable.g5_main, GamesActivity5_ChooseRight.class));
        gamesList.add(new GameCategory("Выбери эмоцию", R.drawable.g5_ce_main1, GamesActivity5_ChooseEmotion.class));




        RecyclerView rvDocuments = (RecyclerView) findViewById(R.id.games_list);

        // Initialize contacts
        // Create adapter passing in the sample user data
        GameCategoryChooseAdapter adapter = new GameCategoryChooseAdapter(gamesList);
        // Attach the adapter to the recyclerview to populate items
        rvDocuments.setAdapter(adapter);
        // Set layout manager to position the items
        rvDocuments.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}