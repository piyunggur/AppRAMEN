package com.example.user.ramen;

import android.content.Context;
import android.graphics.Typeface;

class CustomFont {
    private static final CustomFont ourInstance = new CustomFont();

    static CustomFont getInstance() {
        return ourInstance;
    }

    private CustomFont() {
    }


    private Typeface fontHead;
    private Typeface fontData;

    public Typeface getFontHead(Context context) {
        if(fontHead==null){
            fontHead = Typeface.createFromAsset(context.getAssets(),"fonts/Kanit-Medium.ttf");
        }
        return fontHead;
    }

    public void setFontHead(Typeface fontHead) {
        this.fontHead = fontHead;
    }

    public Typeface getFontData(Context context) {
        if(fontData==null){
            fontData = Typeface.createFromAsset(context.getAssets(),"fonts/Kanit-Light.ttf");
        }
        return fontData;
    }

    public void setFontData(Typeface fontData) {
        this.fontData = fontData;
    }
}
