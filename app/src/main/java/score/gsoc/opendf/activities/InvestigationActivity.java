package score.gsoc.opendf.activities;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import score.gsoc.opendf.R;
import score.gsoc.opendf.helpers.ActionbarHelper;
import score.gsoc.opendf.models.Investigation;

public class InvestigationActivity extends AppCompatActivity {

    ActionbarHelper mActionbarHelper;
    Investigation mInvestigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investigation);

        mActionbarHelper = new ActionbarHelper(this);
        mActionbarHelper.setupActionBar();
        mActionbarHelper.enableBackButton();

        mInvestigation = getIntent().getParcelableExtra("InvestigationExtra");

        loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void loadData() {
        mActionbarHelper.changeTitle(mInvestigation.getTitle());

        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText(mInvestigation.getDescription());
    }
}
