package com.example.midoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class AdquirirVacuna extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button mfecha, mhora,addambsig;
    EditText efecha,ehora;
    private int dia,mes,anio,hora,minutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adquirir_vacuna);
        mfecha=(Button) findViewById(R.id.btnfechaa);
        mhora=(Button) findViewById(R.id.btnhoraa);
        efecha=(EditText) findViewById(R.id.eFechaa);
        ehora=(EditText) findViewById(R.id.eHoraa);
        addambsig=(Button) findViewById(R.id.btnAddAmb);

        Spinner spinner=findViewById(R.id.spinnervacuna);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.vacunas, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        mfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view==mfecha){
                    final Calendar c=Calendar.getInstance();
                    dia=c.get(Calendar.DAY_OF_MONTH);
                    mes=c.get(Calendar.MONTH);
                    anio=c.get(Calendar.YEAR);

                    DatePickerDialog datePickerDialog=new DatePickerDialog(AdquirirVacuna.this,new DatePickerDialog.OnDateSetListener() {
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
                    TimePickerDialog timePickerDialog=new TimePickerDialog(AdquirirVacuna.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int i, int i1) {
                            ehora.setText(i+":"+i1);
                        }
                    },hora,minutos,false);
                    timePickerDialog.show();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text=adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}