package com.example.changeableui.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @ClassName: MyConfig
 * @Author: Gracfulwind
 * @CreateDate: 2020/4/15 16:53
 * @Description: app中全部holder的config存储
 * @UpdateUser:
 * @UpdateDate: 2020/4/15 16:53
 * @UpdateRemark:
 * @Version: 1.0
 * @Email: 429344332@qq.com
 */

public class MyConfig {

    @SerializedName("ui0Config")
    Ui0Config ui0Config;
    @SerializedName("ui1Config")
    Ui1Config ui1Config;


    public Ui0Config getUi0Config() {
        return ui0Config;
    }

    public void setUi0Config(Ui0Config ui0Config) {
        this.ui0Config = ui0Config;
    }

    public Ui1Config getUi1Config() {
        return ui1Config;
    }

    public void setUi1Config(Ui1Config ui1Config) {
        this.ui1Config = ui1Config;
    }
}
