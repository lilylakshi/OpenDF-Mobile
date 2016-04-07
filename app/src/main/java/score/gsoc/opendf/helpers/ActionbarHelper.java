package score.gsoc.opendf.helpers;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import score.gsoc.opendf.R;

/**
 * Created by lilan on 4/7/16.
 */
public class ActionbarHelper {

    AppCompatActivity mActivity;

    public ActionbarHelper(AppCompatActivity activity) {
        mActivity = activity;
    }

    public void setupActionBar() {
        Toolbar toolbar = (Toolbar) mActivity.findViewById(R.id.toolbar);
        mActivity.setSupportActionBar(toolbar);
    }

    public void changeTitle(String title) {
        if(mActivity.getSupportActionBar() != null) {
            mActivity.getSupportActionBar().setTitle(title);
        }
    }

    public void enableBackButton() {
        if(mActivity.getSupportActionBar() != null) {
            mActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
