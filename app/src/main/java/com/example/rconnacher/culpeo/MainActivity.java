package com.example.rconnacher.culpeo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements MenuItem.OnActionExpandListener, AdapterView.OnItemClickListener {

    @InjectView(R.id.toolbar)
    Toolbar toolBar;
    @InjectView(R.id.mDrawerLayout)
    DrawerLayout mDrawerLayout;
    @InjectView(R.id.navList)
    ListView navDrawerList;
    private SharedPreferences mSharedPreferences;
    private String[] navigationOptions;
    private ActionBarDrawerToggle mDrawerToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        navigationOptions = new String[]{"Settings", "Account", "Contact Us", "Privacy Policy"};

        setSupportActionBar(toolBar);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolBar, R.string.drawerOpen, R.string.drawerClose) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {

                super.onDrawerClosed(view);
                getSupportActionBar().setTitle("Settings");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {

                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Settings");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        return false;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    class CustomPagerAdapter extends FragmentPagerAdapter {

        Context mContext;

        public CustomPagerAdapter(FragmentManager fm, Context context) {

            super(fm);
            mContext = context;
        }

        @Override
        public Fragment getItem(int position) {

            // Create fragment object
            Fragment fragment;
            if (position == 0) {
                fragment = new ScoresFragment();
            } else if (position == 1){
                fragment = new NewsFragment();
            } else {
                fragment = new MatchesFragment();
            }

            // Attach some data to the fragment
            // that we'll use to populate our fragment layouts
            Bundle args = new Bundle();
           // args.putString(DetailsFragment.EXTRA_CONTENT_ID, mContentId);

            // Set the arguments on the fragment
            // that will be fetched in the
            // DemoFragment@onCreateView
            fragment.setArguments(args);

            return fragment;
        }

        @Override
        public int getCount() {

            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            if (position == 0) {
                return "Scores";
            } else if (position == 1){
                return "News";
            } else {
                return "Matches";
            }
        }
    }
}
