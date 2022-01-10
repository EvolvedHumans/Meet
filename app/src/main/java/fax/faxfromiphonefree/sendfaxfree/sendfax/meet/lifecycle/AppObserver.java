package fax.faxfromiphonefree.sendfaxfree.sendfax.meet.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class AppObserver implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate(){
        Log.e("tag","@OnLifecycleEvent(Lifecycle.Event.ON_CREATE)");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume(){
        Log.e("tag","@OnLifecycleEvent(Lifecycle.Event.ON_RESUME)");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause(){
        Log.e("tag","@OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestory(){
        Log.e("tag","@OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)");
    }
}
