package com.example.gmt_006.vshnn.Activity;

import android.os.Build;
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

public class GreenHouseMainActivity extends AppCompatActivity{
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    private RecyclerView recyclerView;
    private PresenterGreenHouse presenterGreenHouse;
    LinearLayoutManager linearLayoutManager;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_house_main);

        Anhxa();
//        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
//        drawerLayout.addDrawerListener(actionBarDrawerToggle);
//        actionBarDrawerToggle.syncState();
//        actionbar();



    }

//    private void actionbar() {
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                drawerLayout.openDrawer(GravityCompat.START);
//            }
//        });
//
//    }



    private void Anhxa() {

//        toolbar = findViewById(R.id.toolbar);
//        drawerLayout = findViewById(R.id.drawerLayout);
//        navigationView = findViewById(R.id.navgationview);

        recyclerView = findViewById(R.id.recyclerview);

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        presenterGreenHouse = new PresenterGreenHouse(this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(presenterGreenHouse.getGrenHouseAdappter());
        if(presenterGreenHouse!=null){
            presenterGreenHouse.getListGreenhuose("2");
        }

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_app,menu);
//        return true;
//    }


}
