package com.example.prozrenie;

import java.util.HashMap;
import java.util.Map;

public class ChooseRightGameType {
    private String mName;
    private Integer mImage;
    private Integer mSound;
    private Map<Integer, Boolean> mImageDictionary = new HashMap<Integer, Boolean>();
    private Boolean mShowImage = true;


    public ChooseRightGameType(String name, Integer image, Map<Integer, Boolean> imageDictionary,
                               Integer Sound, Boolean showImage) {
        mName = name;
        mImage = image;
        mImageDictionary = imageDictionary;
        mSound = Sound;
        mShowImage = showImage;
    }

    public String getName() {
        return mName;
    }

    public Boolean getShowImage() {return mShowImage; }

    public Integer getImage() {
        return mImage;
    }

    public Integer getSound(){ return mSound; }

    public Map<Integer, Boolean> getImageDictionary() {
        return mImageDictionary;
    }

}
