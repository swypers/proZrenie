package com.example.prozrenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GamesActivity4WithCategories extends AppCompatActivity {
    ArrayList<GameCategory> gamesList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gametype_choose);
        gamesList.add(new GameCategory("Найти предметы которые начинаются на определенный звук", R.drawable.g4_fs_a_1, GamesActivity4_FirstSound.class));
        gamesList.add(new GameCategory("Подбери картинку к слову", R.drawable.g4_act_1, GamesActivity4_FindPairAction.class));
        gamesList.add(new GameCategory("Подбери пары слов, которые начинаются на один звук", R.drawable.g4_ps_2, GamesActivity4_FindPairSound.class));
        gamesList.add(new GameCategory("Составь слова", R.drawable.g4_words_1, GamesActivity4_FindWord.class));
        gamesList.add(new GameCategory("Угадай по описанию", R.drawable.g4_descr_w_1, GamesActivity4_FindDescription.class));




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