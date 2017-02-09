package com.example.asheransari.miwokpractices;

/**
 * Created by asher.ansari on 9/26/2016.
 */
public class variableClass {
    private String mDefaultranslation;
    private String mMiwokTranslation;
    private int mImageResourseID = NO_IMAGE_PROVIDE;
    private static final int NO_IMAGE_PROVIDE = -1;
    private int mAudioResourceID;

    public int getmAudioResourceID() {
        return mAudioResourceID;
    }

    public int getmImageResourseID() {
        return mImageResourseID;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public String getmDefaultranslation() {
        return mDefaultranslation;
    }

    public boolean hasImage()
    {
        return mImageResourseID != NO_IMAGE_PROVIDE;
    }

    public variableClass(String Defaultranslation, String MiwokTranslation, int AudioResourceID){
        mDefaultranslation = Defaultranslation;
        mMiwokTranslation = MiwokTranslation;
        mAudioResourceID = AudioResourceID;
    }

    public variableClass(String Defaultranslation, String MiwokTranslation,int imageResource ,int AudioResourceID){
        mDefaultranslation = Defaultranslation;
        mMiwokTranslation = MiwokTranslation;
        mAudioResourceID = AudioResourceID;
        mImageResourseID = imageResource;
    }



}
