package com.example.midoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class AdquirirPrueba extends AppCompatActivity {

    Button mfecha, mhora;
    EditText efecha,ehora;
    private int dia,mes,anio,hora,minutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adquirir_prueba);

        mfecha=(Button) findViewById(R.id.btnfecha);
        mhora=(Button) findViewById(R.id.btnhora);
        efecha=(EditText) findViewById(R.id.eFecha);
        ehora=(EditText) findViewById(R.id.eHora);

        mfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view==mfecha){
                    final Calendar c=Calendar.getInstance();
                    dia=c.get(Calendar.DAY_OF_MONTH);
                    mes=c.get(Calendar.MONTH);
                    anio=c.get(Calendar.YEAR);

                    DatePickerDialog datePickerDialog=new DatePickerDialog(AdquirirPrueba.this,new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                    efecha.setText(i2+"/"+(i1+1)+"/"+i);
                                }
                            }
                            ,dia,
                            mes,
                            anio);
                    datePickerDialog.show();
                }
            }
        });

        mhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view==mhora){

                }
            }
        });

    }
}