package com.example.changeableui.entity.base;

import com.google.gson.annotations.SerializedName;

/**
 * @ClassName: ShapeConfig
 * @Author: Gracfulwind
 * @CreateDate: 2020/4/15 14:38
 * @Description:
 * @UpdateUser:
 * @UpdateDate: 2020/4/15 14:38
 * @UpdateRemark:
 * @Version: 1.0
 * @Email: 429344332@qq.com
 */

public class ShapeConfig {

    @SerializedName("strokeWidth")
    int strokeWidth = 0;
    @SerializedName("roundRadius")
    int roundRadius = 0;
    @SerializedName("shape")
    int shape = 0;
    @SerializedName("strokeColor")
    String strokeColor = null;
    @SerializedName("fillColor")
    String fillColor = null;

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public int getRoundRadius() {
        return roundRadius;
    }

    public void setRoundRadius(int roundRadius) {
        this.roundRadius = roundRadius;
    }

    public int getShape() {
        return shape;
    }

    public void setShape(int shape) {
        this.shape = shape;
    }

    public String getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }
}
