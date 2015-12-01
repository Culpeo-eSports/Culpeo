package com.example.rconnacher.culpeo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
