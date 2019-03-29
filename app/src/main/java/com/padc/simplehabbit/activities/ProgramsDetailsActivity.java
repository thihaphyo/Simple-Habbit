package com.padc.simplehabbit.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.simplehabbit.R;
import com.padc.simplehabbit.adapters.SessionsAdapter;
import com.padc.simplehabbit.data.CatProgsModelImpl;
import com.padc.simplehabbit.data.vos.ProgramsVO;

public class ProgramsDetailsActivity extends AppCompatActivity {

    private RecyclerView rvSession;
    private SessionsAdapter mAdapter;
    private Toolbar toolbar;
    private String programID;
    private ProgramsVO program;
    private ImageView ivBackDrop;
    private TextView tvUserName;
    private TextView tvDesc;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_details);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvDesc = findViewById(R.id.tv_desc);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collaspe);

        programID = getIntent().getStringExtra("programID");

        program = CatProgsModelImpl.getObjInstance().getProgramByID(programID);

        collapsingToolbarLayout.setTitle(program.getTitle());

        tvDesc.setText(program.getDescription());


        rvSession = findViewById(R.id.rv_sessions);
        mAdapter = new SessionsAdapter();
        rvSession.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rvSession.setAdapter(mAdapter);
        mAdapter.setNewData(program.getSession());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
