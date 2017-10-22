package justsmart.esprit.com.zaiedhospital.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import justsmart.esprit.com.zaiedhospital.R;


public class PatientSettingsFragment extends Fragment {

    public PatientSettingsFragment() {
        // Required empty public constructor
    }


    public static PatientSettingsFragment newInstance() {
        PatientSettingsFragment fragment = new PatientSettingsFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_patient_settings, container, false);
    }

}
