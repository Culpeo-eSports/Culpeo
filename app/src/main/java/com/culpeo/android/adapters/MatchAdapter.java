package com.culpeo.android.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.culpeo.android.R;
import com.culpeo.android.models.Match;
import com.culpeo.android.models.News;
import com.culpeo.android.viewholders.MatchViewHolder;
import com.culpeo.android.viewholders.NewsViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ross on 12/10/2015.
 */
public class MatchAdapter extends RecyclerView.Adapter<MatchViewHolder>{

    private Context mContext;
    private List<Match> mMatches;

    public MatchAdapter(Context context, ArrayList<Match> matches){
        this.mContext = context;
        this.mMatches = matches;
    }

    @Override
    public MatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View view = inflator.inflate(R.layout.match_item, parent, false);
        return new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MatchViewHolder holder, int position) {

        final Match match = mMatches.get(position);
        holder.team1.setText(match.getTeam1());
        holder.team2.setText(match.getTeam2());
        holder.team1icon.setImageResource(match.getTeam1Icon());
        holder.team2icon.setImageResource(match.getTeam2Icon());
        holder.versus.setImageResource(R.drawable.verus);
    }

    @Override
    public int getItemCount() {
        return mMatches.size();
    }

    public void add(Match match) {

        mMatches.add(match);
        notifyItemInserted(mMatches.size() - 1);
    }

    public void remove(int position) {

        mMatches.remove(position);
        notifyItemRemoved(position);
    }


}
