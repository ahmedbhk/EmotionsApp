package justsmart.esprit.com.zaiedhospital;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;

import justsmart.esprit.com.zaiedhospital.Services.ServiceNotification;
import justsmart.esprit.com.zaiedhospital.adapters.FeedReaderDbHelper;
import justsmart.esprit.com.zaiedhospital.adapters.Utils;
import justsmart.esprit.com.zaiedhospital.entities.Patient;

public class SplashActivity extends AppCompatActivity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 500;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        startService(new Intent(this, ServiceNotification.class));
//        Utils.resetGenders(this);
//        Utils.getPatients(this);
//        Utils.registerPatient(this, "user@user.com","123456789","Ali chwerreb","Male");
//        Utils.registerPatient(this, "user2@user.com","123456789","Alia chwerreb","Female");

        //Log.d("hgfg",Utils.getPatient(this,"user@user.com","123456789").toString());
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent;
                /* Create an Intent that will start the Menu-Activity. */
                if((Utils.patientOn == null)&&(!Utils.adminOn)){
                     mainIntent = new Intent(SplashActivity.this,LoginActivity.class);
                }else
                    if(Utils.patientOn!=null)
                    mainIntent= new Intent(SplashActivity.this,MainPatientActivity.class);
                else
                    mainIntent= new Intent(SplashActivity.this,MainDoctorActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}