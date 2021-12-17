package com.example.midoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity {

    ImageButton btnmedicamentos,btnpruebacov,btnvacu,btnmodficar,btncerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnpruebacov=findViewById(R.id.btnprucov19);
        btnvacu=findViewById(R.id.btnagvac);
        btnmodficar=findViewById(R.id.btnmodperfil);

        btnpruebacov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2=new Intent(getApplicationContext(),AdquirirPrueba.class);
                startActivity(int2);
            }
        });

        btnvacu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int3=new Intent(getApplicationContext(),AdquirirVacuna.class);
                startActivity(int3);
            }
        });

        btnmodficar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int4=new Intent(getApplicationContext(),ModDatos.class);
                startActivity(int4);
            }
        });
    }
}