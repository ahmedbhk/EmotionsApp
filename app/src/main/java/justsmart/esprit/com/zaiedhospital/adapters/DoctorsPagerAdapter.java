package justsmart.esprit.com.zaiedhospital.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import justsmart.esprit.com.zaiedhospital.Fragments.DoctorHistoryFragment;
import justsmart.esprit.com.zaiedhospital.Fragments.EditPatientFragment;
import justsmart.esprit.com.zaiedhospital.Fragments.PatientHistoryFragment;
import justsmart.esprit.com.zaiedhospital.Fragments.PatientSettingsFragment;
import justsmart.esprit.com.zaiedhospital.Fragments.RegisterPatientFragment;


/**
 * Created by BHK on 09/02/2017.
 */

public class DoctorsPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] ;
    public static FragmentManager mFm;

    public DoctorsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mFm=fm;
        tabTitles = new String[] {
                "Register a patient",
                "Edit a patient",
                "History report"
        };

    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0)
            return RegisterPatientFragment.newInstance();
        if (position==1)
            return EditPatientFragment.newInstance();
        if (position==2)
            return DoctorHistoryFragment.newInstance();

        return PatientHistoryFragment.newInstance();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
