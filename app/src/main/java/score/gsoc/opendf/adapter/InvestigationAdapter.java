package score.gsoc.opendf.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import score.gsoc.opendf.R;
import score.gsoc.opendf.models.Investigation;

/**
 * Created by lilan on 3/22/16.
 */
public class InvestigationAdapter extends ArrayAdapter {

    List<Investigation> items;
    Context context;

    public InvestigationAdapter(Context context, int resource, List<Investigation> items) {
        super(context, resource, items);
        this.items = items;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.item_card, null);
        }

        Investigation investigation = items.get(position);

        if (investigation != null) {
            TextView titleTextView = (TextView) convertView.findViewById(R.id.cardTitle);
            TextView bodyTextView = (TextView) convertView.findViewById(R.id.cardBody);
            TextView FooterTextView = (TextView) convertView.findViewById(R.id.cardFooter);

                titleTextView.setText(investigation.getTitle());
                bodyTextView.setText(investigation.getDescription());
                FooterTextView.setText(investigation.getDateOfCreation());
        }
        return convertView;
    }
}
