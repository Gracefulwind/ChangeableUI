package com.example.changeableui.entity;

/**
  *
  * @ClassName:      GlobalUiConfig
  * @Author:         Gracefulwind
  * @CreateDate:     2020/4/15 10:55
  * @Description:    控制全局ui用，单例
 * 考虑下赋值问题。。。单例不好Gson，得手动一个个给值
  *
  * @UpdateUser:
  * @UpdateDate:     2020/4/15 10:55
  * @UpdateRemark:
  * @Version:        1.0
  * @Email 429344332@qq.com
 */


public class GlobalUiConfig {

    private static GlobalUiConfig mConfig;

    public synchronized static GlobalUiConfig getInstance(){
        if(null == mConfig){
            mConfig = new GlobalUiConfig();
        }
        return mConfig;
    }

}
