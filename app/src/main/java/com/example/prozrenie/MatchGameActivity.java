package com.example.prozrenie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MatchGameActivity extends AppCompatActivity {
    MatchingGame GameClass;
    LinearLayout keyLayout, valLayout;
    Map<Integer, Integer> imageDictionary = new HashMap<Integer, Integer>();
    ImageView imageView;
    ImageButton helpButton;
    ImageButton backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_game);
        keyLayout = findViewById(R.id.key_images);
        valLayout = findViewById(R.id.value_images);
        imageView = findViewById(R.id.image_view);
        helpButton = findViewById(R.id.help_button);
        backButton = findViewById(R.id.back_button);
        imageDictionary = new Gson().fromJson(getIntent().getStringExtra("imageDictionary"),
                MatchGameType.class).getImageDictionary();
        Log.d("JSON", imageDictionary.toString());
        // fill imageDictionary


        GameClass = new MatchingGame("name", imageDictionary, keyLayout,
                valLayout, R.raw.story_small_gnom, imageView, this,
                helpButton, backButton);
        ArrayList<Integer> keyImages = new ArrayList<>(GameClass.getKeys());
        ArrayList<Integer> valImages = new ArrayList<>(GameClass.getValues());
        GameClass.onCreate();

    }
    public void onBackPressed() {
        super.onBackPressed();
        this.finishAndRemoveTask();
        GameClass.onClose();
    }
}