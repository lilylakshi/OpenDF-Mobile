package score.gsoc.opendf.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import score.gsoc.opendf.R;
import score.gsoc.opendf.helpers.ActionbarHelper;

public class UtilitiesActivity extends AppCompatActivity {

    ActionbarHelper mActionbarHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilities);

        mActionbarHelper = new ActionbarHelper(this);
        mActionbarHelper.setupActionBar();
        mActionbarHelper.enableBackButton();
    }
}
