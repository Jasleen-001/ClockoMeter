package com.jasleen.clocko_meter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        FragmentTimer timerFragment = new FragmentTimer();
        FragmentClock clockFragment = new FragmentClock();
        FragmentStopwatch stopwatchFragment = new FragmentStopwatch();
        bottomNavigationView.setSelectedItemId(R.id.clock);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.clock:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, clockFragment).commit();
                        return true;

                    case R.id.timer:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, timerFragment).commit();
                        return true;

                    case R.id.stopwatch:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, stopwatchFragment).commit();
                        return true;
                }

                return true;
            }

        });
    }
}



