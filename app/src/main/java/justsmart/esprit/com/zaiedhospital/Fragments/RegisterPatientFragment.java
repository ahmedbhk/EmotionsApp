package justsmart.esprit.com.zaiedhospital.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import justsmart.esprit.com.zaiedhospital.R;
import justsmart.esprit.com.zaiedhospital.adapters.MoodsListAdapter;
import justsmart.esprit.com.zaiedhospital.adapters.MoodsListDataModel;
import justsmart.esprit.com.zaiedhospital.adapters.Utils;
import justsmart.esprit.com.zaiedhospital.entities.Mood;
import justsmart.esprit.com.zaiedhospital.entities.Patient;


public class RegisterPatientFragment extends Fragment {
    EditText name;
    EditText age;
    EditText email;
    EditText password;
    Spinner gender;
    Button submit;
   public static ArrayList<MoodsListDataModel> dataModels= new ArrayList<>();
    static Activity mActivity;
    public static MoodsListAdapter adapter;
    public static View itemview;
    public RegisterPatientFragment() {
        // Required empty public constructor
    }


    public static RegisterPatientFragment newInstance() {
        RegisterPatientFragment fragment = new RegisterPatientFragment();
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
        View view = inflater.inflate(R.layout.fragment_register_patient, container, false);
        name= (EditText) view.findViewById(R.id.patient_name);
        age = (EditText) view.findViewById(R.id.patient_age);
        email = (EditText) view.findViewById(R.id.patient_email);
        password = (EditText) view.findViewById(R.id.patient_password);
        gender = (Spinner) view.findViewById(R.id.patient_gender);
        submit = (Button) view.findViewById(R.id.register_patient);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Patient p = new Patient();
                p.setName(name.getText().toString());
                p.setGender(gender.getSelectedItem().toString());
                p.setAge(Integer.parseInt(age.getText().toString()));
                p.setLogin(email.getText().toString());
                p.setPassword(password.getText().toString());
                Utils.addPatient(v.getContext(),p);

                Snackbar.make(v, "User "+p.getLogin()+" added with success", Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                name.setText("");
                age.setText("");
                email.setText("");
                password.setText("");
                gender.setSelection(0);
            }
        });
        return view;

    }

}
