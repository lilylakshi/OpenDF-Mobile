package score.gsoc.opendf.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import score.gsoc.opendf.R;
import score.gsoc.opendf.activities.InvestigationActivity;
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
        final List<Investigation> investigationList = new ArrayList<>();

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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getContext(), InvestigationActivity.class);
                i.putExtra("InvestigationExtra", investigationList.get(position));
                startActivity(i);
            }
        });
    }
}
