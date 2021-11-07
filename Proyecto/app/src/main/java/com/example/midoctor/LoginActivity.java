package com.example.midoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText username,password;
    Button btnlogin;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText) findViewById(R.id.user_name1);
        password=(EditText) findViewById(R.id.password1);
        btnlogin=(Button) findViewById(R.id.log_button);
        db = new DatabaseHelper(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                if (user.equals("")||pass.equals("")){
                    Toast.makeText(LoginActivity.this, "Llenar todos los campos para inicar sesion", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean check=db.checkuserpassword(user,pass);
                    if (check==true){
                        Toast.makeText(LoginActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),PrincipalActivity.class);
                        startActivity(intent);

                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Erro, verificar usuario o contraseña", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}