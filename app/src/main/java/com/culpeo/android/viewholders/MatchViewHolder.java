package com.culpeo.android.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.culpeo.android.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Ross on 12/10/2015.
 */
public class MatchViewHolder  extends RecyclerView.ViewHolder {


    private static final String TAG = "MatchViewHolder";

    @InjectView(R.id.team1)
    public TextView team1;
    @InjectView(R.id.team2)
    public TextView team2;
    @InjectView(R.id.team1icon)
    public ImageView team1icon;
    @InjectView(R.id.team2icon)
    public ImageView team2icon;
    @InjectView(R.id.versus)
    public ImageView versus;


    public MatchViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
    }
}
