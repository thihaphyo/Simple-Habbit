package com.padc.simplehabbit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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
import com.padc.simplehabbit.data.vos.ProgramsVO;
import com.padc.simplehabbit.data.vos.TopicsVO;
import com.padc.simplehabbit.delegates.ProgramDelegate;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ProgramDelegate {

    private RecyclerView rvMain;
    private RecyclerView rvTopics;
    private CatProgsAdapter adapter;
    private TopicsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        rvTopics = findViewById(R.id.rv_topics);
        setSupportActionBar(toolbar);


        rvMain = findViewById(R.id.rv_main);
        rvMain.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        adapter = new CatProgsAdapter(this);
        rvMain.setAdapter(adapter);

        rvTopics.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new TopicsAdapter();
        rvTopics.setAdapter(mAdapter);

        final TextView tvStarter = findViewById(R.id.tv_starter);
        final TextView tvPeriod = findViewById(R.id.tv_time);
        final Button btnStart = findViewById(R.id.btn_start);


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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClickProgram(ProgramsVO programsVO) {

        Intent intent = new Intent(MainActivity.this, ProgramsDetailsActivity.class);
        intent.putExtra("programID", programsVO.getprogramID());
        startActivity(intent);
    }
}
