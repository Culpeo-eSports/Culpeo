package com.culpeo.android;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by rconnacher on 12/9/15.
 */


public class NewsViewHolder extends RecyclerView.ViewHolder  {

    private static final String TAG = "NewsViewHolder";

    @InjectView(R.id.titleText)
    TextView title;
    @InjectView(R.id.authorText)
    TextView author;
    @InjectView(R.id.descriptionText)
    TextView description;

    public NewsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
    }


}
