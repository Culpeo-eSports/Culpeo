package com.culpeo.android.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.culpeo.android.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by rconnacher on 12/9/15.
 */


public class NewsViewHolder extends RecyclerView.ViewHolder  {

    private static final String TAG = "NewsViewHolder";

    @InjectView(R.id.titleText)
    public TextView title;
    @InjectView(R.id.authorText)
    public TextView author;
    @InjectView(R.id.descriptionText)
    public TextView description;
    @InjectView(R.id.icon)
    public ImageView icon;

    public NewsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
    }


}
