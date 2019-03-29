package com.padc.simplehabbit.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.simplehabbit.R;
import com.padc.simplehabbit.data.vos.SessionVO;
import com.padc.simplehabbit.views.holders.SessionsViewHolder;

public class SessionsAdapter extends BaseRecyclerAdapter<SessionsViewHolder, SessionVO> {
    @NonNull
    @Override
    public SessionsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.view_holder_session, viewGroup, false);
        return new SessionsViewHolder(view);
    }


}
