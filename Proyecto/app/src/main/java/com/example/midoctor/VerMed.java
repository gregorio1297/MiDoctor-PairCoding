package com.example.midoctor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VerMed extends AppCompatActivity {

    EditText txtnombremed,txthoramed;
    Button btnmod,btnelim;
    boolean correcto=false;

    Med medicamento;
    int id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_med);
        txtnombremed=findViewById(R.id.txnommed);
        txthoramed=findViewById(R.id.txthoramedicamento);
        btnmod=findViewById(R.id.btnmodmed);
        btnelim=findViewById(R.id.btnelimmed);

        if (savedInstanceState==null){
            Bundle extra=getIntent().getExtras();
            if (extra==null){
                id= Integer.parseInt(null);
            }else{
                id=extra.getInt("ID");
            }
        }else{
            id=(int) savedInstanceState.getSerializable("ID");
        }
        Medicamentos db=new Medicamentos(VerMed.this);
        medicamento=db.vermed(id);

        if (medicamento!=null){
            txtnombremed.setText(medicamento.getNombremed());
            txthoramed.setText(medicamento.getHoramed());
        }

        btnmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtnombremed.getText().toString().equals("") && !txthoramed.getText().toString().equals("")){
                    correcto=db.editarMedicamento(id,txtnombremed.getText().toString(),txthoramed.getText().toString());
                    if(correcto){
                        Toast.makeText(VerMed.this, "Medicamento Modificado", Toast.LENGTH_SHORT).show();
                        Intent intn=new Intent(VerMed.this,Menu.class);
                        startActivity(intn);

                    }
                    else{
                        Toast.makeText(VerMed.this, "Error", Toast.LENGTH_SHORT).show();

                    }
                }
                else{
                    Toast.makeText(VerMed.this, "Llenar los campos", Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnelim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(VerMed.this);
                builder.setMessage("Desea eliminar el medicamento?").setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(db.eliminarMedicamento(id)){
                            verReg();
                        }
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();
            }
        });
    }

    public void verReg(){
        Intent intent=new Intent(this,Menu.class);
        startActivity(intent);
    }
}