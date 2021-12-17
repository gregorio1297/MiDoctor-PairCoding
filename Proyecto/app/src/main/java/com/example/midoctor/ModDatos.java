package com.example.midoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        btnmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.updateUsers(1,txtnom.getText().toString(),txtape.getText().toString(),txtusua.getText().toString()
                        ,txtpass.getText().toString());

                Toast.makeText(ModDatos.this, "Modificacion exitosa", Toast.LENGTH_SHORT).show();
                Intent inte=new Intent(getApplicationContext(),Menu.class);
                startActivity(inte);
            }
        });

    }
}