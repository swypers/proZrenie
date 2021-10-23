package com.example.prozrenie;

public class Games {
    private String mName;
    private Integer mImage;
    private Class mClass;
    //link to activity

    public Games(String name, Integer image, Class ch_class) {
        mName = name;
        mImage = image;
        mClass = ch_class;
    }

    public String getName() {
        return mName;
    }

    public Class getmClass(){ return mClass;}

    public Integer getImage() {
        return mImage;
    }
}
