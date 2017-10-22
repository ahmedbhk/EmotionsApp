package justsmart.esprit.com.zaiedhospital.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import justsmart.esprit.com.zaiedhospital.MainPatientActivity;
import justsmart.esprit.com.zaiedhospital.R;
import justsmart.esprit.com.zaiedhospital.adapters.MoodsListAdapter;
import justsmart.esprit.com.zaiedhospital.adapters.MoodsListDataModel;
import justsmart.esprit.com.zaiedhospital.adapters.Utils;
import justsmart.esprit.com.zaiedhospital.entities.Mood;


public class PatientHistoryFragment extends Fragment {
   public static ArrayList<MoodsListDataModel> dataModels= new ArrayList<>();
    static Activity mActivity;
    public static MoodsListAdapter adapter;
    public static View itemview;
    public PatientHistoryFragment() {
        // Required empty public constructor
    }


    public static PatientHistoryFragment newInstance() {
        PatientHistoryFragment fragment = new PatientHistoryFragment();
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
        View view = inflater.inflate(R.layout.fragment_patient_history, container, false);
         itemview = inflater.inflate(R.layout.moods_list_item, container, false);

        LinearLayout l;

        ArrayList<Mood> moods=  Utils.getMoods(getContext());
        Log.e("lista",moods.toString());
        dataModels.removeAll(dataModels);
        for (Mood m :
                moods) {
            l = (LinearLayout) itemview.findViewById(R.id.moodItem);

            dataModels.add(new MoodsListDataModel(m.getName(),m.getLevel(),m.getDate(),m.getName(),m.getExplaination(),l));

        }
        ListView lvMoodsList = (ListView) view.findViewById(R.id.MoodsList);

        adapter = new MoodsListAdapter(dataModels, getContext());
        lvMoodsList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;

    }

}
