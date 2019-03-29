package com.padc.simplehabbit.views.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.padc.simplehabbit.R;
import com.padc.simplehabbit.adapters.ProgramsAdapter;
import com.padc.simplehabbit.data.vos.CategoryProgramsVO;
import com.padc.simplehabbit.delegates.ProgramDelegate;

public class CatProgsViewHolder extends BaseViewHolder<CategoryProgramsVO> {


    private ProgramDelegate mDelegate;

    public CatProgsViewHolder(@NonNull View itemView, ProgramDelegate delegate) {
        super(itemView);
        mDelegate = delegate;
    }

    @Override
    public void bindData(CategoryProgramsVO data) {

        RecyclerView rvPrograms = itemView.findViewById(R.id.rv_progs);
        rvPrograms.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        ProgramsAdapter adapter = new ProgramsAdapter(mDelegate);
        rvPrograms.setAdapter(adapter);

        adapter.setNewData(data.getPrograms());

        TextView tvCat = itemView.findViewById(R.id.tv_cat);

        tvCat.setText(data.getTitle());
    }
}
