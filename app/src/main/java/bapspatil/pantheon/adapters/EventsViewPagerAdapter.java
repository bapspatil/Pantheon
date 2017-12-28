package bapspatil.pantheon.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import bapspatil.pantheon.ui.DayFragment;

/**
 * Created by bapspatil
 */

public class EventsViewPagerAdapter extends FragmentStatePagerAdapter {

    public EventsViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return DayFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "DAY 1";
            case 1:
                return "DAY 2";
            default:
                return "DAY 1";
        }
    }
}
