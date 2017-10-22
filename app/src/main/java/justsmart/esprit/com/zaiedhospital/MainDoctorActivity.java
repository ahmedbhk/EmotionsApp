package justsmart.esprit.com.zaiedhospital;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;

import justsmart.esprit.com.zaiedhospital.Fragments.PatientMoodFragment;
import justsmart.esprit.com.zaiedhospital.adapters.DoctorsPagerAdapter;
import justsmart.esprit.com.zaiedhospital.adapters.MyFragmentPagerAdapter;

public class MainDoctorActivity extends AppCompatActivity {
    public static Activity mActivity;
PatientMoodFragment mood;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity=this;
        setContentView(R.layout.activity_main_doctor);

        viewPager = (ViewPager) findViewById(R.id.DoctorContainer);
        viewPager.setAdapter(new DoctorsPagerAdapter(getSupportFragmentManager(),this));


        // Give the PagerSlidingTabStrip the ViewPager
        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.DoctorTabs);
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(viewPager);
    }
    public void select(View v){
        mood.select(v);
    }

}
