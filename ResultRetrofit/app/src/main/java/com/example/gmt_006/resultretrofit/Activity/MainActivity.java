package com.example.gmt_006.resultretrofit.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gmt_006.resultretrofit.Presenter.presenterLogin;
import com.example.gmt_006.resultretrofit.R;

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    Button login;
    TextView dangky;
    presenterLogin plogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                plogin = new presenterLogin(this);
////                plogin.getforlogin(email.getText().toString(),password.getText().toString());
////                Toast.makeText(MainActivity.this,"hello",Toast.LENGTH_LONG).show();
//            }
//        });
    }

    private void Anhxa() {
        email =  findViewById(R.id.edtemail);
        password = findViewById(R.id.edtemail);
        login = (Button) findViewById(R.id.btnlogin);
        dangky = findViewById(R.id.txtRegistin);
        plogin= new presenterLogin(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    plogin.getforlogin(email.getText().toString(),password.getText().toString());
            }
        });
    }
}
