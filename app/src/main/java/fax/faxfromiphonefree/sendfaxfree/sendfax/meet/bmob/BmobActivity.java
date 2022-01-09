package fax.faxfromiphonefree.sendfaxfree.sendfax.meet.bmob;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import fax.faxfromiphonefree.sendfaxfree.sendfax.meet.R;

public class BmobActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         //添加数据
//        User user = new User();
//        user.setName("杨帆");
//        user.setPassWord("1234343");
//        user.save(new SaveListener<String>() {
//            @Override
//            public void done(String s, BmobException e) {
//                if (e == null) {
//                    Log.e("tag", s);
//                    Toast.makeText(BmobActivity.this, "添加成功:" + s, Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        //获取数据
//        BmobQuery<User> bmobQuery = new BmobQuery<>();
//        bmobQuery.getObject("11a014e53a", new QueryListener<User>() {
//            @Override
//            public void done(User user, BmobException e) {
//                Log.e("tag", user.getName());
//                Log.e("tag", user.getPassWord());
//            }
//        });

//        //修改数据
//        User user = new User();
//        user.setName("杨毅");
//        user.setPassWord("123");
//        user.update("11a014e53a", new UpdateListener() {
//            @Override
//            public void done(BmobException e) {
//                if (e == null){
//                    Log.d("tag","修改成功");
//                }
//            }
//        });

        //删除数据
//        User user = new User();
//        user.delete("3c08fe45d4",new UpdateListener() {
//            @Override
//            public void done(BmobException e) {
//                if (e == null){
//                    Log.e("tag","删除成功");
//                }
//            }
//        });

//        //注册成功
//        _User user = new _User();
//        user.setUsername("username");
//        user.setPassword("password");
//        user.signUp(new SaveListener<_User>() {
//            @Override
//            public void done(_User user1, BmobException e) {
//                if (user1 == null){
//                    Log.e("tag","注册成功");
//                }
//            }
//        });

        //账号密码登录
        _User user1 = new _User();
        user1.setUsername("username");
        user1.setPassword("password");
        user1.login(new SaveListener<_User>() {
            @Override
            public void done(_User user, BmobException e) {
                if (e == null){
                    Log.e("tag","登录成功");
                }
            }
        });

        //判断当前登录的用户
        if (BmobUser.isLogin()){
            _User user2 = BmobUser.getCurrentUser(_User.class);
            Log.e("tag","已经登录");
        }
    }

}