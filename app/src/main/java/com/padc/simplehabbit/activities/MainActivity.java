package com.padc.simplehabbit.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.padc.simplehabbit.R;
import com.padc.simplehabbit.data.vos.ProgramsVO;
import com.padc.simplehabbit.delegates.ProgramDelegate;
import com.padc.simplehabbit.fragments.MeditateFragment;
import com.padc.simplehabbit.fragments.UserProfileFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements ProgramDelegate {


    @BindView(R.id.bottom_navigation)
    BottomNavigationView mBottomNavigation;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tl)
    TabLayout tabLayout;

    private Fragment mFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.action_meditate:
                        toolbar.setTitle("Meditate");
                        tabLayout.setVisibility(View.VISIBLE);
                        mFragment = MeditateFragment.newFragemnt();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fl_container, mFragment)
                                .commit();
                        break;
                    case R.id.action_me:
                        toolbar.setTitle("Me");
                        tabLayout.setVisibility(View.GONE);
                        mFragment = UserProfileFragment.newFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fl_container, mFragment)
                                .commit();
                        break;
                    case R.id.action_more:
                        toolbar.setTitle("Meditate");
                        tabLayout.setVisibility(View.VISIBLE);
                        mFragment = MeditateFragment.newFragemnt();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fl_container, mFragment)
                                .commit();
                        break;
                }
                return true;
            }
        });

        toolbar.setTitle("Meditate");
        tabLayout.setVisibility(View.VISIBLE);
        mFragment = MeditateFragment.newFragemnt();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, mFragment)
                .commit();


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

    public static Intent newIntent(Context context) {

        return new Intent(context, MainActivity.class);

    }
}
