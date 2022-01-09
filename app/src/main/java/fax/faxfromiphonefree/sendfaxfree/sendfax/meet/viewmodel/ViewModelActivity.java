package fax.faxfromiphonefree.sendfaxfree.sendfax.meet.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import fax.faxfromiphonefree.sendfaxfree.sendfax.meet.R;

public class ViewModelActivity extends AppCompatActivity {

    CountViewModel countViewModel;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);

        textView = findViewById(R.id.text);

        countViewModel = new ViewModelProvider(this, new ViewModelProvider.
                AndroidViewModelFactory(getApplication())).get(CountViewModel.class);


        textView.setText(String.valueOf(countViewModel.count));

        findViewById(R.id.buttonPanel).setOnClickListener(view -> {
            textView.setText(String.valueOf(++countViewModel.count));
        });

    }
}