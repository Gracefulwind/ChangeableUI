package com.example.changeableui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.example.changeableui.R;
import com.example.changeableui.R2;
import com.example.changeableui.base.BaseActivity;
import com.example.changeableui.entity.Ui0Config;
import com.example.changeableui.entity.Ui1Config;
import com.example.changeableui.test.TestMapBeanA;
import com.example.changeableui.test.TestMapBeanB;
import com.example.changeableui.utils.UiConfigUtils;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    //---ui0------------------
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
    //---ui1--------------------
    @BindView(R.id.am_ll_ui1)
    LinearLayout amLlUi1;
    @BindView(R.id.tv_item_title)
    TextView tvItemTitle;
    @BindView(R.id.tv_item_clicked)
    TextView tvItemClicked;
    @BindView(R.id.tv_tag_news)
    TextView tvTagNews;
    @BindView(R.id.iv_time_news)
    TextView ivTimeNews;
    @BindView(R.id.iv_left_image)
    ImageView ivLeftImage;
    @BindView(R.id.iv_radio_news)
    ImageView ivRadioNews;


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        initUi0();

    }

//--刷新UI布局-----------------------------------
    private void initUi0() {
        setUi0ByConfig();
        setUi1ByConfig();

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

    private void setUi1ByConfig() {
        Ui1Config uiConfig = (Ui1Config) UiConfigUtils.getUiConfig(UiConfigUtils.UiConfigKey.UI1_CONFIG);
        //后续把这些方法放到utils里
//        UiConfigUtils.setUiByConfig();
        UiConfigUtils.setCommonTextViewConfigInLinear(tvItemTitle, uiConfig.getTv_item_title());
        UiConfigUtils.setCommonTextViewConfigInRelative(tvItemClicked, uiConfig.getTv_item_clicked());
        UiConfigUtils.setCommonTextViewConfigInRelative(tvTagNews, uiConfig.getTv_tag_news());
        UiConfigUtils.setCommonTextViewConfigInRelative(ivTimeNews, uiConfig.getIv_time_news());
        UiConfigUtils.setCommonImageViewConfigInConstraint(ivLeftImage, uiConfig.getIv_left_image());
        UiConfigUtils.setCommonImageViewConfigInConstraint(ivRadioNews, uiConfig.getIv_radio_news());
    }

//--写数据--------------------------------------------
    @Override
    protected void initData() {
        refreshUi0();
        refreshUi1();
    }

    private void refreshUi0() {
        Glide.with(this).load("http://o.cztvcloud.com/221/thumb/2020/04/09/1a5fb70ef99ddf92a0931e72f4dafcfa.jpg").into(amIvUi0LeftImage);
        amUi0TvItemTitle.setText("浙江日报评论员|鉴定信心决心，不断深化改革开放——四轮学习贯彻习近平总书记考察浙江重要说话精神");
        amUi0TvItemClicked.setText("3243");
        amIvUi0TimeNews.setText("3天前");
    }

    private void refreshUi1() {
        tvItemTitle.setText("2569中秋夜86倍长焦镜头看圆月：飞机从月亮前滑过");
        Glide.with(this).load("http://shixiantest.oss-cn-hangzhou.aliyuncs.com/62/thumb/2019/09/15/0efc0cd147474d0b93fd2ec8f270d5a7.jpg").into(ivLeftImage);
        tvItemClicked.setText("3243");
        tvTagNews.setText("标签1");
//        ivTimeNews.setText("6天前");
    }

    @OnClick({R2.id.am_ll_ui0, R.id.am_ll_ui1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.am_ll_ui0:
                Toast.makeText(this, "打开一类UI", Toast.LENGTH_SHORT).show();
                setUi0ByConfig();
                System.out.println("----onViewClicked----am_ll_ui0---");
                System.out.println("----onViewClicked----am_ll_ui0---");
                break;
            case R.id.am_ll_ui1:
                Toast.makeText(this, "打开2类UI", Toast.LENGTH_SHORT).show();
                System.out.println("----onViewClicked----am_ll_ui1---");
                String testStr = "{\"testMap\":{\"keyA\":\"valueA\",\"KkeyB\":\"valueB\"},\"testMapB\": {\"a\":\"aaa\",\"b\":\"bbb\",\"c\":\"ccc\"},\"data\":[{\"id\":5771,\"name\":\"便民服务\",\"category_type\":\"common\",\"type\":51,\"type_name\":\"聚合服务\",\"logo\":\"\",\"app_style\":\"news\",\"allow_comment\":1,\"sort\":\"4915\",\"intro\":\"\",\"tips\":\"\"},{\"id\":5772,\"name\":\"分类信息\",\"category_type\":\"common\",\"type\":34,\"type_name\":\"聚合外链-认证\",\"logo\":\"\",\"app_style\":\"news\",\"allow_comment\":1,\"sort\":\"4916\",\"intro\":\"\",\"tips\":\"\"},{\"id\":6886,\"name\":\"政务公开\",\"category_type\":\"common\",\"type\":84,\"type_name\":\"工具聚合\",\"logo\":\"\",\"app_style\":\"news\",\"allow_comment\":1,\"sort\":\"7051\",\"intro\":\"\",\"tips\":\"\"}]}\n";
                TestMapBeanA testMapBeanA = new Gson().fromJson(testStr, TestMapBeanA.class);
                TestMapBeanB testMapBeanB = new Gson().fromJson(testStr, TestMapBeanB.class);
                System.out.println("----onViewClicked----am_ll_ui1---");
                System.out.println("----onViewClicked----am_ll_ui1---");
                ARouter.getInstance().build("/test/TestMyArouterActivity").navigation();
//                tvItemTitle.setMaxLines(1);
//                setUi0ByConfig();
                break;
            default:
                break;
        }
    }
}
