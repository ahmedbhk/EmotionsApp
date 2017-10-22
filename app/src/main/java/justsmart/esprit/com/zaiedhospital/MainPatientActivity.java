package justsmart.esprit.com.zaiedhospital;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.astuetz.PagerSlidingTabStrip;

import java.util.zip.Inflater;

import justsmart.esprit.com.zaiedhospital.Fragments.PatientMoodFragment;
import justsmart.esprit.com.zaiedhospital.adapters.MyFragmentPagerAdapter;
import justsmart.esprit.com.zaiedhospital.adapters.Utils;
import justsmart.esprit.com.zaiedhospital.entities.Patient;

public class MainPatientActivity extends AppCompatActivity {
    public static Activity mActivity;
PatientMoodFragment mood;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = (View) findViewById(R.id.submitMood);
        mActivity=this;

        setContentView(R.layout.activity_main_patient);

        viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),this));


        // Give the PagerSlidingTabStrip the ViewPager
        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(viewPager);
    }
    public void select(View v){
        mood.select(v);
    }

}
