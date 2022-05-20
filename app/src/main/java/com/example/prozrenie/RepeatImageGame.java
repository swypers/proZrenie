package com.example.prozrenie;

import static com.example.prozrenie.R.*;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class RepeatImageGame {
    private String mName;
    private Map<Integer, Integer[]> mImageDict;
    private Integer mSoundHelp;
    private Integer mImage;
    private LinearLayout mImageLayout;
    private LinearLayout mKeyLayout;
    private LinearLayout[] mGridLayouts;
    private Context mContext;
    private ImageView mImageView;
    private ImageView mMainImageView;
    private ImageButton mHelpButton;
    private ImageButton mBackButton;
    private ImageButton mRefreshButton;
    private ImageButton mCheckButton;
    private Integer[] mFieldSize;
    private Integer chosenKey = 0;
    private Integer chosenVal = 0;
    private Integer mGridImage;


    private Integer borderPressed = drawable.selected_item;
    private Integer borderPurple = drawable.border_purple;
    private Integer borderBlack = drawable.border_black;


    private Integer gridImage = drawable.grid;

    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,3);
    public Map<Integer, ImageButton> mButtonDict = new HashMap<Integer, ImageButton>();
    private Map<Integer, List<Integer>> mResultDict = new HashMap<Integer, List<Integer>>();
    private List<ImageButton> ChosenButtons = new ArrayList<>();
    private List<Integer> ChosenImages = new ArrayList<>();
    private MediaPlayer mp;
    LinearLayout.LayoutParams lp_0weight = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            1
    );
    LinearLayout.LayoutParams lp_4weight = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            0,
            4
    );




    public RepeatImageGame(String name, Map<Integer, Integer[]> imageDict, LinearLayout imageLayout,
                           LinearLayout keyLayout, LinearLayout[] gridLayouts,
                           Integer SoundHelp, ImageView imageView, ImageView mainImageView,
                           Integer image, Context context, ImageButton HelpButton,
                           ImageButton BackButton, ImageButton RefreshButton,
                           ImageButton CheckButton, Integer[] FieldSize, Integer gridImage) {
        mName = name; // Название
        mImageDict = imageDict; // Словарь вида id изображения: Boolean
        mSoundHelp = SoundHelp; // Голосовое задание
        mImageLayout = imageLayout;
        mKeyLayout = keyLayout;
        mGridLayouts = gridLayouts;
        mImageView = imageView; // Изображение с фреймворком
        mMainImageView = mainImageView;
        mContext = context;
        mImage = image;
        mHelpButton = HelpButton;
        mBackButton = BackButton;
        mRefreshButton = RefreshButton;
        mCheckButton = CheckButton;
        mFieldSize = FieldSize;
        mGridImage = gridImage;
    }

    //link to activity
    void onCreate(){
        mp = MediaPlayer.create(mContext, mSoundHelp);
        playHelpSound();
        bindButtons();
        fillImageView();
        // TODO startHelpSound
        ArrayList<Integer> keyImages = new ArrayList<>(getKeys());
        // Random shuffle ArrayLists
        Collections.shuffle(keyImages);
        // Go through lists
        chooseLayoutWeight(keyImages);
        addGrid();
    }

    void chooseLayoutWeight(ArrayList<Integer> iKeyImages){
            for (int i = 0; i < iKeyImages.size(); i++) {
                AddImageButtonToLayout(100 + i, iKeyImages.get(i), mKeyLayout);
            }
    }
    void addGrid(){
        for (int i = 0; i < mFieldSize[0]; i++) {
            for (int j = 0; j < mFieldSize[1]; j++) {
                AddGridButtonToLayout((i*3)+j+1, mGridImage, mGridLayouts[i]);
            }
        }
    }

    void onClose(){
        if(mp.isPlaying())
        {
            mp.stop();
        }
        mp.release();
    }

    private void bindButtons(){
        mHelpButton.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       playHelpSound();
                                   }
                               });
        mBackButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Activity activity = (Activity) mContext;
                                    activity.onBackPressed();
                                }
                            });
        mRefreshButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    tryAgain();
                                }
                            });
        mCheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkResult();
            }
        });
    }

    private void fillImageView(){
        if (mImage != null) {
            mMainImageView.setImageResource(mImage);
        }
        else {
            mImageLayout.removeAllViewsInLayout();
            mImageLayout.setLayoutParams(lp_0weight);
            mKeyLayout.setLayoutParams(lp_4weight);
        }
    }

    private void playHelpSound(){
        mp.start();
    }

    private void AddImageButtonToLayout(Integer id, Integer image, LinearLayout layout){
        ImageButton btn = new ImageButton(mContext);
        btn.setImageResource(image);
        btn.setTag(image);
        btn.setScaleType(ImageView.ScaleType.FIT_CENTER);
        btn.setId(id);
        btn.setBackground(null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,3);
        btn.setLayoutParams(lp);
        btn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        onClickItem(view);
                                    }
                                }
        );
        mButtonDict.put(id, btn);
        layout.addView(btn);
    }
    private void AddGridButtonToLayout(Integer id, Integer image, LinearLayout layout){
        ImageButton btn = new ImageButton(mContext);
        //btn.setImageResource(image);
        btn.setTag(image);
        btn.setId(id);
        btn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        btn.setBackgroundColor(Color.parseColor("#FFFFFF"));
        LinearLayout.LayoutParams layoutPar = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 2);
        btn.setLayoutParams(layoutPar);
        btn.setBackground(mContext.getDrawable(borderBlack));
        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       onClickItem(view);
                                   }
                               }
        );
        mButtonDict.put(id, btn);
        layout.addView(btn);
        //btn.setBackground(mContext.getDrawable(borderBlack));

    }

    private void removeImageFromGridButton(ImageButton btn){
        btn.setTag(gridImage);
        btn.setImageResource(0);
    }

    private void onClickItem(View btnView){
        Integer btnID = btnView.getId();
        ImageButton btn = (ImageButton) btnView;
        if(chosenKey==0)
        {
            if (btnID >= 100)
            {
                btn.setBackground(mContext.getDrawable(borderPurple));
                chosenKey = btnID;
            }
            else {
                Log.d("btn.TAG", btn.getTag().toString());
                if(btn.getTag() != gridImage)
                {
                    removeResultFromDict((int) btn.getTag(), btnID);
                    removeImageFromGridButton(btn);
                }
            }
        }
        else {
            ImageButton keyButton = mButtonDict.get(chosenKey);
            if(btnID < 100) { // Выбрана картинка и выбрана сетка
                if (btnID != chosenKey) {
                    keyButton.setBackground(null);
                    Integer ImageSource = (int) keyButton.getTag();
                    btn.setImageResource(ImageSource);
                    btn.setTag(ImageSource);
                    addResultToDict(ImageSource, btnID);
                    chosenKey = 0;
                }
            }
            else{ // Смена выбранной картинки
                if (btnID != chosenKey) {
                    keyButton.setBackground(null);
                    btn.setBackground(mContext.getDrawable(borderPurple));
                    chosenKey = btnID;
                }
                else{
                    keyButton.setBackground(null);
                    chosenKey = 0;
                }
            }
        }
    }

    private void addResultToDict(Integer Key, Integer Val)
    {
        List<Integer> list;
        if(mResultDict.containsKey(Key)){
            list = mResultDict.get(Key);
            list.add(Val);
        }
        else
        {
            list = new ArrayList<>(Arrays.asList(Val));
        }
        mResultDict.put(Key, list);
    }
    private void removeResultFromDict(Integer Key, Integer Val)
    {
        if(mResultDict.containsKey(Key)){
            List<Integer> list = mResultDict.get(Key);
            list.remove(Val);
            mResultDict.put(Key, list);
        }
    }

    private void fillImageInGrid(ImageButton gridBtn, ImageButton imageBtn)
    {
        gridBtn.setImageResource((int)imageBtn.getTag());
    }

    public Set<Integer> getKeys(){return  mImageDict.keySet();}

    public String getName() {
        return mName;
    }

    private void tryAgain(){
        chosenKey = 0;
        for (Integer id: mButtonDict.keySet()) {
            if (id < 100)
            {
                ImageButton currentButton;
                currentButton = mButtonDict.get(id);
                clearGridButton(currentButton);
            }
            else{
                ImageButton currentButton;
                currentButton = mButtonDict.get(id);
                clearButton(currentButton);
            }
        }
        ChosenImages.clear();
        mResultDict.clear();
        mRefreshButton.setVisibility(View.INVISIBLE);
    }

    private void EndGame(){
        for (Integer id: mButtonDict.keySet()) {
            ImageButton currentButton;
            currentButton = mButtonDict.get(id);
            currentButton.setEnabled(false);
        }
    }
    private void clearButton(ImageButton btn){
        btn.setBackground(null);
        btn.setEnabled(true);
    }
    private void clearGridButton(ImageButton btn){
        btn.setImageResource(android.R.color.transparent);
        btn.setTag(null);
        btn.setEnabled(true);
    }

    private Boolean getResult(){
        EndGame();
        Log.d("resultdict", mResultDict.toString());
        Log.d("imagedict", mImageDict.toString());
        for (Integer key: mImageDict.keySet()) {
            if(mResultDict.get(key) == null && mImageDict.get(key).length == 0)
            {
                continue;
            }
            else
            {
                if(mResultDict.get(key) == null) {
                    return false;
                }
                else {
                    if(mImageDict.get(key) == mResultDict.get(key).toArray(new Integer[0]))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private void checkResult(){
            Boolean result = getResult();
            if (result) {
                Glide.with(mContext)
                        .load(drawable.firework)
                        .into(new GifDrawableImageViewTarget(mImageView, 3, true));
                mBackButton.setVisibility(View.VISIBLE);
            }
            else{
                mRefreshButton.setVisibility(View.VISIBLE);
            }
    }
}
