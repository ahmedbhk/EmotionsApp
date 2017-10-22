package justsmart.esprit.com.zaiedhospital.Fragments;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import net.sqlcipher.database.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import justsmart.esprit.com.zaiedhospital.R;
import justsmart.esprit.com.zaiedhospital.adapters.FeedReaderContract;
import justsmart.esprit.com.zaiedhospital.adapters.FeedReaderDbHelper;
import justsmart.esprit.com.zaiedhospital.adapters.Utils;
import justsmart.esprit.com.zaiedhospital.entities.Mood;


public class PatientMoodFragment extends Fragment {

    static List<Mood> moods;
    static Context mContext;
    static Activity mActivity;
    static Mood selectedMood;
//    static View lastSelectedView;
    public PatientMoodFragment() {
        // Required empty public constructor
    }


    public static PatientMoodFragment newInstance() {
        PatientMoodFragment fragment = new PatientMoodFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectedMood=new Mood();
        moods = new ArrayList<>();
        mContext=getContext();
        mActivity=getActivity();



    }

    public static void select(View v){
//        if(lastSelectedView!=null)
//            lastSelectedView.setBackgroundColor(Color.WHITE);
//        lastSelectedView=v;

        for (Mood m :
                moods) {
            if(v.getTag().equals(m.getName()))
            {
                Log.e("mawjoud",v.getTag()+"");
            }
        }
        
        if(moods.contains(new Mood(v.getTag().toString())))
        {
            v.setBackgroundColor(Color.WHITE);
            moods.remove(new Mood(v.getTag().toString()));
            Log.e("mood n9os",moods.toString());
        }
        else {
            selectedMood.setName(v.getTag().toString());
            ShowDialog(v);

        }
        Log.e("liste",moods.toString());
    }
    public void resetMoods(){
        moods.removeAll(moods);
        selectedMood=new Mood();
        mActivity.findViewById(R.id.angry).setBackgroundColor(Color.WHITE);
        mActivity.findViewById(R.id.sad).setBackgroundColor(Color.WHITE);
        mActivity.findViewById(R.id.happy).setBackgroundColor(Color.WHITE);
        mActivity.findViewById(R.id.fearful).setBackgroundColor(Color.WHITE);
        mActivity.findViewById(R.id.bored).setBackgroundColor(Color.WHITE);
        mActivity.findViewById(R.id.depressed).setBackgroundColor(Color.WHITE);
        mActivity.findViewById(R.id.worried).setBackgroundColor(Color.WHITE);
        mActivity.findViewById(R.id.lonely).setBackgroundColor(Color.WHITE);
        mActivity.findViewById(R.id.ashamed).setBackgroundColor(Color.WHITE);
        mActivity.findViewById(R.id.panicking).setBackgroundColor(Color.WHITE);
        mActivity.findViewById(R.id.neutral).setBackgroundColor(Color.WHITE);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_patient_mood, container, false);
        final CharSequence msg=  "Hello "+Utils.patientOn.getName()+". Get well soon";

        Button submitButton = (Button) view.findViewById(R.id.submitMood);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moods.size()!=0){
                    Toast.makeText(getContext(), "Moods Saved !!", Toast.LENGTH_SHORT).show();
                    Utils.saveMoods(mContext,moods);
                    resetMoods();

                }
                else{
                    Toast.makeText(getContext(), "Please choose mood(s)", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
    public static void ShowDialog(View v)
    {
        final View view=v;
        final AlertDialog.Builder popDialog = new AlertDialog.Builder(mContext);
        final LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(mActivity.LAYOUT_INFLATER_SERVICE);
        final View viewLayout = inflater.inflate(R.layout.dialog_layout,(ViewGroup) mActivity.findViewById(R.id.forDialog));
         SeekBar level ;
        //popDialog.setIcon(android.R.drawable.btn_star_big_on);
        popDialog.setTitle("Please Select Level ");

        popDialog.setView(viewLayout);
        level = (SeekBar) viewLayout.findViewById(R.id.level2);
        final TextView tvLevel= (TextView) viewLayout.findViewById(R.id.textLevel2);
        final EditText explaination= (EditText) viewLayout.findViewById(R.id.explainationEditText);
        level.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress==0)
                    tvLevel.setText("LOW");
                else if(progress==1)
                    tvLevel.setText("MEDIUM");
                else if(progress==2)
                    tvLevel.setText("HIGH");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // Button OK
        popDialog.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        selectedMood.setLevel(tvLevel.getText().toString());
                        selectedMood.setPatientId(Utils.patientOn.getPatientId());
                        selectedMood.setExplaination(explaination.getText().toString());
                        moods.add(selectedMood);
                        Log.e("mood tzed",moods.toString());

                        view.setBackgroundColor(Color.RED);
                        selectedMood= new Mood();
                        dialog.dismiss();
                    }
                });
        popDialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                view.setBackgroundColor(Color.WHITE);
                Log.e("Battelna",moods.toString());
                selectedMood= new Mood();
                dialog.dismiss();
            }});
        popDialog.create();
        popDialog.show();

    }

}
