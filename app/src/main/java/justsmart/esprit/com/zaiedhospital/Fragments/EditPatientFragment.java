package justsmart.esprit.com.zaiedhospital.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import justsmart.esprit.com.zaiedhospital.R;
import justsmart.esprit.com.zaiedhospital.adapters.Utils;
import justsmart.esprit.com.zaiedhospital.entities.Patient;


public class EditPatientFragment extends Fragment {
    static Activity mActivity;
    int indexToEdit;
    Patient patientUpdate = new Patient();
    public Spinner patientsSpinner;
    public Context mContext;
    public ArrayList<Patient> patients;
    List<String>patientsNames = new ArrayList<String>();
    List<String> nursesNames = new ArrayList<String>();
    EditText patientNameEdit;
    EditText ageEdit;
    Spinner genderEdit;
    Spinner nurseEdit;
    EditText bedNumberEdit;
    EditText emailEdit;
    EditText passwordEdit;
    Button submitButton;
    public EditPatientFragment() {
        // Required empty public constructor
    }
    public static EditPatientFragment newInstance() {
        EditPatientFragment fragment = new EditPatientFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        mActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        nursesNames.add("Monia");
        nursesNames.add("Lamia");
        nursesNames.add("Sarra");
        nursesNames.add("Houda");
        nursesNames.add("Saadeya");
        nursesNames.add("Samira");
        nursesNames.add("Masouda");
        nursesNames.add("Jamila");

        View view = inflater.inflate(R.layout.fragment_edit_patient, container, false);
        submitButton= (Button) view.findViewById(R.id.apply_changes);

        patientNameEdit = (EditText) view.findViewById(R.id.patient_name_edit);
        ageEdit = (EditText) view.findViewById(R.id.age_edit);
        genderEdit = (Spinner) view.findViewById(R.id.gender_edit);
        bedNumberEdit= (EditText) view.findViewById(R.id.bed_number_edit);
        emailEdit = (EditText) view.findViewById(R.id.email_edit);
        passwordEdit = (EditText) view.findViewById(R.id.password_edit);
        nurseEdit= (Spinner) view.findViewById(R.id.nurse_edit);
        patientsSpinner= (Spinner) view.findViewById(R.id.patientsSpinner);

        patients = Utils.getPatients(mContext);
        initNames();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(mContext,android.R.layout.simple_spinner_item,patientsNames);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> nursesDataAdapter = new ArrayAdapter<String>(mContext,android.R.layout.simple_spinner_item, nursesNames);
        nursesDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nurseEdit.setAdapter(nursesDataAdapter);
        patientsSpinner.setAdapter(dataAdapter);
        patientsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position>0){
                    Patient p = patients.get(position-1);
                    indexToEdit=position-1;
                    patientUpdate.setPatientId(p.getPatientId());
                    patientNameEdit.setText(p.getName());
                    ageEdit.setText(String.valueOf(p.getAge()));
                    bedNumberEdit.setText(String.valueOf(p.getBedNum()));
                    emailEdit.setText(p.getLogin());
                    passwordEdit.setText(p.getPassword());
                    if(p.getGender().equalsIgnoreCase("Male"))
                        genderEdit.setSelection(0);
                    else
                        genderEdit.setSelection(1);
                    nurseEdit.setSelection(nursesNames.indexOf(p.getNurse()));
                    Log.e("selected",p.toString());
                }else{
                    patientNameEdit.setText("");
                    ageEdit.setText("");
                    bedNumberEdit.setText("");
                    emailEdit.setText("");
                    passwordEdit.setText("");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                patientUpdate.setName(patientNameEdit.getText().toString());
                patientUpdate.setAge(Integer.parseInt(ageEdit.getText().toString()));
                patientUpdate.setPassword(passwordEdit.getText().toString());
                patientUpdate.setLogin(emailEdit.getText().toString());
                patientUpdate.setBedNum(Integer.valueOf(bedNumberEdit.getText().toString()));
                if(genderEdit.getSelectedItemPosition()==0)
                    patientUpdate.setGender("Male");
                else
                    patientUpdate.setGender("Female");
                patientUpdate.setNurse(nursesNames.get(nurseEdit.getSelectedItemPosition()));
                Utils.editPatient(mContext,patientUpdate);
                patients=Utils.getPatients(mContext);
                patientsNames.removeAll(patientsNames);
                initNames();
                patientsSpinner.setSelection(0);
                nurseEdit.setSelection(0);
                genderEdit.setSelection(0);
            }
        });
        return view;
    }
public void initNames(){
    patientsNames.add("Choose a name");
    for (Patient p :
            patients) {
        patientsNames.add(p.getName());
    }
}
//public int getNurseInd
}
