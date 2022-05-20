package com.example.prozrenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GameCategoryChooseActivity extends AppCompatActivity {
    ArrayList<GameCategory> gamesList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gametype_choose);
        gamesList.add(new GameCategory("1. Зрительное восприятие", R.drawable.match_logo, GamesActivity.class));
        gamesList.add(new GameCategory("2. Ориентировка в пространстве", R.drawable.logo2, GamesActivity2.class));
        gamesList.add(new GameCategory("3. Психические процессы", R.drawable.g_rc_4_1, GamesActivity3WithCategories.class));
        gamesList.add(new GameCategory("4. Речь", R.drawable.logo2, GamesActivity4WithCategories.class));
        gamesList.add(new GameCategory("5. Эмоционально-волевая среда", R.drawable.logo2, GamesActivity5WithCategories.class));


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