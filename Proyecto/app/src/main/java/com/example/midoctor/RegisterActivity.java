package com.example.midoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText nombre,apellido,username,password;
    Button btnregistrar;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nombre=(EditText) findViewById(R.id.nombre_user);
        apellido=(EditText) findViewById(R.id.lastname_user);
        username=(EditText) findViewById(R.id.user_name);
        password=(EditText) findViewById(R.id.password);
        btnregistrar=(Button) findViewById(R.id.regis_button);

        db = new DatabaseHelper(this);

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom=nombre.getText().toString();
                String apel=apellido.getText().toString();
                String user=username.getText().toString();
                String pass=password.getText().toString();
                Integer cont=2;
                Usuario obj=new Usuario(cont,nom,apel,user,pass);
                if (nom.equals("")||apel.equals("")||user.equals("")||pass.equals("")){
                    Toast.makeText(RegisterActivity.this, "Rellenar todos los datos", Toast.LENGTH_SHORT).show();
                }
                else{
                    db.addUsers(obj);
                    cont++;

                    Toast.makeText(RegisterActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}