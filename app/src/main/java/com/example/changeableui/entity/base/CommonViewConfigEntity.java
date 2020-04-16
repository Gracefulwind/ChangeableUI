package com.example.changeableui.entity.base;

import com.google.gson.annotations.SerializedName;

public class CommonViewConfigEntity {


    @SerializedName("width")
    protected int width;
    @SerializedName("height")
    protected int height;
    @SerializedName("marginLeft")
    protected int marginLeft;
    @SerializedName("marginTop")
    protected int marginTop;
    @SerializedName("marginRight")
    protected int marginRight;
    @SerializedName("marginBottom")
    protected int marginBottom;
    @SerializedName("paddingLeft")
    protected int paddingLeft;
    @SerializedName("paddingTop")
    protected int paddingTop;
    @SerializedName("paddingRight")
    protected int paddingRight;
    @SerializedName("paddingBottom")
    protected int paddingBottom;
    @SerializedName("gravity")
    protected int gravity;
    @SerializedName("visible")
    protected int visible;

    @SerializedName("shape")
    protected ShapeConfig shape;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMarginLeft() {
        return marginLeft;
    }

    public void setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
    }

    public int getMarginTop() {
        return marginTop;
    }

    public void setMarginTop(int marginTop) {
        this.marginTop = marginTop;
    }

    public int getMarginRight() {
        return marginRight;
    }

    public void setMarginRight(int marginRight) {
        this.marginRight = marginRight;
    }

    public int getMarginBottom() {
        return marginBottom;
    }

    public void setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
    }

    public int getPaddingLeft() {
        return paddingLeft;
    }

    public void setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
    }

    public int getPaddingTop() {
        return paddingTop;
    }

    public void setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
    }

    public int getPaddingRight() {
        return paddingRight;
    }

    public void setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
    }

    public int getPaddingBottom() {
        return paddingBottom;
    }

    public void setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public ShapeConfig getShape() {
        return shape;
    }

    public void setShape(ShapeConfig shape) {
        this.shape = shape;
    }
}
