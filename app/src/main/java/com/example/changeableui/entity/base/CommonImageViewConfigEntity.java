package com.example.changeableui.entity.base;

import com.google.gson.annotations.SerializedName;

public class CommonImageViewConfigEntity extends CommonViewConfigEntity {

    @SerializedName("colorFilter")
    protected String colorFilter;

    public String getColorFilter() {
        return colorFilter;
    }

    public void setColorFilter(String colorFilter) {
        this.colorFilter = colorFilter;
    }

}
