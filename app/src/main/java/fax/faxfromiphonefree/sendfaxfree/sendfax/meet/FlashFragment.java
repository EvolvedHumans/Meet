package fax.faxfromiphonefree.sendfaxfree.sendfax.meet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FlashFragment extends Fragment {

    private final String mString;
    private final Drawable mDrawable;
    private final boolean mGone;

    FlashActivity flashActivity;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public FlashFragment(Context mContext, String string, Drawable mDrawable, boolean gone) {
        flashActivity = (FlashActivity) mContext;
        this.mString = string;
        this.mDrawable = mDrawable;
        this.mGone = gone;
    }

    public FlashFragment(Context mContext, String string, Drawable mDrawable, boolean gone, OnSelectLisnter onSelectLisnter) {
        flashActivity = (FlashActivity) mContext;
        this.mString = string;
        this.mDrawable = mDrawable;
        this.mGone = gone;
        this.onSelectLisnter = onSelectLisnter;
    }

    @SuppressLint("CommitPrefEdits")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flash, container, false);

        ImageView imageView = view.findViewById(R.id.iv_flash);
        TextView textView = view.findViewById(R.id.txt_detail);
        Button button = view.findViewById(R.id.btn_start);

        sharedPreferences = flashActivity.getSharedPreferences
                (SharePreferencesConfig.SharedPreferences, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        //设置文字提示
        textView.setText(mString);
        // 设置背景图
        imageView.setImageDrawable(mDrawable);
        // 设置按钮是否显示
        if (mGone) {
            button.setVisibility(View.VISIBLE);
            button.setOnClickListener(view1 -> {
                if (onSelectLisnter != null){
                    onSelectLisnter.OnSelect();
                }
            });
        }
        // Inflate the layout for this fragment
        return view;
    }

    private OnSelectLisnter onSelectLisnter;

    //隐私政策确认
    public interface OnSelectLisnter {
        void OnSelect();
    }
}