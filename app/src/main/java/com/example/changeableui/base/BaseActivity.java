package com.example.changeableui.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

import com.example.changeableui.R;

import butterknife.ButterKnife;

/**
 * @ClassName: BaseActivity
 * @Author: Gracefulwind
 * @CreateDate: 2020/4/16 11:21
 * @Description: ---------------------------
 * @UpdateUser:
 * @UpdateDate: 2020/4/16 11:21
 * @UpdateRemark:
 * @Version: 1.0
 * @Email: 429344332@qq.com
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initView();
        initData();


    }

    protected abstract @LayoutRes int getLayout();

     /**
      * @method  初始化ui，必须实现
      * @description
      * @date: 2020/4/16 11:23
      * @author: Gracefulwind
      * @param
      * @return
      * @Email 429344332@qq.com
      */
    protected abstract void initView();

     /**
      * @method  初始化数据，如果静态页面则不需要覆写
      * @description
      * @date: 2020/4/16 11:24
      * @author: Gracefulwind
      * @param
      * @return
      * @Email 429344332@qq.com
      */
    protected void initData(){}
}
