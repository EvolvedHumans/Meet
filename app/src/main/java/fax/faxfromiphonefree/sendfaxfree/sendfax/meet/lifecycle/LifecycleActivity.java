package fax.faxfromiphonefree.sendfaxfree.sendfax.meet.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fax.faxfromiphonefree.sendfaxfree.sendfax.meet.R;

public class LifecycleActivity extends AppCompatActivity {

    LifecycleView lifecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        lifecycleView = findViewById(R.id.lifecycle_view);
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
        lifecycleView.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, MyService.class);
            stopService(intent1);
        });
    }
}