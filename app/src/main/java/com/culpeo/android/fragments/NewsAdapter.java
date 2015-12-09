package com.culpeo.android.fragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.culpeo.android.News;
import com.culpeo.android.NewsViewHolder;
import com.culpeo.android.R;

import java.util.List;

/**
 * Created by Ross on 12/9/2015.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder>{

    private static final String TAG = "NewsViewAdapter";

    private Context mContext;
    private List<News> mNews;

    NewsAdapter(Context context, List<News> news){
        this.mContext = context;
        this.mNews = news;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View view = inflator.inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {

        final News news = mNews.get(position);
        holder.title.setText(news.getTitle());
        holder.author.setText(news.getAuthur());
        holder.description.setText(news.getDescription());
        holder.icon.setImageResource(news.getImage());


    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }

    public void add(News news) {

        mNews.add(news);
        notifyItemInserted(mNews.size() - 1);
    }

    public void remove(int position) {

        mNews.remove(position);
        notifyItemRemoved(position);
    }
}
