package com.example.user.ramen;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CardViewHolder extends BaseViewHolder {

    private ImageView imageView;
    private TextView textView;

    public CardViewHolder(View itemView){
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.img_card);
        textView = (TextView) itemView.findViewById(R.id.text_card);
    }
    public void setImage(int image){
        imageView.setImageResource(image);
    }

    public void setText(String text){
        textView.setText(text);
    }
}
