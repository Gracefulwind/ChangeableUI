package com.example.mytestlibrary.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mytestlibrary.R;

/**
 * @ClassName: TestMyArouterActivity
 * @Author: Gracefulwind
 * @CreateDate: 2020/4/17 16:42
 * @Description: ---------------------------
 * @UpdateUser:
 * @UpdateDate: 2020/4/17 16:42
 * @UpdateRemark:
 * @Version: 1.0
 * @Email: 429344332@qq.com
 */

@Route(path = "/test/TestMyArouterActivity")
public class TestMyArouterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_my_arouter);

    }


}
