package com.culpeo.android.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.culpeo.android.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ToolbarFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private static final String TAG = "ToolbarFragment";

    @InjectView(R.id.toolbarFragment)
    LinearLayout toolbar;
    @InjectView(R.id.homeButton)
    ImageButton home;
    @InjectView(R.id.favoritesButton)
    ImageButton favorites;
    @InjectView(R.id.gamesButton)
    ImageButton games;
    @InjectView(R.id.watchButton)
    ImageButton watch;

    public ToolbarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ToolbarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ToolbarFragment newInstance(String param1, String param2) {
        ToolbarFragment fragment = new ToolbarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        Log.d(TAG, "newInstance");
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Log.d(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_toolbar, container, false);
        view.bringToFront();
        ButterKnife.inject(this, view);
        Log.d(TAG,"onCreateView");
        home.setOnClickListener(this);
        favorites.setOnClickListener(this);
        games.setOnClickListener(this);
        watch.setOnClickListener(this);
        return view;



    }

    @Override
    public void onClick(View v) {
        if(v.getId()==home.getId()){
            Log.d(TAG, "home");
            home.setColorFilter(Color.argb(255, 255, 255, 255)); // White Tint
            favorites.clearColorFilter();
            games.clearColorFilter();
            watch.clearColorFilter();
        } else if (v.getId()==favorites.getId()) {
            Log.d(TAG, "favorites");
            favorites.setColorFilter(Color.argb(255, 255, 255, 255)); // White Tint
            home.clearColorFilter();
            games.clearColorFilter();
            watch.clearColorFilter();
        } else if (v.getId()==games.getId()) {
            Log.d(TAG, "games");
            games.setColorFilter(Color.argb(255, 255, 255, 255)); // White Tint
            home.clearColorFilter();
            favorites.clearColorFilter();
            watch.clearColorFilter();
        } else if (v.getId()==watch.getId()) {
            Log.d(TAG, "watch");
            watch.setColorFilter(Color.argb(255, 255, 255, 255)); // White Tint
            home.clearColorFilter();
            favorites.clearColorFilter();
            games.clearColorFilter();
        }
    }
}
