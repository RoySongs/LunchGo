package lunchrec.sgs.com.lunchrec.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import lunchrec.sgs.com.lunchrec.R;
import lunchrec.sgs.com.lunchrec.fragment.OneFragment;
import lunchrec.sgs.com.lunchrec.fragment.ThirdFragment;
import lunchrec.sgs.com.lunchrec.fragment.TwoFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    int numTabs;
    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs = numTabs;
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).


        switch (position){
            case 0:
                OneFragment oneFragment = new OneFragment();
                return oneFragment;

            case 1:
                TwoFragment twoFragment = new TwoFragment();
                return twoFragment;

            case 2:
                ThirdFragment thirdFragment = new ThirdFragment();
                return thirdFragment;

            default:
                return null;
        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return numTabs;
    }
}