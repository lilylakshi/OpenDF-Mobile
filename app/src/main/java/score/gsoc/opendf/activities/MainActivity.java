package score.gsoc.opendf.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.List;

import score.gsoc.opendf.R;
import score.gsoc.opendf.fragments.InvestigatorsFragment;
import score.gsoc.opendf.fragments.MainActivityFragment;
import score.gsoc.opendf.helpers.ActionbarHelper;

public class MainActivity extends AppCompatActivity {

    Drawer mDrawer;
    List<IDrawerItem> mDrawerItemsList;
    String[] mNavItemsList;
    ActionbarHelper mActionbarHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupActionBar();
        setupNavDrawer();

        mActionbarHelper = new ActionbarHelper(this);
        mActionbarHelper.changeTitle(mNavItemsList[0]);
        changeFragment(new MainActivityFragment());
    }

    public void setupActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void setupNavDrawer() {

        Typeface customFont = Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-Semibold.ttf");

        mDrawerItemsList = new ArrayList<>();

        mNavItemsList = getResources().getStringArray(R.array.navList);

        for(String navItem : mNavItemsList) {
            mDrawerItemsList.add(new PrimaryDrawerItem().withName(navItem).withTypeface(customFont)
                    .withTextColor(getResources().getColor(R.color.colorPrimaryDark)));
        }

        AccountHeader header = new AccountHeaderBuilder()
                .withActivity(this)
                .addProfiles(new ProfileDrawerItem()
                        .withName("Lilan Abeywickrama"))
                .withTextColor(getResources().getColor(R.color.colorPrimaryDark))
                .build();

        mDrawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar((Toolbar) findViewById(R.id.toolbar))
                .withAccountHeader(header)
                .withDrawerWidthDp(getResources().getInteger(R.integer.nav_drawer_width))
                .withDrawerItems(mDrawerItemsList)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch (position) {
                            case 1:
                                mActionbarHelper.changeTitle(mNavItemsList[position - 1]);
                                changeFragment(new MainActivityFragment());
                                return false;

                            case 2:
                                mActionbarHelper.changeTitle(mNavItemsList[position - 1]);
                                changeFragment(new InvestigatorsFragment());
                                return false;

                            default:
                                //Toast.makeText(MainActivity.this, "Not implemented yet.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this, UtilitiesActivity.class));
                                break;
                        }
                        return true;
                    }
                })
                .build();
    }

    public void changeFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.commit();
    }
}
