package com.padc.simplehabbit.views.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.padc.simplehabbit.R;
import com.padc.simplehabbit.data.vos.SessionVO;

public class SessionsViewHolder extends BaseViewHolder<SessionVO> {


    public SessionsViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(SessionVO data) {

        TextView sessionID = itemView.findViewById(R.id.tv_session_id);

        TextView tvSessionName = itemView.findViewById(R.id.tv_session_name);

        TextView tvDuration = itemView.findViewById(R.id.tv_session_duration);

        sessionID.setText(data.getSessionId());
        tvSessionName.setText(data.getTitle());
        tvDuration.setText((data.getLengthInSeconds() / 60) + " mins");
    }


}
