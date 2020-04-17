package com.example.changeableui.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.changeableui.R;
import com.example.changeableui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity {

    public static final long SPLASH_TIME = 1000;

    @BindView(R.id.as_tv_countdown)
    TextView asTvCountdown;

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

    }

    /**
     * CountDownTimer timer = new CountDownTimer(3000, 1000)中，
     * 第一个参数表示总时间，第二个参数表示间隔时间。
     * 意思就是每隔一秒会回调一次方法onTick，然后1秒之后会回调onFinish方法。
     */
    @Override
    protected void initData() {
        CountDownTimer timer = new CountDownTimer(SPLASH_TIME, 1000) {
            public void onTick(long millisUntilFinished) {
                asTvCountdown.setText(millisUntilFinished / 1000 + "秒后进入主页");
            }

            public void onFinish() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        };
        timer.start();
    }

}
