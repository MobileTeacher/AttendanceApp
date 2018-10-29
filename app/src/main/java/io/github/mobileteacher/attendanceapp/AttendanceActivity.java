package io.github.mobileteacher.attendanceapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AttendanceActivity extends AppCompatActivity {

    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        viewPager = findViewById(R.id.view_pager);

        AttendancePagerAdapter adapter =
                new AttendancePagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
    }
}
