package com.example.changeableui.entity.base;

import com.google.gson.annotations.SerializedName;

public class BaseUiConfig implements UiConfigInterface {

    @SerializedName("name")
    public String name = null;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setString(String configName) {
        name = configName;
    }
}
