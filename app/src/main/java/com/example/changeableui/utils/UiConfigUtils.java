package com.example.changeableui.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.changeableui.entity.MyConfig;
import com.example.changeableui.entity.base.CommonImageViewConfigEntity;
import com.example.changeableui.entity.base.CommonTextViewConfigEntity;
import com.example.changeableui.entity.base.CommonViewConfigEntity;
import com.example.changeableui.entity.base.ShapeConfig;
import com.example.changeableui.main.SplashActivity;
import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static com.example.changeableui.utils.UiUtil.dip2px;
import static com.example.changeableui.utils.UiUtil.sp2px;

/**
  *
  * @ClassName:      UiConfigUtils
  * @Author:         Gracefulwind
  * @CreateDate:     2020/4/15 17:37
  * @Description:    MATCH = -1 , WARP = -2
  *
  * @UpdateUser:
  * @UpdateDate:     2020/4/15 17:37
  * @UpdateRemark:
  * @Version:        1.0
  * @Email 429344332@qq.com
 */

public class UiConfigUtils {
    public static Map<String, Object> uiConfigMap = new HashMap<String, Object>();
    private static boolean isConfigInited = false;
    private static Context appContext = null;
    private static final String PATH_NAME = "/sdcard/uiConfig.txt";


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
        MyConfig uiConfigByLocal = getUiConfigByLocal();
        //2.初始化数据
        initUiConfigMap(uiConfigByLocal);
    }

    private static void initUiConfigMap(MyConfig uiConfigByLocal) {
        //
        //实际拿到的数据是个List，遍历List，按照键值对存储
        //todo:fix 这么写的话其实没啥意义。。。MyConfig依然存在于堆中。其实直接读写MyConfig即可。。。或者将这些量再次解析后，存再GlobalUiConfig中
        uiConfigMap.put(UiConfigKey.UI0_CONFIG, uiConfigByLocal.getUi0Config());
        uiConfigMap.put(UiConfigKey.UI1_CONFIG, uiConfigByLocal.getUi1Config());
        isConfigInited = true;
    }

    private static MyConfig getUiConfigByLocal() {
        MyConfig myConfig = null;

        File file = new File(PATH_NAME);
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
        myConfig = new Gson().fromJson(sb.toString(), MyConfig.class);
        return myConfig;
    }

    private static void getUiConfigByNet() {
        //异步，如果拿不到再从本地拿
        //拿到数据后，将数据更新在本地，isConfigInited 为true
        //如果拿不到数据,调用initUiConfigByLocal初始化
        //todo:异步现成
//        这里是测试，直接调用好了

        CountDownTimer timer = new CountDownTimer(SplashActivity.SPLASH_TIME / 3, 1000) {
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
        ShapeConfig shapeConfig = config.getShape();
        if(null != shapeConfig){
            setViewBackground(targetView, shapeConfig);
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

    public static View setViewBackground(View targetView, ShapeConfig config){
        if(checkNull(config)){
            return targetView;
        }
        GradientDrawable shape = ShapeUtil.createShape(config.getStrokeWidth(), config.getRoundRadius(), config.getShape(), config.getStrokeColor(), config.getFillColor());
        targetView.setBackground(shape);
        return targetView;
    }
}
