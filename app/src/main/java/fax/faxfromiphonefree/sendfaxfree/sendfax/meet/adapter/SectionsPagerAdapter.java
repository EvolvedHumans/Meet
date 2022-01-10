package fax.faxfromiphonefree.sendfaxfree.sendfax.meet.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 项目负责人： 杨帆
 * 包名：      fax.faxfromiphonefree.sendfaxfree.sendfax.meet
 * 描述：      TODO Fragment + ViewPager页面切换
 * 编译环境：  JDK-1_8、SDK-8.0
 * 创建时间：  2022年 01月 07日 20时 35分
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> mFragments;

    public SectionsPagerAdapter(FragmentManager fm, List<Fragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    @NotNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}














