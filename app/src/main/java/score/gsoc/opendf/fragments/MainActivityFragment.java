package score.gsoc.opendf.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import score.gsoc.opendf.R;
import score.gsoc.opendf.adapter.InvestigationAdapter;
import score.gsoc.opendf.models.Investigation;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    public void loadData() {
        List<Investigation> investigationList = new ArrayList<>();

        Investigation i1 = new Investigation();
        i1.setTitle(getResources().getString(R.string.sample_card_header));
        i1.setDescription(getResources().getString(R.string.sample_card_body));
        i1.setDateOfCreation(getResources().getString(R.string.sample_card_footer));
        investigationList.add(i1);

        Investigation i2 = new Investigation();
        i2.setTitle(getResources().getString(R.string.sample_card_header2));
        i2.setDescription(getResources().getString(R.string.sample_card_body2));
        i2.setDateOfCreation(getResources().getString(R.string.sample_card_footer2));
        investigationList.add(i2);

        InvestigationAdapter investigationAdapter = new InvestigationAdapter(getActivity(), R.layout.item_card, investigationList);
        ListView listView = (ListView) getActivity().findViewById(R.id.investigationListView);
        listView.setAdapter(investigationAdapter);
    }
}
