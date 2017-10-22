package justsmart.esprit.com.zaiedhospital.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import justsmart.esprit.com.zaiedhospital.R;
import justsmart.esprit.com.zaiedhospital.adapters.MoodsListAdapter;
import justsmart.esprit.com.zaiedhospital.adapters.MoodsListDataModel;


public class DoctorHistoryFragment extends Fragment {
   public static ArrayList<MoodsListDataModel> dataModels= new ArrayList<>();
    static Activity mActivity;
    public DoctorHistoryFragment() {
        // Required empty public constructor
    }


    public static DoctorHistoryFragment newInstance() {
        DoctorHistoryFragment fragment = new DoctorHistoryFragment();
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
        View view = inflater.inflate(R.layout.fragment_check_history, container, false);

        return view;

    }

}
