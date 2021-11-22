package com.example.midoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VACCINE extends AppCompatActivity {

    Button btnvacc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine);
        btnvacc=(Button) findViewById(R.id.btncitavacuna);
        btnvacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent addvacm=new Intent(getApplicationContext(),AdquirirVacuna.class);
                startActivity(addvacm);
            }
        });
    }
}