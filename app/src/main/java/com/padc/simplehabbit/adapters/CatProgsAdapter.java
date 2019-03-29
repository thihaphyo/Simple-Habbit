package com.padc.simplehabbit.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.simplehabbit.R;
import com.padc.simplehabbit.data.vos.CategoryProgramsVO;
import com.padc.simplehabbit.delegates.ProgramDelegate;
import com.padc.simplehabbit.views.holders.CatProgsViewHolder;

public class CatProgsAdapter extends BaseRecyclerAdapter<CatProgsViewHolder, CategoryProgramsVO> {

    private ProgramDelegate mDelegate;

    public CatProgsAdapter(ProgramDelegate delegate) {

        mDelegate = delegate;

    }


    @NonNull
    @Override
    public CatProgsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.view_holder_cat_progs, viewGroup, false);

        return new CatProgsViewHolder(view, mDelegate);
    }


}
