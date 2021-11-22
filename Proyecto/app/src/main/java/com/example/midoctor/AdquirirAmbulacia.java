package com.example.midoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.midoctor.ui.Servicios.ServiciosFragment;

import java.util.Calendar;

public class AdquirirAmbulacia extends AppCompatActivity {
    Button mfecha, mhora,addambsig;
    EditText efecha,ehora;
    private int dia,mes,anio,hora,minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adquirir_ambulacia);

        mfecha=(Button) findViewById(R.id.btnfecha);
        mhora=(Button) findViewById(R.id.btnhora);
        efecha=(EditText) findViewById(R.id.eFecha);
        ehora=(EditText) findViewById(R.id.eHora);
        addambsig=(Button) findViewById(R.id.btnAddAmb);

        mfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view==mfecha){
                    final Calendar c=Calendar.getInstance();
                    dia=c.get(Calendar.DAY_OF_MONTH);
                    mes=c.get(Calendar.MONTH);
                    anio=c.get(Calendar.YEAR);

                    DatePickerDialog datePickerDialog=new DatePickerDialog(AdquirirAmbulacia.this,new DatePickerDialog.OnDateSetListener() {
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
                    final Calendar c=Calendar.getInstance();
                    hora=c.get(Calendar.HOUR_OF_DAY);
                    minutos=c.get(Calendar.MINUTE);
                    TimePickerDialog timePickerDialog=new TimePickerDialog(AdquirirAmbulacia.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int i, int i1) {
                            ehora.setText(i+":"+i1);
                        }
                    },hora,minutos,false);
                    timePickerDialog.show();
                }
            }
        });

        addambsig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AdquirirAmbulacia.this, "Servicio agregado!", Toast.LENGTH_LONG).show();
                FragmentManager manager=getFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                //transaction.add(R.layout.activity_adquirir_ambulacia,ServiciosFragment,)

            }
        });


    }
}