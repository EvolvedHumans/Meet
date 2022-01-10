package fax.faxfromiphonefree.sendfaxfree.sendfax.meet;

import android.app.Application;
import android.util.Log;

import cn.bmob.v3.Bmob;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

/**
 * 项目负责人： 杨帆
 * 包名：      fax.faxfromiphonefree.sendfaxfree.sendfax.meet
 * 描述：      TODO
 * 编译环境：  JDK-1_8、SDK-8.0
 * 创建时间：  2022年 01月 07日 20时 35分
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

//        //Bmob SDK
//        Bmob.initialize(this, BuildConfig.BMOB_KEY);

//        //RongIM 开启推送功能
//        //todo 最佳用户接受隐私协议后，再进行初始化
//        RongIM.init(this,BuildConfig.RONG_IM_KEY,true);

          //Lifecycle监听生命周期
//        ProcessLifecycleOwner.get().getLifecycle().addObserver(new AppObserver());
    }
}
