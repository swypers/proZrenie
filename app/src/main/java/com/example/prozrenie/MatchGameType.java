package com.example.prozrenie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MatchGameType {
    private String mName;
    private Integer mImage;
    private Integer mSound;
    private Map<Integer, Integer> mImageDictionary = new HashMap<Integer, Integer>();


    public MatchGameType(String name, Integer image, Map<Integer, Integer> imageDictionary,
                         Integer Sound) {
        mName = name;
        mImage = image;
        mImageDictionary = imageDictionary;
        mSound = Sound;
    }

    public String getName() {
        return mName;
    }

    public Integer getImage() {
        return mImage;
    }

    public Integer getSound(){ return mSound; }

    public Map<Integer, Integer> getImageDictionary() {
        return mImageDictionary;
    }

}
