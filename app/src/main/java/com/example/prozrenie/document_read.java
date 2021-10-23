package com.example.prozrenie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class document_read extends AppCompatActivity {
    String text;
    TextView text_view;
    private Button btn_plus;
    private Button btn_minus;
    public int source = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        source = intent.getIntExtra("source", 0);
        try {
            text = readFromFile(source);
        }
        catch (Exception ex)
        {
            Log.d("error", ex.toString());
        }
        setContentView(R.layout.document_read);
        text_view = findViewById(R.id.text_view);
        text_view.setText(text);
        addListenerOnButton();
    }
    private void addListenerOnButton(){
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_plus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        float text_size = text_view.getTextSize();
                        text_size += 4.0;
                        text_view.setTextSize(TypedValue.COMPLEX_UNIT_PX, text_size);
                    }
                }
        );
        btn_minus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        float text_size = text_view.getTextSize();
                        if (text_size > 4){
                            text_size -= 4;
                            text_view.setTextSize(TypedValue.COMPLEX_UNIT_PX, text_size);
                        }
                    }
                }
        );
    }
    public String readFromFile(int source) throws IOException {
        String text = "";
        InputStream is = getResources().openRawResource(source);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;

        while ((line = reader.readLine()) != null)
            text += line + "\n";
        return text;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}