package com.example.prozrenie;

import android.app.Activity;
import android.content.Context;
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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ChooseRightGame {
    private String mName;
    private Map<Integer, Boolean> mImageDict;
    private Integer mSoundHelp;
    private Integer mImage;
    private LinearLayout mKeyLayout;
    private Context mContext;
    private ImageView mImageView;
    private ImageView mMainImageView;
    private ImageButton mHelpButton;
    private ImageButton mBackButton;
    private ImageButton mRefreshButton;
    private ImageButton mCheckButton;


    private Integer borderPressed = R.drawable.selected_item;
    private Integer borderPurple = R.drawable.border_purple;

    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,3);
    public Map<Integer, ImageButton> mButtonDict = new HashMap<Integer, ImageButton>();
    private Map<Integer, Integer> mResultDict = new HashMap<Integer, Integer>();
    private List<ImageButton> ChosenButtons = new ArrayList<>();
    private List<Integer> ChosenImages = new ArrayList<>();
    private Stack<Integer> borderStack = new Stack<>();
    private MediaPlayer mp;



    public ChooseRightGame(String name, Map<Integer, Boolean> imageDict, LinearLayout keyLayout,
                           Integer SoundHelp, ImageView imageView, ImageView mainImageView,
                           Integer image, Context context, ImageButton HelpButton,
                           ImageButton BackButton, ImageButton RefreshButton,
                           ImageButton CheckButton) {
        mName = name; // Название
        mImageDict = imageDict; // Словарь вида id изображения: Boolean
        mSoundHelp = SoundHelp; // Голосовое задание
        mKeyLayout = keyLayout;
        mImageView = imageView; // Изображение с фреймворком
        mMainImageView = mainImageView;
        mContext = context;
        mImage = image;
        mHelpButton = HelpButton;
        mBackButton = BackButton;
        mRefreshButton = RefreshButton;
        mCheckButton = CheckButton;
    }

    //link to activity
    void onCreate(){
        bindButtons();
        fillImageView();
        mp = MediaPlayer.create(mContext, mSoundHelp);
        // TODO startHelpSound
        ArrayList<Integer> keyImages = new ArrayList<>(getKeys());
        // Random shuffle ArrayLists
        Collections.shuffle(keyImages);
        // Go through lists
        for(int i=0; i < keyImages.size(); i++){
            AddImageButtonToLayout(100+i, keyImages.get(i), mKeyLayout);
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
        mMainImageView.setImageResource(mImage);
    }

    private void playHelpSound(){
        mp.start();
    }

    private void AddImageButtonToLayout(Integer id, Integer image, LinearLayout layout){
        ImageButton btn = new ImageButton(mContext);
        btn.setImageResource(image);
        btn.setTag(image);
        btn.setScaleType(ImageView.ScaleType.FIT_CENTER);
        btn.setMaxHeight(240);
        btn.setId(id);
        btn.setBackground(null);
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

    private void onClickItem(View btn){
        if (btn.getBackground() == null)
        {
            btn.setBackground(mContext.getDrawable(borderPurple));
            ChosenImages.add((Integer) btn.getTag());
        }
        else {
            btn.setBackground(null);
            ChosenImages.remove((Integer) btn.getTag());
        }
    }

    public Set<Integer> getKeys(){return  mImageDict.keySet();}

    public String getName() {
        return mName;
    }

    private void tryAgain(){
        for (Integer id: mButtonDict.keySet()) {
            ImageButton currentButton;
            currentButton = mButtonDict.get(id);
            clearButton(currentButton);
        }
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

    private Boolean getResult(){
        EndGame();
        Log.d("chosenbuttons", ChosenImages.toString());
        for (Integer key: mImageDict.keySet()) {
            if (mImageDict.get(key)){
                if (!ChosenImages.contains(key))
                    return false;
            }
        }
        return true;
    }
    private void checkResult(){
            Boolean result = getResult();
            if (result) {
                Glide.with(mContext)
                        .load(R.drawable.firework)
                        .into(new GifDrawableImageViewTarget(mImageView, 3, true));
                mBackButton.setVisibility(View.VISIBLE);
            }
            else{
                mRefreshButton.setVisibility(View.VISIBLE);
            }
    }
}