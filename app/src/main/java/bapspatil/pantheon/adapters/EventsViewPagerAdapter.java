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
        if(position == 0)
            return "DAY 1";
        else
            return "DAY 2";
    }
}
