package io.github.mobileteacher.attendanceapp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AttendancePagerAdapter extends FragmentPagerAdapter {

    int numberOfFragments = 2;

    public AttendancePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new RegisterAttendanceFragment();
            case 1:
                return new HistoryFragment();
            default: return new RegisterAttendanceFragment();
        }
    }

    @Override
    public int getCount() {
        return numberOfFragments;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Hoje";
            case 1:
                return "Histórico";
            default: return "XABU";
        }
    }
}
