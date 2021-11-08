package com.example.prozrenie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.text.BoringLayout;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class MatchingGame {
    private String mName;
    private Map<Integer, Integer> mImageDict;
    private Integer mSoundHelp;
    private LinearLayout mKeyLayout, mValLayout;
    private Context mContext;
    private ImageView mImageView;
    private ImageButton mHelpButton;
    private ImageButton mBackButton;
    private ImageButton mRefreshButton;

    private Integer borderPressed = R.drawable.selected_item;
    private Integer borderPurple = R.drawable.border_purple;

    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(150*2, 150*2);
    private Integer chosenKey = 0;
    private Integer chosenVal = 0;
    public Map<Integer, ImageButton> mButtonDict = new HashMap<Integer, ImageButton>();
    private Map<Integer, Integer> mResultDict = new HashMap<Integer, Integer>();
    private Stack<Integer> borderStack = new Stack<>();
    private MediaPlayer mp;



    public MatchingGame(String name, Map<Integer, Integer> imageDict, LinearLayout keyLayout,
                        LinearLayout valLayout, Integer SoundHelp, ImageView imageView,
                        Context context, ImageButton HelpButton, ImageButton BackButton,
                        ImageButton RefreshButton) {
        mName = name;
        mImageDict = imageDict;
        mSoundHelp = SoundHelp;
        mKeyLayout = keyLayout;
        mValLayout = valLayout;
        mSoundHelp = SoundHelp;
        mImageView = imageView;
        mContext = context;
        mHelpButton = HelpButton;
        mBackButton = BackButton;
        mRefreshButton = RefreshButton;
    }

    //link to activity
    void onCreate(){
        fillBorderStack();
        bindButtons();
        mp = MediaPlayer.create(mContext, mSoundHelp);
        // TODO startHelpSound
        ArrayList<Integer> keyImages = new ArrayList<>(getKeys());
        ArrayList<Integer> valImages = new ArrayList<>(getValues());
        // Random shuffle ArrayLists
        Collections.shuffle(keyImages);
        Collections.shuffle(valImages);
        // Go through lists
        for(int i=0; i < keyImages.size(); i++){
            AddImageButtonToLayout(100+i, keyImages.get(i), mKeyLayout);
            AddImageButtonToLayout(200+i, valImages.get(i), mValLayout);
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
    }

    private void playHelpSound(){
        mp.start();
    }

    private void fillBorderStack(){
        borderStack.clear();
        Integer[] borders = {R.drawable.border_coral, R.drawable.border_emerald,
                R.drawable.border_pink, R.drawable.border_yellowred};
        for (Integer border: borders)
        {
            borderStack.push(border);
        }
    }

    private void AddImageButtonToLayout(Integer id, Integer image, LinearLayout layout){
        ImageButton btn = new ImageButton(mContext);
        btn.setImageResource(image);
        btn.setTag(image);
        btn.setScaleType(ImageView.ScaleType.FIT_CENTER);
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
        Integer btnID = btn.getId();
        if(chosenVal==0 && chosenKey==0)
        {
            if (btnID < 200)
            {
                btn.setBackground(mContext.getDrawable(borderPurple));
                chosenKey = btnID;
            }
            else {
                btn.setBackground(mContext.getDrawable(borderPurple));
                chosenVal = btnID;
            }
        }
        else {
            if(chosenKey!=0 && btnID < 200) {
                if (btnID != chosenKey) {
                    btn.setBackground(mContext.getDrawable(borderPurple));
                    mButtonDict.get(chosenKey).setBackground(null);
                    chosenKey = btnID;
                }
            }
            else{
                if(chosenVal!=0 && btnID >= 200) {
                    if (!btnID.equals(chosenVal)) {
                        btn.setBackground(mContext.getDrawable(borderPurple));
                        mButtonDict.get(chosenVal).setBackground(null);
                        chosenVal = btnID;
                    }
                }
                else {
                    // TODO make a dict to store IDs
                    ImageButton clickedBtn = mButtonDict.get(btnID);
                    if(chosenVal != 0 ) {
                        ImageButton btnVal = mButtonDict.get(chosenVal);
                        drawBorderForImageButtons(clickedBtn, btnVal);
                        mResultDict.put((int) clickedBtn.getTag(), (int) btnVal.getTag());
                        BlockButton(btnVal);
                    }
                    if(chosenKey != 0)
                    {
                        ImageButton btnKey = mButtonDict.get(chosenKey);
                        mResultDict.put((int) btnKey.getTag(), (int) clickedBtn.getTag());
                        drawBorderForImageButtons(clickedBtn, btnKey);
                        BlockButton(btnKey);
                    }
                    BlockButton(clickedBtn);
                    chosenKey = 0;
                    chosenVal = 0;
                    checkEnd();
                }
            }
        }

    }

    private void BlockButton(ImageButton btn){
        btn.setEnabled(false);
    }

    private void drawBorderForImageButtons(ImageButton btn1, ImageButton btn2)
    {
        Drawable border = mContext.getDrawable(borderStack.pop());
        btn1.setBackground(border);
        btn2.setBackground(border);
    }

    public Set<Integer> getKeys(){return  mImageDict.keySet();}
    public Collection<Integer> getValues(){return  mImageDict.values();}

    public String getName() {
        return mName;
    }

    private void checkEnd(){
        if(mResultDict.size() == mImageDict.size()) {
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

    private void tryAgain(){
        fillBorderStack();
        for (Integer id: mButtonDict.keySet()) {
            ImageButton currentButton;
            currentButton = mButtonDict.get(id);
            clearButton(currentButton);
        }
        mResultDict.clear();
        mRefreshButton.setVisibility(View.INVISIBLE);
    }
    private void clearButton(ImageButton btn){
        btn.setBackground(null);
        btn.setEnabled(true);
    }

    private Boolean getResult(){
        for (Integer key: mResultDict.keySet()) {
            if (!mResultDict.get(key).equals(mImageDict.get(key))){
                return false;
            }
        }
        return true;
    }
}
