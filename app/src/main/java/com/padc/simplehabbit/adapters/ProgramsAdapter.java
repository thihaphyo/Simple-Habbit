package com.padc.simplehabbit.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.simplehabbit.R;
import com.padc.simplehabbit.data.vos.ProgramsVO;
import com.padc.simplehabbit.delegates.ProgramDelegate;
import com.padc.simplehabbit.views.holders.ProgramsViewHolder;

public class ProgramsAdapter extends BaseRecyclerAdapter<ProgramsViewHolder, ProgramsVO> {

    private ProgramDelegate mDelegate;

    public ProgramsAdapter(ProgramDelegate delegate) {

        mDelegate = delegate;
    }

    @NonNull
    @Override
    public ProgramsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.view_holder_progs, viewGroup, false);

        return new ProgramsViewHolder(view, mDelegate);
    }

}
