package fax.faxfromiphonefree.sendfaxfree.sendfax.meet.bmob;

import cn.bmob.v3.BmobObject;

/**
 * 项目负责人： 杨帆
 * 包名：      fax.faxfromiphonefree.sendfaxfree.sendfax.meet.bmob
 * 描述：      TODO User用户表
 * 编译环境：  JDK-1_8、SDK-8.0
 * 创建时间：  2022年 01月 07日 20时 45分
 */
public class User extends BmobObject {
    private String name;
    private String passWord;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
