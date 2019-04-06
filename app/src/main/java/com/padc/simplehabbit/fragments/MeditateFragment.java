package com.padc.simplehabbit.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.padc.simplehabbit.R;
import com.padc.simplehabbit.adapters.CatProgsAdapter;
import com.padc.simplehabbit.adapters.TopicsAdapter;
import com.padc.simplehabbit.data.CatProgsModel;
import com.padc.simplehabbit.data.CatProgsModelImpl;
import com.padc.simplehabbit.data.CurrentProgramModel;
import com.padc.simplehabbit.data.CurrentProgramModelImpl;
import com.padc.simplehabbit.data.TopicsModel;
import com.padc.simplehabbit.data.TopicsModelImpl;
import com.padc.simplehabbit.data.vos.CategoryProgramsVO;
import com.padc.simplehabbit.data.vos.CurrentProgramVO;
import com.padc.simplehabbit.data.vos.TopicsVO;
import com.padc.simplehabbit.delegates.ProgramDelegate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MeditateFragment extends BaseFragment {

    @BindView(R.id.rv_main)
    RecyclerView rvMain;
    @BindView(R.id.rv_topics)
    RecyclerView rvTopics;
    @BindView(R.id.tv_starter)
    TextView tvStarter;
    @BindView(R.id.tv_time)
    TextView tvPeriod;
    @BindView(R.id.btn_start)
    Button btnStart;

    private CatProgsAdapter adapter;
    private TopicsAdapter mAdapter;

    private ProgramDelegate delegate;

    public static MeditateFragment newFragemnt() {

        return new MeditateFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater
            , @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_meditate, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ButterKnife.bind(this, view);

        rvMain.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        adapter = new CatProgsAdapter(delegate);
        rvMain.setAdapter(adapter);

        rvTopics.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new TopicsAdapter();
        rvTopics.setAdapter(mAdapter);


        CurrentProgramVO programVO = CurrentProgramModelImpl.getObjInstance().getCurrentProgram("b002c7e1a528b7cb460933fc2875e916", new CurrentProgramModel.CurrentProgramDelegate() {
            @Override
            public void onSuccess(CurrentProgramVO currentProgram) {

                tvStarter.setText(currentProgram.getTitle());
                tvPeriod.setText(currentProgram.getaverageLength().get(0) + " mins");
                btnStart.setText(currentProgram.getCurrentPeriod());
            }

            @Override
            public void onFail(String errorMessge) {

            }
        });

        if (programVO != null) {

            tvStarter.setText(programVO.getTitle());
            tvPeriod.setText(programVO.getaverageLength().get(0) + " mins");
            btnStart.setText(programVO.getCurrentPeriod());
        }


        List<CategoryProgramsVO> list = CatProgsModelImpl.getObjInstance().getCatProgs("b002c7e1a528b7cb460933fc2875e916", new CatProgsModel.CatProgsDelegate() {
            @Override
            public void onSuccess(List<CategoryProgramsVO> categoryProgramsVOS) {

                adapter.setNewData(categoryProgramsVOS);

            }

            @Override
            public void onFail(String error) {

            }
        });

        if (!list.isEmpty()) {

            adapter.setNewData(list);

        }

        List<TopicsVO> topics = TopicsModelImpl.getObjInstance().getTopics("b002c7e1a528b7cb460933fc2875e916", new TopicsModel.TopicsDeleagte() {

            @Override
            public void onSuccess(List<TopicsVO> topics) {

                mAdapter.setNewData(topics);

            }

            @Override
            public void onFail(String error) {

            }
        });

        if (!topics.isEmpty()) {

            mAdapter.setNewData(topics);
        }
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        delegate = (ProgramDelegate) context;
    }
}
