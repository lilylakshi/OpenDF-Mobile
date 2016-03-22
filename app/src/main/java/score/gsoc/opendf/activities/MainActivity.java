package score.gsoc.opendf.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity {

    Drawer mDrawer;
    List<IDrawerItem> mDrawerItemsList;
    String[] mNavItemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupActionBar();
        setupNavDrawer();

        changeTitle(mNavItemsList[0]);
        changeFragment(new MainActivityFragment());
    }

    public void setupActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void setupNavDrawer() {

        Typeface customFont = Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-Regular.ttf");

        mDrawerItemsList = new ArrayList<>();

        mNavItemsList = getResources().getStringArray(R.array.navList);

        for(String navItem : mNavItemsList) {
            mDrawerItemsList.add(new PrimaryDrawerItem().withName(navItem).withTypeface(customFont)
                    .withTextColor(getResources().getColor(R.color.dark_blue_color)));
        }

        AccountHeader header = new AccountHeaderBuilder()
                .withActivity(this)
                .addProfiles(new ProfileDrawerItem()
                        .withName("Lilan Abeywickrama"))
                .withTextColor(getResources().getColor(R.color.dark_blue_color))
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
                                changeTitle(mNavItemsList[position - 1]);
                                changeFragment(new MainActivityFragment());
                                return false;

                            case 2:
                                changeTitle(mNavItemsList[position - 1]);
                                changeFragment(new InvestigatorsFragment());
                                return false;

                            default:
                                Toast.makeText(MainActivity.this, "Not implemented yet.", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                })
                .build();
    }

    public void changeTitle(String title) {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    public void changeFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.commit();
    }
}
