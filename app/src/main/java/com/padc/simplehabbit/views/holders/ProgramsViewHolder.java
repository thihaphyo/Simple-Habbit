package com.padc.simplehabbit.views.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.padc.simplehabbit.R;
import com.padc.simplehabbit.data.vos.ProgramsVO;
import com.padc.simplehabbit.delegates.ProgramDelegate;

public class ProgramsViewHolder extends BaseViewHolder<ProgramsVO> {

    private ProgramDelegate mDelegate;

    private ProgramsVO mData;

    public ProgramsViewHolder(@NonNull View itemView, ProgramDelegate delegate) {
        super(itemView);

        this.mDelegate = delegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDelegate.onClickProgram(mData);
            }
        });
    }

    @Override
    public void bindData(ProgramsVO data) {

        mData = data;

        TextView tvProgram = itemView.findViewById(R.id.tv_program);
        TextView tvTime = itemView.findViewById(R.id.tv_time);

        tvProgram.setText(data.getTitle());
        tvTime.setText(data.getaverageLength().get(0) + " mins");

    }
}
