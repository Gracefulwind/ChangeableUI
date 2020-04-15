package com.example.changeableui.entity;

import com.example.changeableui.entity.base.BaseUiConfig;
import com.example.changeableui.entity.base.CommonImageViewConfigEntity;
import com.example.changeableui.entity.base.CommonTextViewConfigEntity;
import com.google.gson.annotations.SerializedName;

public class Ui0Config extends BaseUiConfig {

    @SerializedName("leftImage")
    protected CommonImageViewConfigEntity leftImage = new CommonImageViewConfigEntity();
    @SerializedName("rightTitle")
    protected CommonTextViewConfigEntity rightTitle = new CommonTextViewConfigEntity();
    @SerializedName("leftTimeNews")
    protected CommonTextViewConfigEntity leftTimeNews = new CommonTextViewConfigEntity();
    @SerializedName("rightClickCounts")
    protected CommonTextViewConfigEntity rightClickCounts = new CommonTextViewConfigEntity();

    public CommonImageViewConfigEntity getLeftImage() {
        return leftImage;
    }

    public void setLeftImage(CommonImageViewConfigEntity leftImage) {
        this.leftImage = leftImage;
    }

    public CommonTextViewConfigEntity getRightTitle() {
        return rightTitle;
    }

    public void setRightTitle(CommonTextViewConfigEntity rightTitle) {
        this.rightTitle = rightTitle;
    }

    public CommonTextViewConfigEntity getLeftTimeNews() {
        return leftTimeNews;
    }

    public void setLeftTimeNews(CommonTextViewConfigEntity leftTimeNews) {
        this.leftTimeNews = leftTimeNews;
    }

    public CommonTextViewConfigEntity getRightClickCounts() {
        return rightClickCounts;
    }

    public void setRightClickCounts(CommonTextViewConfigEntity rightClickCounts) {
        this.rightClickCounts = rightClickCounts;
    }


}
