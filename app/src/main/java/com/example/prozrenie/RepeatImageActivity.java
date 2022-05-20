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

public class RepeatImageActivity extends AppCompatActivity {
    RepeatImageGame GameClass;
    LinearLayout imageLayout;
    LinearLayout keyLayout;
    LinearLayout[] gridLayouts;
    String Name;
    Integer Sound;
    Map<Integer, Integer[]> imageDictionary = new HashMap<Integer, Integer[]>();
    Integer[] FieldSize;
    Integer image;
    ImageView imageView;
    ImageView mainImageView;
    ImageButton helpButton;
    ImageButton backButton;
    ImageButton refreshButton;
    ImageButton checkButton;
    Boolean showImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repeat_image);
        imageLayout = findViewById(R.id.image_layout);
        keyLayout = findViewById(R.id.key_images4);
        gridLayouts = new LinearLayout[]{
                findViewById(R.id.key_images1),
                findViewById(R.id.key_images2),
                findViewById(R.id.key_images3),
        };
        imageView = findViewById(R.id.image_view);
        mainImageView = findViewById(R.id.main_image);
        helpButton = findViewById(R.id.help_button);
        backButton = findViewById(R.id.back_button);
        refreshButton = findViewById(R.id.refresh_button);
        checkButton = findViewById(R.id.check_button);

        Intent intent = getIntent();
        imageDictionary = new Gson().fromJson(intent.getStringExtra("imageDictionary"),
                RepeateImageGameType.class).getImageDictionary();
        Name = intent.getStringExtra("Name");
        Sound = intent.getIntExtra("Sound", 0);
        image = intent.getIntExtra("Image", 0);
        FieldSize = new Gson().fromJson(intent.getStringExtra("imageDictionary"),
                RepeateImageGameType.class).getFieldSize();
        showImage = intent.getBooleanExtra("showImage", true);
        if (!showImage)
            image = null;
        // fill imageDictionary


        GameClass = new RepeatImageGame(Name, imageDictionary,
                imageLayout, keyLayout, gridLayouts,
                Sound, imageView, mainImageView, image, this,
                helpButton, backButton, refreshButton, checkButton, FieldSize, R.drawable.blank);
        GameClass.onCreate();

    }
    public void onBackPressed() {
        super.onBackPressed();
        this.finishAndRemoveTask();
        GameClass.onClose();
    }
}