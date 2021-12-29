package com.example.prozrenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GamesActivity3WithCategoriesSubCats2 extends AppCompatActivity {
    ArrayList<GameCategory> gamesList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gametype_choose);
        gamesList.add(new GameCategory("4-ый лишний", R.drawable.g4th_1_3, GamesActivity3_4thExtra.class));
        gamesList.add(new GameCategory("Выбери нужный", R.drawable.g_cr_1_1, GamesActivity3_ChooseRight.class));
        gamesList.add(new GameCategory("Найди пару", R.drawable.find_pair_1_3, GamesActivity3_FindPair.class));
        gamesList.add(new GameCategory("Реши пример", R.drawable.solve_expr, GamesActivity3_SolveExpr.class));

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