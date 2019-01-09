package com.example.enes.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;

import java.util.LinkedList;

public class LessonListAdapter extends RecyclerView.Adapter<LessonListAdapter.LessonViewHolder> {

    private final LinkedList<String> mLessonList;
    private LayoutInflater mInflater;

    public LessonListAdapter(Context context, LinkedList<String> lessonList){
        mInflater = LayoutInflater.from(context);
        this.mLessonList = lessonList;
    }

    @NonNull
    @Override
    public LessonListAdapter.LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mItemView = mInflater.inflate(R.layout.lessonlist_item, parent, false);
        return new LessonViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonListAdapter.LessonViewHolder holder, int position) {
        String mCurrent = mLessonList.get(position);
        holder.lessonitemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mLessonList.size();
    }

    class LessonViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView lessonitemView;
        final LessonListAdapter mAdapter;

        public LessonViewHolder(View itemView, LessonListAdapter adapter){
            super(itemView);
            lessonitemView = (TextView) itemView.findViewById(R.id.lesson);
            this.mAdapter=adapter;
        itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            String element =mLessonList.get(mPosition);
            mLessonList.set(mPosition,element);
            mAdapter.notifyDataSetChanged();
        }
    }
}
