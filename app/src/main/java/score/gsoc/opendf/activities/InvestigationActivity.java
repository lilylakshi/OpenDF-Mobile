package score.gsoc.opendf.activities;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import score.gsoc.opendf.R;
import score.gsoc.opendf.models.Investigation;

public class InvestigationActivity extends Activity {

    Investigation mInvestigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investigation);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        mInvestigation = getIntent().getParcelableExtra("InvestigationExtra");
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    public void loadData() {
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText(mInvestigation.getTitle());
    }
}
