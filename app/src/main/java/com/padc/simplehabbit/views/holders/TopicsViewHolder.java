package com.padc.simplehabbit.views.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.padc.simplehabbit.R;
import com.padc.simplehabbit.data.vos.TopicsVO;

public class TopicsViewHolder extends BaseViewHolder<TopicsVO> {

    public TopicsViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(TopicsVO data) {

        TextView tvTitle = itemView.findViewById(R.id.title);
        TextView tvDesc = itemView.findViewById(R.id.desc);

        tvTitle.setText(data.getTopicName());
        tvDesc.setText(data.getTopicDesc());
    }
}
