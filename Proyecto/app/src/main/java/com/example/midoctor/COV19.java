package com.example.midoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class COV19 extends AppCompatActivity {

    Button btncov;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cov19);

        btncov = (Button) findViewById(R.id.btnaddpcov);
        btncov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addpru = new Intent(getApplicationContext(),AdquirirPrueba.class);
                startActivity(addpru);
            }
        });

    }
}