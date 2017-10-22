package justsmart.esprit.com.zaiedhospital.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import justsmart.esprit.com.zaiedhospital.Fragments.PatientHistoryFragment;
import justsmart.esprit.com.zaiedhospital.Fragments.PatientMoodFragment;
import justsmart.esprit.com.zaiedhospital.Fragments.PatientSettingsFragment;


/**
 * Created by BHK on 09/02/2017.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] ;
    public static FragmentManager mFm;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mFm=fm;
        tabTitles = new String[] {
                "Mood",
                "History",
                "Settings"
        };

    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0)
            return PatientMoodFragment.newInstance();
        if (position==1)
            return PatientHistoryFragment.newInstance();
        if (position==2)
            return PatientSettingsFragment.newInstance();

        return PatientHistoryFragment.newInstance();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
