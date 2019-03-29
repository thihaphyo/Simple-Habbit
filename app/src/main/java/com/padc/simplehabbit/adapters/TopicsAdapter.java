package com.padc.simplehabbit.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.simplehabbit.R;
import com.padc.simplehabbit.data.vos.TopicsVO;
import com.padc.simplehabbit.views.holders.TopicsViewHolder;

public class TopicsAdapter extends BaseRecyclerAdapter<TopicsViewHolder, TopicsVO> {


    public TopicsAdapter() {
    }

    @NonNull
    @Override
    public TopicsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.view_holder_topic, viewGroup, false);

        return new TopicsViewHolder(view);
    }


}
