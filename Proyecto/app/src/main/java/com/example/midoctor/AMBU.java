package com.example.midoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AMBU extends AppCompatActivity {

    Button btnambulan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambu);
        btnambulan=(Button) findViewById(R.id.btnaddamb);
        btnambulan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent addamb=new Intent(getApplicationContext(),AdquirirAmbulacia.class);
                startActivity(addamb);
            }
        });
    }
}