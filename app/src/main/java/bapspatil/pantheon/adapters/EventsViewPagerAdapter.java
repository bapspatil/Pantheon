package bapspatil.pantheon.adapters;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import bapspatil.pantheon.ui.DayFragment;

/**
 * Created by bapspatil
 */

public class EventsViewPagerAdapter extends FragmentStatePagerAdapter {
    private final String[] pages = new String[]{"DAY 1", "DAY 2"};

    public EventsViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return DayFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return pages.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pages[position];
    }
}
