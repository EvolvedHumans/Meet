package fax.faxfromiphonefree.sendfaxfree.sendfax.meet.lifecycle;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class LifecycleView extends androidx.appcompat.widget.AppCompatTextView implements LifecycleObserver {

    public LifecycleView(Context context) {
        super(context);
    }

    public LifecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LifecycleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

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
