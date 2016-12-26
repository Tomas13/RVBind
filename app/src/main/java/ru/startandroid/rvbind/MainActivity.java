package ru.startandroid.rvbind;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.startandroid.rvbind.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);

        User user = AppUtilities.getUser();
        mainBinding.setViewModel(new ProfileViewModel(this, user));
    }
}
