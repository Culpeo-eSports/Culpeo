package com.culpeo.android.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.culpeo.android.R;
import com.culpeo.android.adapters.MatchAdapter;
import com.culpeo.android.adapters.NewsAdapter;
import com.culpeo.android.models.Match;
import com.culpeo.android.models.News;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link MatchesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MatchesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String TAG = "MatchesFragment";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private GridLayoutManager mLayoutManager;
    private MatchAdapter mMatchAdapter;
    @InjectView(R.id.gridview3)
    RecyclerView mView;

    //private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MatchesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MatchesFragment newInstance(String param1, String param2) {
        MatchesFragment fragment = new MatchesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MatchesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_matches, container, false);
        ButterKnife.inject(this, view);
        mLayoutManager = new GridLayoutManager(getActivity(), 1);
        mView.setLayoutManager(mLayoutManager);

        mMatchAdapter = new MatchAdapter(getActivity(), new ArrayList<Match>());
        mMatchAdapter.add(new Match("TSM", "CLG", R.drawable.tsm, R.drawable.hearthstone, Calendar.getInstance().getTime()));
       // mMatchAdapter.add(new Match("Test TitleHS", "test authur", "test description", "testText",R.drawable.hearthstone));
       // mMatchAdapter.add(new Match("Test TitleSC", "test authur", "test description", "testText",R.drawable.starcraft));
       // mMatchAdapter.add(new Match("Test Title", "test authur", "test description", "testText", R.drawable.lol));
        mView.setAdapter(mMatchAdapter);

        return view;
    }
}
