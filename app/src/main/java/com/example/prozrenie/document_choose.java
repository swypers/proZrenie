package com.example.prozrenie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.io.*;
import java.util.ArrayList;

public class document_choose extends AppCompatActivity {
    ArrayList<Document> documents = new ArrayList<>();
    Document test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_choose);
        documents.add(new Document("Строение глаза",
                R.raw.stroenie));
        documents.add(new Document("Как сохранить зрение ребенка",
                R.raw.sohranit));
        documents.add(new Document("Как видит ребенок с нарушением зрения",
                (int)R.raw.how));
        documents.add(new Document("Как научить ребёнка с нарушением зрения одеваться",
                R.raw.nadev));
        documents.add(new Document("Как научить слепого ребёнка навыкам самообслуживания",
                R.raw.samoobsl));
        documents.add(new Document("Как обучить ребёнка с нарушением зрения элементарным гииеническим навыкам",
                R.raw.gigiena));
        documents.add(new Document("Как учить ребенка с нарушением зрения видеть",
                R.raw.uchit));
        documents.add(new Document("Питание ребека с нарушением зрения",
                R.raw.pitan));
        documents.add(new Document("Прогулки со слепым ребенком",
                R.raw.progulki));
        documents.add(new Document("Режим дня ребенка с нарушениями зрения",
                R.raw.rezhim));
        // Lookup the recyclerview in activity layout
        RecyclerView rvDocuments = (RecyclerView) findViewById(R.id.document_list);

        // Initialize contacts
        // Create adapter passing in the sample user data
        DocumentAdapter adapter = new DocumentAdapter(documents);
        // Attach the adapter to the recyclerview to populate items
        rvDocuments.setAdapter(adapter);
        // Set layout manager to position the items
        rvDocuments.setLayoutManager(new LinearLayoutManager(this));
        try {
            String s = readFromFile(R.raw.how);
        }
        catch (Exception ex)
        {

        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
    public String readFromFile(int source) throws IOException {
        String string = "";
        InputStream is = getResources().openRawResource(source);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        while (true) {
            try {
                if ((string = reader.readLine()) == null) break;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        is.close();
        return string;
    }
}
