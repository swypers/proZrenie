package com.example.prozrenie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {
    private ImageButton btn_parent;
    private ImageButton btn_kid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
    private void addListenerOnButton(){
        btn_parent = findViewById(R.id.btn_parent);
        btn_kid = findViewById(R.id.btn_kid);
        btn_parent.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, document_choose.class);
                        startActivity(intent);
                    }
                }
        );
        btn_kid.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, kids_choose.class);
                        startActivity(intent);
                    }
                }
        );
    }
}