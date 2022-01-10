package fax.faxfromiphonefree.sendfaxfree.sendfax.meet.livedata;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * 项目负责人： 杨帆
 * 包名：      fax.faxfromiphonefree.sendfaxfree.sendfax.meet.livedata
 * 描述：      TODO
 * 编译环境：  JDK-1_8、SDK-8.0
 * 创建时间：  2022年 01月 10日 11时 35分
 */
public class LiveDataViewModel extends ViewModel {

    public MutableLiveData<Integer> integerMutableLiveData;

    public MutableLiveData<Integer> integerMutableLiveData1;

    public MediatorLiveData<Integer> integerMediatorLiveData;

    public MutableLiveData<Integer> getIntegerMutableLiveData(){
        if (integerMutableLiveData == null){
            integerMutableLiveData = new MutableLiveData<>();
            //主线程用setValue()，子线程用postValue()
            integerMutableLiveData.setValue(0);
        }
        return integerMutableLiveData;
    }

    public MutableLiveData<Integer> getIntegerMutableLiveData1(){
        if (integerMutableLiveData1 == null){
            integerMutableLiveData1 = new MutableLiveData<>();
            //主线程用setValue()，子线程用postValue()
            integerMutableLiveData1.setValue(0);
        }
        return integerMutableLiveData1;
    }

    public MediatorLiveData<Integer> getIntegerMediatorLiveData(){
        if (integerMediatorLiveData == null){
            integerMediatorLiveData = new MediatorLiveData<>();
            //主线程用setValue()，子线程用postValue()
            integerMediatorLiveData.setValue(0);
        }
        return integerMediatorLiveData;
    }
}
