package com.example.midoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class AdquirirPrueba extends AppCompatActivity {

    Button mfecha, mhora,btncov19;
    EditText efecha,ehora;
    private int dia,mes,anio,hora,minutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adquirir_prueba);

        mfecha=(Button) findViewById(R.id.btnfechap);
        mhora=(Button) findViewById(R.id.btnhorap);
        efecha=(EditText) findViewById(R.id.eFechap);
        ehora=(EditText) findViewById(R.id.eHorap);
        btncov19=(Button)findViewById(R.id.btncovadd);

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
                            ,anio,
                            mes,
                            dia);
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
                    TimePickerDialog timePickerDialog=new TimePickerDialog(AdquirirPrueba.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int i, int i1) {
                            ehora.setText(i+":"+i1);
                        }
                    },hora,minutos,false);
                    timePickerDialog.show();
                }
            }
        });

        btncov19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Agregar();
            }
        });


    }
    public void Agregar(){
        Calendar cal=Calendar.getInstance();
        boolean val=false;
        Intent inte=null;
        while (val==false){
            try {
                cal.set(Calendar.YEAR,anio);
                cal.set(Calendar.MONTH,mes);
                cal.set(Calendar.DAY_OF_MONTH,dia);

                cal.set(Calendar.HOUR_OF_DAY, hora);
                cal.set(Calendar.MINUTE,minutos);

                inte=new Intent(Intent.ACTION_EDIT);
                inte.setType("vnd.android.cursor.item/event");
                inte.putExtra(CalendarContract.Events.ALL_DAY,true);
                inte.putExtra(CalendarContract.Events.TITLE,R.layout.support_simple_spinner_dropdown_item);
                inte.putExtra(CalendarContract.Events.DESCRIPTION,"Prueba covid");
                inte.putExtra(CalendarContract.Events.EVENT_LOCATION,"Clinica mas cercana");

                startActivity(inte);
                val=true;
            }catch (Exception e){
                ehora.setText("");
                efecha.setText("");
                Toast.makeText(getApplicationContext(), "Fecha u hora invalidad", Toast.LENGTH_SHORT).show();
            }
        }

    }
}