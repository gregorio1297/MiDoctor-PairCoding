package com.example.midoctor;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Medicamentos extends DatabaseHelper{

    Context context;
    public Medicamentos(Context context) {
        super(context);
        this.context=context;
    }

    public long insertarMedicamento(String nombre, String hora){
        long id=0;
        DatabaseHelper db=new DatabaseHelper(context);
        SQLiteDatabase dbbb=db.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("nombremed",nombre);
        values.put("horamed",hora);

        id=dbbb.insert(TABLE_MEDICINE,null,values);
        return id;
    }
}
