package com.example.prozrenie;

public class AudioStories {
    private String mName;
    private Integer mImage;
    private Integer mSource;

    public AudioStories(String name, Integer image, Integer source) {
        mName = name;
        mImage = image;
        mSource = source;
    }

    public String getName() {
        return mName;
    }

    public Integer getImage() {
        return mImage;
    }

    public Integer getSource() {
        return mSource;
    }
}
