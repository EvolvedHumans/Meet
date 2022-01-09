package fax.faxfromiphonefree.sendfaxfree.sendfax.meet.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

public class CountViewModel extends AndroidViewModel {
    public int count;

    public CountViewModel(@NonNull Application application) {
        super(application);
    }
}
