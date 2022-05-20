package com.example.prozrenie;

import java.util.HashMap;
import java.util.Map;

public class RememberAndRepeatGameType {
    private String mName;
    private Integer mImage;
    private Integer mSound;
    private Map<Integer, Boolean> mImageDictionary = new HashMap<Integer, Boolean>();


    public RememberAndRepeatGameType(String name, Integer image, Map<Integer, Boolean> imageDictionary,
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

    public Map<Integer, Boolean> getImageDictionary() {
        return mImageDictionary;
    }

}
