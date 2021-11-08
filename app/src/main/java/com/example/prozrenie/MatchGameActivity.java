package com.example.prozrenie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    String Name;
    Integer Sound;
    Map<Integer, Integer> imageDictionary = new HashMap<Integer, Integer>();
    ImageView imageView;
    ImageButton helpButton;
    ImageButton backButton;
    ImageButton refreshButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_game);
        keyLayout = findViewById(R.id.key_images);
        valLayout = findViewById(R.id.value_images);
        imageView = findViewById(R.id.image_view);
        helpButton = findViewById(R.id.help_button);
        backButton = findViewById(R.id.back_button);
        refreshButton = findViewById(R.id.refresh_button);
        Intent intent = getIntent();
        imageDictionary = new Gson().fromJson(intent.getStringExtra("imageDictionary"),
                MatchGameType.class).getImageDictionary();
        Name = intent.getStringExtra("Name");
        Sound = intent.getIntExtra("Sound", 0);
        // fill imageDictionary


        GameClass = new MatchingGame(Name, imageDictionary, keyLayout,
                valLayout, Sound, imageView, this,
                helpButton, backButton, refreshButton);
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