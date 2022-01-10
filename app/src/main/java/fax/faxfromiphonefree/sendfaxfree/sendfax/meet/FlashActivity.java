package fax.faxfromiphonefree.sendfaxfree.sendfax.meet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;

import java.util.LinkedList;
import java.util.List;

import fax.faxfromiphonefree.sendfaxfree.sendfax.meet.adapter.SectionsPagerAdapter;
import fax.faxfromiphonefree.sendfaxfree.sendfax.meet.dialog.PrivacyPolicyDialog;
import fax.faxfromiphonefree.sendfaxfree.sendfax.meet.login.LoginActivity;


public class FlashActivity extends AppCompatActivity {

    private static final String Policy_Param = "PrivacyPolicy";
    private static final String TAG = "fax.faxfromiphonefree.sendfaxfree.sendfax.meet.FlashActivity";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    ViewPager viewPager;
    RadioGroup radioGroup;

    //Fragment轮播
    List<Fragment> mFragments;

    private int preIndex = 0;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);

        viewPager = findViewById(R.id.viewpager);
        radioGroup = findViewById(R.id.group);

        sharedPreferences = getSharedPreferences(SharePreferencesConfig.SharedPreferences, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (!sharedPreferences.getBoolean(Policy_Param,false)){
            PrivacyPolicyDialog privacyPolicyDialog = new PrivacyPolicyDialog(this::setViewPager);
            privacyPolicyDialog.show(getSupportFragmentManager(), TAG);
        }else {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    //ViewPager适配器
    @SuppressLint("UseCompatLoadingForDrawables")
    private void setViewPager() {
        //Fragment添加入集合
        mFragments = new LinkedList<>();
        mFragments.add(new FlashFragment(this, "健康状态实时测", this.getDrawable(R.drawable.flash_1), false));
        mFragments.add(new FlashFragment(this, "电子报告随时读", this.getDrawable(R.drawable.flash_2), false));
        mFragments.add(new FlashFragment(this, "健康资讯天天看", this.getDrawable(R.drawable.flash_3), false));
        mFragments.add(new FlashFragment(this, "健康成员零距离", this.getDrawable(R.drawable.flash_4), true, () -> {
            //todo 保存登录记录
            editor.putBoolean(Policy_Param,true).commit();
            startActivity(new Intent(this, LoginActivity.class));
        }));
        viewPager.setAdapter(new SectionsPagerAdapter(this.getSupportFragmentManager(), mFragments));
        viewPager.setCurrentItem(0);

        for (int i = 0; i < mFragments.size(); i++) {

            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new RadioGroup.LayoutParams(20, 20));
            imageView.setPadding(20, 0, 20, 0);

            //layoutParams 设置margin值
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams
                    (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            if (i != 0) {
                int i1 = (int) (5f + 0.5f);
                layoutParams.setMargins(i1, 0, 0, 0);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }

            if (i == 0) {
                imageView.setEnabled(true);
            } else {
                imageView.setEnabled(false);
            }
            radioGroup.addView(imageView);
        }

        viewPager.setOnPageChangeListener(onPageChangeListener);
    }

    /**
     * 根据当前选中的页面设置按钮的选中
     */
    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            if (viewPager.getChildAt(position) != null) {
                viewPager.getChildAt(position).setEnabled(true);//当前按钮选中 **********************
            }
            if (viewPager.getChildAt(preIndex) != null) {
                viewPager.getChildAt(preIndex).setEnabled(false);//上一个取消选中*********************
                preIndex = position;//当前位置变为上一个，继续下次轮播
            }

            if (position == mFragments.size() - 1) {
                radioGroup.setVisibility(View.GONE);
            } else {
                radioGroup.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}





















