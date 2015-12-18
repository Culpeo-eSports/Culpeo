package com.culpeo.android;


import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.culpeo.android.fragments.AccountFragment;
import com.culpeo.android.fragments.ContactUsFragment;
import com.culpeo.android.fragments.MatchesFragment;
import com.culpeo.android.fragments.NewsFragment;
import com.culpeo.android.fragments.PrivacyPolicyFragment;
import com.culpeo.android.fragments.ScoresFragment;
import com.culpeo.android.fragments.SettingsFragment;
import com.culpeo.android.fragments.ToolbarFragment;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements MenuItem.OnActionExpandListener, AdapterView.OnItemClickListener {

    private static final String TAG = "MainActivity";

    @InjectView(R.id.bottomToolbar)
    FrameLayout toolbarFragment;
    @InjectView(R.id.toolbar)
    Toolbar toolBar;
    @InjectView(R.id.mDrawerLayout)
    DrawerLayout mDrawerLayout;
    @InjectView(R.id.manageFragements)
    LinearLayout manageFragments;
    @InjectView(R.id.navList)
    ListView navDrawerList;
    @InjectView(R.id.pager)
    ViewPager mViewPager;
    private SharedPreferences mSharedPreferences;
    private String[] navigationOptions;
    private ActionBarDrawerToggle mDrawerToggle;
    private CustomPagerAdapter mCustomPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        navigationOptions = new String[]{"News","Settings", "Account", "Contact Us", "Privacy Policy"};

        mCustomPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(mCustomPagerAdapter);


        setSupportActionBar(toolBar);
        initDrawer();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerToggle.syncState();

        ToolbarFragment frag = new ToolbarFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.bottomToolbar,frag).commit();

    }

    private void initDrawer() {

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolBar, R.string.drawerOpen, R.string.drawerClose) {

            @Override
            public void onDrawerClosed(View drawerView) {

                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
                manageFragments.bringToFront();
                mDrawerLayout.invalidate();

            }

            @Override
            public void onDrawerOpened(View drawerView) {

                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
                mDrawerLayout.bringToFront();
                mDrawerLayout.invalidate();
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        navDrawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navigationOptions));
        navDrawerList.setOnItemClickListener(this);
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

        Log.d(TAG, "Click request to: "+ navigationOptions[position]);
        selectItem(position);
    }

    public void selectItem(int i) {

        Fragment frag;
        if (i == 0) { //news
            //DEFAULT
        } else if (i == 1) { //settings
            frag = SettingsFragment.newInstance("","");
        } else if (i == 2) { //account
            frag = AccountFragment.newInstance("","");
        } else if (i == 3) { //contact us
            frag = ContactUsFragment.newInstance("", "");
        } else if (i == 4) { //privacy policy
            frag = PrivacyPolicyFragment.newInstance("","");
        }

        if(i != 0) {
            //replace fragment
        }

        navDrawerList.setItemChecked(i, true);
        mDrawerLayout.closeDrawer(navDrawerList);
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
            } else if (position == 1) {
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
            } else if (position == 1) {
                return "News";
            } else {
                return "Matches";
            }
        }
    }
}
