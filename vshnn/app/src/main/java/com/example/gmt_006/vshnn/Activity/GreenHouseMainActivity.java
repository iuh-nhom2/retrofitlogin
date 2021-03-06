package com.example.gmt_006.vshnn.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.gmt_006.vshnn.Presenter.PresenterGreenHouse;
import com.example.gmt_006.vshnn.R;
import com.example.gmt_006.vshnn.Server.GetGreenHuoseIML;
import com.example.gmt_006.vshnn.Server.LoginClientIML;


public class GreenHouseMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    NavigationView navigationview;

    private ActionBarDrawerToggle mTonggle;
    private RecyclerView recyclerView;
    private PresenterGreenHouse presenterGreenHouse;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_house_main);
        Anhxa();

        mTonggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(mTonggle);
        mTonggle.syncState();
        Actionbar();
        navigationview.setNavigationItemSelectedListener(this);


    }



    private void Actionbar() {
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }


    private void Anhxa() {

        toolbar =  findViewById(R.id.toolbarmanhinhchinh);
        drawerLayout =  findViewById(R.id.drawerLayout);
        navigationview  = findViewById(R.id.navigationview);


        recyclerView = findViewById(R.id.recyclerview);
//
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        presenterGreenHouse = new PresenterGreenHouse(this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(presenterGreenHouse.getGrenHouseAdappter());
        if(presenterGreenHouse!=null){
            presenterGreenHouse.getListGreenhuose("2");
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(mTonggle.onOptionsItemSelected(item)){
            return true;
        }
        switch (item.getItemId()){
            case R.id.itemdieukhien:
                Toast.makeText(GreenHouseMainActivity.this,"Go to điều khiển",Toast.LENGTH_LONG).show();
                break;
            case R.id.itemInfor:
                Toast.makeText(GreenHouseMainActivity.this,"Go to infor",Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(GreenHouseMainActivity.this,MyProFileActivity.class);
                startActivity(intent1);
                break;
            case  R.id.itemnhakinh:
                Intent intent = new Intent(GreenHouseMainActivity.this,GreenHouseMainActivity.class);
                startActivity(intent);
                break;
        }
        return false;
    }



}
