package fax.faxfromiphonefree.sendfaxfree.sendfax.meet.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.yangf.pub_libs.util.DensityUtil;

import fax.faxfromiphonefree.sendfaxfree.sendfax.meet.BuildConfig;
import fax.faxfromiphonefree.sendfaxfree.sendfax.meet.R;

/**
 * 项目负责人： 杨帆
 * 包名：      fax.faxfromiphonefree.sendfaxfree.sendfax.meet.dialog
 * 描述：      TODO 服务协议与隐私政策
 * 编译环境：  JDK-1_8、SDK-8.0
 * 创建时间：  2022年 01月 10日 14时 42分
 */
public class PrivacyPolicyDialog extends DialogFragment {

    WebView webView;

    public PrivacyPolicyDialog(OnSelectLisnter onSelectLisnter) {
        this.onSelectLisnter = onSelectLisnter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("InflateParams")
        View view = getLayoutInflater().inflate(R.layout.privacypolicy_dialog_layout, container, false);
        webView = view.findViewById(R.id.webView);
        webView.loadUrl(BuildConfig.PRICACY_POLICY_URL);
        webView.setVerticalScrollBarEnabled(false);
        //关闭按钮
        view.findViewById(R.id.noButton).setOnClickListener(view1 -> {
            dismiss();
        });
        //确认按钮
        view.findViewById(R.id.yesButton).setOnClickListener(view2 -> {
            onSelectLisnter.OnSelect();
            dismiss();
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getDialog().getWindow().setLayout(DensityUtil.getScreenWidth() - 100, (DensityUtil.getScreenHeight() / 4 * 3));
    }

    private final OnSelectLisnter onSelectLisnter;

    //隐私政策确认
    public interface OnSelectLisnter {
        void OnSelect();
    }
}
