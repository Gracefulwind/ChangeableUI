package com.example.changeableui;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.changeableui.utils.UiConfigUtils;
import com.example.changeableui.utils.UiUtil;

import java.util.HashMap;
import java.util.Map;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initData();
    }

    private void initData() {
        initX5WebView();
        initUiConfig();
        initUiUtil();
        initArouter();
    }

//==================================================================================================================
    private void initArouter() {
        if (isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);
    }

    private boolean isDebug() {
        return true;
    }

//=========================================================================================================

    private void initUiConfig() {
        UiConfigUtils.initUiConfig(this);
    }

     private void initUiUtil() {
         UiUtil.initUiUtil(this);
    }


    //=================================================================================
    private void initX5WebView() {
//        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
//
//            @Override
//            public void onViewInitFinished(boolean arg0) {
//                // TODO Auto-generated method stub
//                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
//                Log.d("app", " onViewInitFinished is " + arg0);
//            }
//
//            @Override
//            public void onCoreInitFinished() {
//                // TODO Auto-generated method stub
//            }
//        };
//        //x5内核初始化接口
//        QbSdk.initX5Environment(getApplicationContext(),  cb);
    }

}
