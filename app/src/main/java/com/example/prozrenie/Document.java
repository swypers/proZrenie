package com.example.prozrenie;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private String mName;
    private Integer mSource;

    public Document(String name, Integer source) {
        mName = name;
        mSource = source;
    }

    public String getName() {
        return mName;
    }

    public Integer getSource() {
        return mSource;
    }

    private static int lastContactId = 0;

    public static ArrayList<Document> createDocumentsList(int numContacts) {
        ArrayList<Document> contacts = new ArrayList<Document>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Document("Person ", 18000));
        }

        return contacts;
    }
}
