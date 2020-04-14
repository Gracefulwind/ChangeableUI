package com.example.changeableui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.changeableui.R;
import com.example.changeableui.entity.Ui0Config;
import com.example.changeableui.utils.UiConfigUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.am_iv_ui0_left_image)
    ImageView amIvUi0LeftImage;
    @BindView(R.id.am_cl_ui0_left_image)
    ConstraintLayout amClUi0LeftImage;
    @BindView(R.id.am_ui0_tv_item_title)
    TextView amUi0TvItemTitle;
    @BindView(R.id.am_ui0_tv_item_clicked)
    TextView amUi0TvItemClicked;
    @BindView(R.id.am_tv_ui0_tag_news)
    TextView amTvUi0TagNews;
    @BindView(R.id.am_iv_ui0_time_news)
    TextView amIvUi0TimeNews;
    @BindView(R.id.am_ll_ui0)
    LinearLayout amLlUi0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();


    }

    private void initView() {

        initUi0();

    }

    private void initUi0() {
        setUi0ByConfig();

    }

    private void setUi0ByConfig() {
        Ui0Config uiConfig = (Ui0Config) UiConfigUtils.getUiConfig(UiConfigUtils.UiConfigKey.UI0_CONFIG);
        //后续把这些方法放到utils里
        UiConfigUtils.setUiByConfig();
        UiConfigUtils.setCommonTextViewConfigInLinear(amUi0TvItemTitle, uiConfig.getRightTitle());
        UiConfigUtils.setCommonTextViewConfigInRelative(amUi0TvItemClicked, uiConfig.getRightClickCounts());
        UiConfigUtils.setCommonTextViewConfigInRelative(amIvUi0TimeNews, uiConfig.getLeftTimeNews());
        UiConfigUtils.setCommonImageViewConfigInConstraint(amIvUi0LeftImage, uiConfig.getLeftImage());
    }

    private void initData() {
        refreshUi0();
    }

    private void refreshUi0() {
//        Glide.with(this).load("http://o.cztvcloud.com/221/thumb/2020/04/09/1a5fb70ef99ddf92a0931e72f4dafcfa.jpg").into(amIvUi0LeftImage);
        amUi0TvItemTitle.setText("浙江日报评论员|鉴定信心决心，不断深化改革开放——四轮学习贯彻习近平总书记考察浙江重要说话精神");
        amUi0TvItemClicked.setText("3243");
        amIvUi0TimeNews.setText("6天前");
    }

    @OnClick({R.id.am_ll_ui0})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.am_ll_ui0:
                Toast.makeText(this, "打开一类UI", Toast.LENGTH_SHORT).show();
                setUi0ByConfig();
                break;
            default:
                break;
        }
    }
}
