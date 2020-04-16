package com.example.changeableui.entity;

import com.example.changeableui.entity.base.BaseUiConfig;
import com.example.changeableui.entity.base.CommonImageViewConfigEntity;
import com.example.changeableui.entity.base.CommonTextViewConfigEntity;
import com.example.changeableui.entity.base.ShapeConfig;
import com.google.gson.annotations.SerializedName;

public class Ui1Config extends BaseUiConfig {

    @SerializedName("Component1")
    protected CommonTextViewConfigEntity tv_item_title = new CommonTextViewConfigEntity();
    @SerializedName("Component2")
    protected CommonTextViewConfigEntity tv_item_clicked = new CommonTextViewConfigEntity();
    @SerializedName("Component3")
    protected CommonTextViewConfigEntity tv_tag_news = new CommonTextViewConfigEntity();
    @SerializedName("Component4")
    protected CommonTextViewConfigEntity iv_time_news = new CommonTextViewConfigEntity();
    @SerializedName("Component5")
    protected CommonImageViewConfigEntity iv_left_image = new CommonImageViewConfigEntity();
    @SerializedName("Component6")
    protected CommonImageViewConfigEntity iv_radio_news = new CommonImageViewConfigEntity();


    public CommonTextViewConfigEntity getTv_item_title() {
        return tv_item_title;
    }

    public void setTv_item_title(CommonTextViewConfigEntity tv_item_title) {
        this.tv_item_title = tv_item_title;
    }

    public CommonTextViewConfigEntity getTv_item_clicked() {
        return tv_item_clicked;
    }

    public void setTv_item_clicked(CommonTextViewConfigEntity tv_item_clicked) {
        this.tv_item_clicked = tv_item_clicked;
    }

    public CommonTextViewConfigEntity getTv_tag_news() {
        return tv_tag_news;
    }

    public void setTv_tag_news(CommonTextViewConfigEntity tv_tag_news) {
        this.tv_tag_news = tv_tag_news;
    }

    public CommonTextViewConfigEntity getIv_time_news() {
        return iv_time_news;
    }

    public void setIv_time_news(CommonTextViewConfigEntity iv_time_news) {
        this.iv_time_news = iv_time_news;
    }

    public CommonImageViewConfigEntity getIv_left_image() {
        return iv_left_image;
    }

    public void setIv_left_image(CommonImageViewConfigEntity iv_left_image) {
        this.iv_left_image = iv_left_image;
    }

    public CommonImageViewConfigEntity getIv_radio_news() {
        return iv_radio_news;
    }

    public void setIv_radio_news(CommonImageViewConfigEntity iv_radio_news) {
        this.iv_radio_news = iv_radio_news;
    }

}
