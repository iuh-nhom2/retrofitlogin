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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.gmt_006.vshnn.R;

public class MyProFileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    NavigationView navigationview;

    private ActionBarDrawerToggle mTonggle;
    private EditText edtname,edtfullname,edtemail,edtnamfull,edtemailuser,edtwebsite,edtAddress,edtPhone;
    TextView txtdktk;
    private String us="";
    private Button btneditfile;
    String id="";
    String password ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pro_file);
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_app,menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    private void Anhxa() {
        toolbar =  findViewById(R.id.toolbarmanhinhchinh);
        drawerLayout =  findViewById(R.id.drawerLayout);
        navigationview  = findViewById(R.id.navigationview);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(mTonggle.onOptionsItemSelected(item)){
            return true;
        }
        switch (item.getItemId()){
            case R.id.itemdieukhien:
                Toast.makeText(MyProFileActivity.this,"Go to điều khiển",Toast.LENGTH_LONG).show();
                break;
            case R.id.itemInfor:
                Toast.makeText(MyProFileActivity.this,"Go to infor",Toast.LENGTH_LONG).show();
                break;
            case  R.id.itemnhakinh:
                Intent intent = new Intent(MyProFileActivity.this,GreenHouseMainActivity.class);
                startActivity(intent);
                break;
        }
        return false;
    }
}
