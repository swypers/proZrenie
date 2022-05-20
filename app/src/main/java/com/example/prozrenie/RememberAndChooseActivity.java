package com.example.prozrenie;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class RememberAndChooseActivity extends AppCompatActivity {
    RememberAndChooseGame GameClass;
    LinearLayout imageLayout;
    LinearLayout keyLayout;
    LinearLayout keyLayout2;
    String Name;
    Integer Sound;
    Map<Integer, Boolean> imageDictionary = new HashMap<Integer, Boolean>();
    Integer image;
    ImageView imageView;
    ImageView mainImageView;
    ImageButton helpButton;
    ImageButton backButton;
    ImageButton refreshButton;
    ImageButton checkButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crgactivity);
        imageLayout = findViewById(R.id.image_layout);
        keyLayout = findViewById(R.id.key_images);
        keyLayout2 = findViewById(R.id.key_images2);
        imageView = findViewById(R.id.image_view);
        mainImageView = findViewById(R.id.main_image);
        helpButton = findViewById(R.id.help_button);
        backButton = findViewById(R.id.back_button);
        refreshButton = findViewById(R.id.refresh_button);
        checkButton = findViewById(R.id.check_button);

        Intent intent = getIntent();
        imageDictionary = new Gson().fromJson(intent.getStringExtra("imageDictionary"),
                ChooseRightGameType.class).getImageDictionary();
        Name = intent.getStringExtra("Name");
        Sound = intent.getIntExtra("Sound", 0);
        image = intent.getIntExtra("Image", 0);
        // fill imageDictionary


        GameClass = new RememberAndChooseGame(Name, imageDictionary,
                imageLayout, keyLayout, keyLayout2,
                Sound, imageView, mainImageView, image, this,
                helpButton, backButton, refreshButton, checkButton);
        GameClass.onCreate();

    }
    public void onBackPressed() {
        super.onBackPressed();
        this.finishAndRemoveTask();
        GameClass.onClose();
    }
}