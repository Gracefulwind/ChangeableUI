package com.example.changeableui.activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.changeableui.R;
import com.example.changeableui.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * @ClassName: NestedAndRecyclerActivity
 * @Author: Gracefulwind
 * @CreateDate: 2020/4/16 11:19
 * @Description: 利用NestEdScroll和RecyclerView实现段落滑动
 * @UpdateUser:
 * @UpdateDate: 2020/4/16 11:19
 * @UpdateRemark:
 * @Version: 1.0
 * @Email: 429344332@qq.com
 */

public class NestedAndRecyclerActivity extends BaseActivity {

    @Override
    protected int getLayout() {
        return R.layout.activity_nested_and_recycler;
    }

    @Override
    protected void initView() {

    }


}
