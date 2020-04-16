package com.example.changeableui.entity.base;

import com.google.gson.annotations.SerializedName;

public class CommonTextViewConfigEntity extends CommonViewConfigEntity{


    @SerializedName("textColor")
    protected String textColor;
    @SerializedName("textSize")
    protected int textSize;

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

}
