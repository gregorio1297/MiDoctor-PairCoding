package com.example.midoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AMBU extends AppCompatActivity {

    private Button mAmbulancia;

    public void AdquirirAmbu(View view){
        Intent siguiente=new Intent(this,AdquirirAmbulacia.class);
        startActivity(siguiente);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambu);
    }
}