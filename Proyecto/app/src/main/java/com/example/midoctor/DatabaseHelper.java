package com.example.midoctor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Version de la base de datos
    private static final int DATABASE_VERSION = 1;

    //Nombre de la base de datos
    private static final String DATABASE_NAME = "MiDoctor";

    //Nombre de la tabla usuarios
    private static final String TABLE_USERS = "users";
    private static final String TABLE_SERVICES = "services";
    private static final String TABLE_HISTORY = "history";

    //Nombre de las columnas de la tabla users
    private static final String KEY_ID = "id";
    private static final String KEY_NOM = "nombre";
    private static final String KEY_AP = "apellido";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    ////Nombre de las columnas de la tabla services
    private static final String KEY_IDSER = "id";
    private static final String KEY_NOMSER = "nombreservicio";
    private static final String KEY_DESCR = "descripcion";
    private static final String KEY_PREC = "precio";
    private static final String KEY_IDFK = "idusuario";

    //Constructor
    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME,
                null, DATABASE_VERSION);
    }

    //Creando Tablas
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_USERS_TABLE = "CREATE TABLE  "
                +TABLE_USERS+"("+KEY_ID+ " INTEGER PRIMARY KEY,"
                +KEY_NOM+ " TEXT,"
                +KEY_AP+ " TEXT,"
                +KEY_EMAIL+ " TEXT,"
                +KEY_PASSWORD+ " TEXT)";

        String CREATE_SERVICES_TABLE = "CREATE TABLE  "
                +TABLE_SERVICES+"("+KEY_IDSER+ " INTEGER PRIMARY KEY,"
                +KEY_NOMSER+ " TEXT,"
                +KEY_DESCR+ " TEXT,"
                +KEY_PREC+ " TEXT,"
                +KEY_IDFK+ " INTEGER)";

        db.execSQL(CREATE_USERS_TABLE);
        db.execSQL(CREATE_SERVICES_TABLE);

    }

    //Actualizar la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Borra tablas antiguas si existen
        db.execSQL("DROP TABLE IF EXISTS " +
                TABLE_USERS);

        db.execSQL("DROP TABLE IF EXISTS " +
                TABLE_SERVICES);

        //Crear tabla otra vez
        onCreate(db);

    }

    //CRUD(Create, Read, Update, Delete)
    //Create, Agregar Contacto

    public  void addUsers(Usuario usuario){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NOM,usuario.getNombre());//Nombre
        values.put(KEY_AP,usuario.getApellido());//Apellido
        values.put(KEY_EMAIL,usuario.getEmail());//Email
        values.put(KEY_PASSWORD, usuario.getPassword());//Password
        //Insertar filas
        db.insert(TABLE_USERS,null,values);
        db.close();//Cerrar la conexion con la base de datos
    }
    //Read, Obtener todos los contactos
    public Usuario getUsers(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_USERS, new String[]{KEY_ID,KEY_NOM,KEY_AP, KEY_EMAIL, KEY_PASSWORD},
                KEY_ID+"=?", new String[]{String.valueOf(id)},null,null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        //0 = id, 1 = nombre, 2 = apellido, 3 = email, 4 = password
        Usuario usuario=new Usuario(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        //Regresa un Usuario
        return usuario;
    }
    //Read all, obtener todos los usuarios
    public List<Usuario> getAllUsers(){
        ArrayList<Usuario> allUsers = new ArrayList<Usuario>();
        //Consultar todos
        String selectQuery="SELECT * FROM "+TABLE_USERS;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        //Iterar sobre todas ;as filas y las agrega a la lista
        if (cursor.moveToFirst()){
            do {

                Usuario usuario=new Usuario();
                usuario.setId(Integer.parseInt(cursor.getString(0)));
                usuario.setNombre(cursor.getString(1));
                usuario.setApellido(cursor.getString(2));
                usuario.setEmail(cursor.getString(3));
                usuario.setPassword(cursor.getString(4));
                //agrega contactos a la lista
                allUsers.add(usuario);
            }while(cursor.moveToNext());
        }
        return  allUsers;
    }
    //Update, Actualiza un contacto
    public void updateUsers(int id, String nombre, String apellido, String email, String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NOM, nombre);
        values.put(KEY_AP, apellido);
        values.put(KEY_EMAIL, email);
        values.put(KEY_PASSWORD, password);
        //actualiza fila
        db.update(TABLE_USERS,values,KEY_ID+"=?",new String[]{String.valueOf(id)});
    }
    //Delete, Borrar un contacto
    public void deleteUsers(Usuario usuario){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_USERS,KEY_ID+"=?", new String[]{String.valueOf(usuario.getId())});
    }
    //Obtiene el conteo de contactos
    public int getUsersCount(){
        String countQuery="SELECT * FROM " + TABLE_USERS;
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        return  cursor.getCount();
    }

    public boolean checkuser(String username){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from "+TABLE_USERS+" where "+KEY_EMAIL+" =?",new String[]{username});
        if (cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkuserpassword(String username,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from "+TABLE_USERS+" where "+KEY_EMAIL+" =?"+" and "+KEY_PASSWORD+" =?",new String[]{username,password});
        if (cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public Usuario verusuario(){
        Usuario usuario = null;
        SQLiteDatabase db=this.getWritableDatabase();

        String selectQuery="SELECT * FROM "+TABLE_USERS+" WHERE id = 5";

        Cursor cursor=db.rawQuery(selectQuery,null);
        //Iterar sobre todas ;as filas y las agrega a la lista
        if (cursor.moveToFirst()){
            usuario=new Usuario();
            usuario.setId(Integer.parseInt(cursor.getString(0)));
            usuario.setNombre(cursor.getString(1));
            usuario.setApellido(cursor.getString(2));
            usuario.setEmail(cursor.getString(3));
            usuario.setPassword(cursor.getString(4));

        }

        return usuario;
    }

}
