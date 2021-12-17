package com.example.midoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity {

    ImageButton btnmedicamentos,btnpruebacov,btnvacu,btnmodficar;
    Button btncerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnmedicamentos=findViewById(R.id.btnmedicamentos);
        btnpruebacov=findViewById(R.id.btnprucov19);
        btnvacu=findViewById(R.id.btnagvac);
        btnmodficar=findViewById(R.id.btnmodperfil);
        btncerrar=findViewById(R.id.btnsali);

        btnmedicamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1=new Intent(getApplicationContext(),RegMed.class);
                startActivity(int1);
            }
        });

        btnpruebacov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2=new Intent(getApplicationContext(),COV19.class);
                startActivity(int2);
            }
        });

        btnvacu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int3=new Intent(getApplicationContext(),VACCINE.class);
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

        btncerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int5=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(int5);
            }
        });
    }
}