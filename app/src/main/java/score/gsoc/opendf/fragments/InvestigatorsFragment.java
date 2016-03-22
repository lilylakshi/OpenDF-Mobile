package score.gsoc.opendf.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import score.gsoc.opendf.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InvestigatorsFragment extends Fragment {


    public InvestigatorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_investigators, container, false);
    }

}
