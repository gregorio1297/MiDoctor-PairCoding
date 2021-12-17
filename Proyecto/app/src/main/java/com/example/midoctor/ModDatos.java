package com.example.midoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ModDatos extends AppCompatActivity {

    EditText txtnom,txtape,txtusua,txtpass;
    Button btnmod;
    Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_datos);
        txtnom=findViewById(R.id.nombre_usermod);
        txtape=findViewById(R.id.lastname_usermod);
        txtusua=findViewById(R.id.user_namemod);
        txtpass=findViewById(R.id.passwordmod);
        btnmod=findViewById(R.id.savechanges_button);

        DatabaseHelper db=new DatabaseHelper(this);
        user=db.verusuario();
        txtnom.setText(user.getNombre());
        txtape.setText(user.getApellido());
        txtusua.setText(user.getEmail());
        txtpass.setText(user.getPassword());

    }
}