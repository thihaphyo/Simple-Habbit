package com.padc.simplehabbit.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;


import com.padc.simplehabbit.views.holders.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<T extends BaseViewHolder<W>, W> extends RecyclerView.Adapter<T> {

    private List<W> mDataList;

    public BaseRecyclerAdapter() {

        mDataList = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void setNewData(List<W> newData) {
        mDataList = newData;
        notifyDataSetChanged();
    }

    public void appendNewData(List<W> newData) {
        mDataList.addAll(newData);
        notifyDataSetChanged();
    }

    public W getItemAt(int position) {
        if (position < mDataList.size() - 1)
            return mDataList.get(position);

        return null;
    }

    public List<W> getItems() {
        if (mDataList == null)
            return new ArrayList<>();

        return mDataList;
    }

    public void removeData(W data) {
        mDataList.remove(data);
        notifyDataSetChanged();
    }

    public void addNewData(W data) {
        mDataList.add(data);
        notifyDataSetChanged();
    }

    public void clearData() {
        mDataList = new ArrayList<>();
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull T holder, int position) {

        holder.bindData(mDataList.get(position));
    }
}
