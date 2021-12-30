package com.example.prozrenie;

import java.util.HashMap;
import java.util.Map;

public class RepeateImageGameType {
    private String mName;
    private Integer mImage;
    private Integer mSound;
    private Map<Integer, Integer[]> mImageDictionary = new HashMap<Integer, Integer[]>();
    private Boolean mShowImage = true;
    private Integer[] FieldSize;


    public RepeateImageGameType(String name, Integer image, Map<Integer, Integer[]> imageDictionary,
                                Integer Sound, Boolean showImage, Integer[] fieldSize) {
        mName = name;
        mImage = image;
        mImageDictionary = imageDictionary;
        mSound = Sound;
        mShowImage = showImage;
        FieldSize = fieldSize;
    }

    public String getName() {
        return mName;
    }

    public Boolean getShowImage() {return mShowImage; }

    public Integer getImage() {
        return mImage;
    }

    public Integer getSound(){ return mSound; }

    public Integer[] getFieldSize() {return FieldSize; }

    public Map<Integer, Integer[]> getImageDictionary() {
        return mImageDictionary;
    }

}
