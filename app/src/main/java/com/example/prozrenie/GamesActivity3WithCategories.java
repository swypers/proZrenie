package com.example.prozrenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GamesActivity3WithCategories extends AppCompatActivity {
    ArrayList<GameCategory> gamesList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gametype_choose); // TODO REMOVE TOP TEXT FROM LAYOUTS INSIDES
        gamesList.add(new GameCategory("Внимание", R.drawable.match_logo, GamesActivity3WithCategoriesSubCats1.class));
        gamesList.add(new GameCategory("Мышление", R.drawable.g_cr_2_1, GamesActivity3WithCategoriesSubCats2.class));
        gamesList.add(new GameCategory("Память", R.drawable.logo2, GamesActivity3WithCategoriesSubCats3.class));
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