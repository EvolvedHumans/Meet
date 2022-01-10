package fax.faxfromiphonefree.sendfaxfree.sendfax.meet.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.lifecycle.LifecycleService;

public class MyService extends LifecycleService {

    private AppObserver appObserver;

    public MyService() {
        appObserver = new AppObserver();
        getLifecycle().addObserver(appObserver);
    }
}