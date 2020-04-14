package com.example.changeableui.utils;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.changeableui.entity.Ui0Config;
import com.example.changeableui.entity.base.CommonImageViewConfigEntity;
import com.example.changeableui.entity.base.CommonTextViewConfigEntity;
import com.example.changeableui.entity.base.CommonViewConfigEntity;
import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static android.util.TypedValue.applyDimension;

public class UiConfigUtils {
    public static Map<String, Object> uiConfigMap = new HashMap<String, Object>();
    private static boolean isConfigInited = false;
    private static Context appContext = null;



    public static class UiConfigKey{
        public static String UI0_CONFIG = "ui0Config";
        public static String UI1_CONFIG = "ui1Config";

    }


    public static void initUiConfig(Context appContext){
        UiConfigUtils.appContext = appContext;
        getUiConfigByNet();
    }

    synchronized private static void initUiConfigByLocal() {
        //假如已经初始化了则不再调用
        if(isConfigInited){
            return;
        }

        //1.get local data
        Ui0Config uiConfigByLocal = getUiConfigByLocal();
        //2.初始化数据
        initUiConfigMap(uiConfigByLocal);
    }

    private static void initUiConfigMap(Ui0Config uiConfigByLocal) {
        //
        //实际拿到的数据是个List，遍历List，按照键值对存储
        uiConfigMap.put(UiConfigKey.UI0_CONFIG, uiConfigByLocal);
    }

    private static Ui0Config getUiConfigByLocal() {
        Ui0Config ui0Config = null;
        File file = new File("/sdcard/ui0Config.text");
        boolean exists = file.exists();
        StringBuilder sb = new StringBuilder();
        try{
            if(!file.exists()){
                file.createNewFile();
//                return "No File error ";
            }else{
                InputStream in = new BufferedInputStream(new FileInputStream(file));
                BufferedReader br= new BufferedReader(new InputStreamReader(in, "UTF-8"));
                String tmp;
//                     String [] arr = new String[60];
                while((tmp=br.readLine())!=null){
                    sb.append(tmp);
                }
                br.close();
                in.close();
            }
        } catch (Exception e) {
            System.out.println("==========");
            System.out.println("==========");
        }
        System.out.println("==========");
        System.out.println("==========");
        System.out.println("==========");
        ui0Config = new Gson().fromJson(sb.toString(), Ui0Config.class);
        return ui0Config;
    }

    private static void getUiConfigByNet() {
        //异步，如果拿不到再从本地拿
        //拿到数据后，将数据更新在本地，isConfigInited 为true
        //如果拿不到数据,调用initUiConfigByLocal初始化
        //todo:异步现成
//        这里是测试，直接调用好了

        CountDownTimer timer = new CountDownTimer(1000, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                //1.save data to local
                //2.init data
                initUiConfigByLocal();
            }
        };
        timer.start();

    }

    synchronized public static Object getUiConfig(String uiKey){
        if(!isConfigInited){
            initUiConfigByLocal();
        }
        Object uiConfig = uiConfigMap.get(uiKey);
        return uiConfig;
    }


//======================================================================
    /**
     * 描述：dip转换为px.
     *
     * @param dipValue the dip value
     * @return px值
     */
    public static float dip2px(float dipValue) {
        DisplayMetrics mDisplayMetrics = appContext.getResources().getDisplayMetrics();
        return applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, mDisplayMetrics);
    }

    /**
     * 描述：px转换为dip.
     *
     * @param pxValue the px value
     * @return dip值
     */
    public static float px2dip(float pxValue) {
        DisplayMetrics mDisplayMetrics = appContext.getResources().getDisplayMetrics();
        return pxValue / mDisplayMetrics.density;
    }

    /**
     * 描述：sp转换为px.
     *
     * @param spValue the sp value
     * @return sp值
     */
    public static float sp2px(float spValue) {
        DisplayMetrics mDisplayMetrics = appContext.getResources().getDisplayMetrics();
        return applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, mDisplayMetrics);
    }

    /**
     * 描述：px转换为sp.
     *
     * @param pxValue the sp value
     * @return sp值
     */
    public static float px2sp(float pxValue) {
        DisplayMetrics mDisplayMetrics = appContext.getResources().getDisplayMetrics();
        return pxValue / mDisplayMetrics.scaledDensity;
    }

//======================================================================
    private static boolean checkNull(Object config) {
        return null == config;
    }

    public static void setUiByConfig() {

    }
    //    MATCH = -1 , WARP = -2
    public static View setCommonViewConfigInMarginLayout(View targetView, CommonViewConfigEntity config, ViewGroup.MarginLayoutParams layoutParams) {
        if(checkNull(config)){
            return targetView;
        }
        int width = config.getWidth();
        int height = config.getHeight();
        int marginLeft = config.getMarginLeft();
        int marginTop = config.getMarginTop();
        int marginRight = config.getMarginRight();
        int marginBottom = config.getMarginBottom();
        int paddingLeft = config.getPaddingLeft();
        int paddingTop = config.getPaddingTop();
        int paddingRight = config.getPaddingRight();
        int paddingBottom = config.getPaddingBottom();
        int gravity = config.getGravity();
        int visible = config.getVisible();

        layoutParams.width = (int) dip2px(width);
        layoutParams.height = (int) dip2px(height);
        layoutParams.setMargins((int) dip2px(marginLeft)
                , (int) dip2px(marginTop)
                , (int) dip2px(marginRight)
                , (int) dip2px(marginBottom));

        targetView.setPadding((int) dip2px(paddingLeft)
                , (int) dip2px(paddingTop)
                , (int) dip2px(paddingRight)
                , (int) dip2px(paddingBottom));
        targetView.setLayoutParams(layoutParams);
        //todo : fix 重心
//        targetView.gr
        //显示情况。 0 默认， 1隐藏
        if(0 == visible){
            targetView.setVisibility(View.VISIBLE);
        }else {
            targetView.setVisibility(View.GONE);
        }
        return targetView;
    }

    //----RelativeLayout---------------------------------------------

    public static View setCommonViewConfigInRelative(View targetView, CommonViewConfigEntity config) {
        if(checkNull(config)){
            return targetView;
        }
        int width = config.getWidth();
        int height = config.getHeight();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) targetView.getLayoutParams();
        layoutParams.width = (int) dip2px(width);
        layoutParams.height = (int) dip2px(height);
        return setCommonViewConfigInMarginLayout(targetView, config, layoutParams);
    }

    public static TextView setCommonTextViewConfigInRelative(TextView targetView, CommonTextViewConfigEntity config) {
        if(checkNull(config)){
            return targetView;
        }
        //通用View设置
        setCommonViewConfigInRelative(targetView, config);
        int textSize = config.getTextSize();
        String textColor = config.getTextColor();
        targetView.setTextSize(textSize);
        targetView.setTextColor(Color.parseColor(textColor));
        return targetView;
    }

    public static ImageView setCommonImageViewConfigInRelative(ImageView targetView, CommonImageViewConfigEntity config) {
        if(checkNull(config)){
            return targetView;
        }
        setCommonViewConfigInRelative(targetView, config);
        //todo:fix 给imageview设置颜色过滤
        String colorFilter = config.getColorFilter();
        return targetView;
    }

    //-----LinearLayout------------------------------------------------

    public static View setCommonViewConfigInLinear(View targetView, CommonViewConfigEntity config) {
        if(checkNull(config)){
            return targetView;
        }
        int width = config.getWidth();
        int height = config.getHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) targetView.getLayoutParams();
        layoutParams.width = (int) dip2px(width);
        layoutParams.height = (int) dip2px(height);
        return setCommonViewConfigInMarginLayout(targetView, config, layoutParams);
    }

    public static TextView setCommonTextViewConfigInLinear(TextView targetView, CommonTextViewConfigEntity config) {
        if(checkNull(config)){
            return targetView;
        }
        //通用View设置
        setCommonViewConfigInLinear(targetView, config);
        int textSize = config.getTextSize();
        String textColor = config.getTextColor();
        targetView.setTextSize(textSize);
        targetView.setTextColor(Color.parseColor(textColor));
        return targetView;
    }

    public static ImageView setCommonImageViewConfigInLinear(ImageView targetView, CommonImageViewConfigEntity config) {
        if(checkNull(config)){
            return targetView;
        }
        setCommonViewConfigInLinear(targetView, config);
        //todo:fix 给imageview设置颜色过滤
        String colorFilter = config.getColorFilter();
        return targetView;
    }

    //-----ConstraintLayout------------------------------------------------

    public static View setCommonViewConfigInConstraint(View targetView, CommonViewConfigEntity config) {
        if(checkNull(config)){
            return targetView;
        }
        int width = config.getWidth();
        int height = config.getHeight();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) targetView.getLayoutParams();
        layoutParams.width = (int) dip2px(width);
        layoutParams.height = (int) dip2px(height);
        return setCommonViewConfigInMarginLayout(targetView, config, layoutParams);
    }

    public static TextView setCommonTextViewConfigInConstraint(TextView targetView, CommonTextViewConfigEntity config) {
        if(checkNull(config)){
            return targetView;
        }
        //通用View设置
        setCommonViewConfigInConstraint(targetView, config);
        int textSize = config.getTextSize();
        String textColor = config.getTextColor();
        targetView.setTextSize(sp2px(textSize));
        targetView.setTextColor(Color.parseColor(textColor));
        return targetView;
    }

    public static ImageView setCommonImageViewConfigInConstraint(ImageView targetView, CommonImageViewConfigEntity config) {
        if(checkNull(config)){
            return targetView;
        }
        setCommonViewConfigInConstraint(targetView, config);
        //todo:fix 给imageview设置颜色过滤
        String colorFilter = config.getColorFilter();
        return targetView;
    }
}
