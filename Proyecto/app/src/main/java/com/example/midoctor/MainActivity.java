package com.example.midoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mLoginButton;

    public void SiguienteLog(View view){
        Intent siguiente=new Intent(this,LoginActivity.class);
        startActivity(siguiente);
    }

    public void SiguienteReg(View view){
        Intent siguiente=new Intent(this,RegisterActivity.class);
        startActivity(siguiente);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


}