package com.example.gmt_006.vshnn.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gmt_006.vshnn.Presenter.PresenterLogin;
import com.example.gmt_006.vshnn.R;

public class MainActivity extends AppCompatActivity  {
    EditText email,password;
    TextView registion;
    Button login;
    String em,pass;
    private PresenterLogin presenterLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();


        presenterLogin= new PresenterLogin(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                em = email.getText().toString();
                pass = password.getText().toString();
                if(em.length()<=0 || pass.length()<=0){
                    Toast.makeText(MainActivity.this,"Chưa nhập đủ email, password",Toast.LENGTH_LONG).show();


                }else{
                    presenterLogin.getLogin(em,pass);

                }

            }
        });

        registion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"I am Registior", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void Anhxa() {
        email = findViewById(R.id.txttaikhoan);
        password = findViewById(R.id.edtpassword);
        login = findViewById(R.id.btnlogin);
        registion = findViewById(R.id.txtRegister);
    }



}
