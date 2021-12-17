package com.example.midoctor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

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

    public ArrayList<Med> mostrarmed(){
        DatabaseHelper db=new DatabaseHelper(context);
        SQLiteDatabase dbbb=db.getWritableDatabase();

        ArrayList<Med> listamed=new ArrayList<>();
        Med medi=null;
        Cursor cursormed=null;

        cursormed=dbbb.rawQuery("SELECT * FROM "+TABLE_MEDICINE,null);
        if (cursormed.moveToFirst()){
            do {
                medi=new Med();
                medi.setId(cursormed.getInt(0));
                medi.setNombremed(cursormed.getString(1));
                medi.setHoramed(cursormed.getString(2));
                listamed.add(medi);
            }while (cursormed.moveToNext());
        }
        cursormed.close();
        return listamed;
    }

    public Med vermed(int id){
        DatabaseHelper db=new DatabaseHelper(context);
        SQLiteDatabase dbbb=db.getWritableDatabase();


        Med medi=null;
        Cursor cursormed=null;

        cursormed=dbbb.rawQuery("SELECT * FROM "+TABLE_MEDICINE+" WHERE id = "+id+" LIMIT 1",null);
        if (cursormed.moveToFirst()){

                medi=new Med();
                medi.setId(cursormed.getInt(0));
                medi.setNombremed(cursormed.getString(1));
                medi.setHoramed(cursormed.getString(2));


        }
        cursormed.close();
        return medi;
    }

    public boolean editarMedicamento(int id,String nombre, String hora){
        boolean correcto=false;

        DatabaseHelper db=new DatabaseHelper(context);
        SQLiteDatabase dbbb=db.getWritableDatabase();
        try {
            dbbb.execSQL("UPDATE "+TABLE_MEDICINE+" SET nombremed = '"+nombre+"', horamed = '"+hora+"' WHERE id='"+id+"' ");
            correcto=true;
        }catch (Exception ex){
            ex.toString();
            correcto=false;
        }finally {
            dbbb.close();
        }


        return correcto;
    }

    public boolean eliminarMedicamento(int id){
        boolean correcto=false;

        DatabaseHelper db=new DatabaseHelper(context);
        SQLiteDatabase dbbb=db.getWritableDatabase();
        try {
            dbbb.execSQL("DELETE FROM "+TABLE_MEDICINE+" WHERE id = '"+id+"'");
            correcto=true;
        }catch (Exception ex){
            ex.toString();
            correcto=false;
        }finally {
            dbbb.close();
        }


        return correcto;
    }


}
