package com.example.midoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class RegMed extends AppCompatActivity {

    EditText txtnombre,txthora;
    Button btnguar;
    RecyclerView listamed;
    ArrayList<Med> listaarraymed;
    Medicamentos dbmed=new Medicamentos(RegMed.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_med);
        txtnombre=findViewById(R.id.txtnombremed);
        txthora=findViewById(R.id.txthoramed);
        btnguar=findViewById(R.id.btnguardarmed);
        listamed=findViewById(R.id.listamed);


        btnguar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long id=dbmed.insertarMedicamento(txtnombre.getText().toString(),txthora.getText().toString());
                if(id>0){
                    Toast.makeText(RegMed.this, "Agregado", Toast.LENGTH_SHORT).show();
                    limpiar();
                }else {
                    Toast.makeText(RegMed.this,"Nel",Toast.LENGTH_SHORT).show();
                }
            }
        });

        listamed.setLayoutManager(new LinearLayoutManager(this));
        listaarraymed = new ArrayList<>();
        ListaMedAdap adap=new ListaMedAdap(dbmed.mostrarmed());
        listamed.setAdapter(adap);
    }

    private void limpiar(){
        txthora.setText("");
        txtnombre.setText("");
    }
}