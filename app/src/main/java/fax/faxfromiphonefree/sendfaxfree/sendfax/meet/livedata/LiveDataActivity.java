package fax.faxfromiphonefree.sendfaxfree.sendfax.meet.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

import fax.faxfromiphonefree.sendfaxfree.sendfax.meet.R;

public class LiveDataActivity extends AppCompatActivity {

    TextView textView;
    TextView textView1;
    TextView textView2;

    LiveDataViewModel liveDataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        textView = findViewById(R.id.text);
        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);

        liveDataViewModel = new ViewModelProvider
                (this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(LiveDataViewModel.class);

        textView.setText(String.valueOf(liveDataViewModel.getIntegerMutableLiveData().getValue()));
        textView1.setText(String.valueOf(liveDataViewModel.getIntegerMutableLiveData1().getValue()));
        textView2.setText(String.valueOf(liveDataViewModel.getIntegerMediatorLiveData()));

        liveDataViewModel.getIntegerMediatorLiveData().addSource(liveDataViewModel.getIntegerMutableLiveData(), integer -> {
            //数据发生改变，更新UI
            textView.setText(String.valueOf(integer));
        });

        liveDataViewModel.getIntegerMediatorLiveData().addSource(liveDataViewModel.getIntegerMutableLiveData1(), integer -> {
            textView1.setText(String.valueOf(integer));
        });

        liveDataViewModel.getIntegerMediatorLiveData().observe(this, integer -> {
            textView2.setText(String.valueOf(integer));
        });

//        //LiveData监听器
//        liveDataViewModel.getIntegerMutableLiveData().observe(this, integer -> {
//            //数据发生改变，更新UI
//            textView.setText(String.valueOf(integer));
//        });
//
//        liveDataViewModel.getIntegerMutableLiveData1().observe(this, integer -> {
//            textView1.setText(String.valueOf(integer));
//        });

        //持续改变数据1
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //改变LiveData的值，当前线程为非UI线程
                liveDataViewModel.getIntegerMutableLiveData().postValue
                        (liveDataViewModel.getIntegerMutableLiveData().getValue() + 1);
            }
        }, 1000, 1000);

        //持续改变数据2
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //改变LiveData的值，当前线程为非UI线程
                liveDataViewModel.getIntegerMutableLiveData1().postValue
                        (liveDataViewModel.getIntegerMutableLiveData1().getValue() + 1);
            }
        }, 500, 500);

        //持续改变数据3
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //改变LiveData的值，当前线程为非UI线程
                liveDataViewModel.getIntegerMediatorLiveData().postValue
                        (liveDataViewModel.getIntegerMediatorLiveData().getValue() + 1);
            }
        }, 2000, 2000);

    }

}



















