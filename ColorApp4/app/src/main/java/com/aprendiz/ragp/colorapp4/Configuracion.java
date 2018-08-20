package com.aprendiz.ragp.colorapp4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Configuracion extends AppCompatActivity implements View.OnClickListener{
    RadioButton rbtnTiempo, rbtnIntentos;
    EditText txtTiempo, txtIntentos;
    SharedPreferences juegoC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        inizialite();
        inputData();
    }

    private void inizialite() {
        rbtnIntentos = findViewById(R.id.rbtnIntentos);
        rbtnTiempo = findViewById(R.id.rbtnTiempo);
        txtIntentos = findViewById(R.id.txtIncorrectas);
        txtTiempo = findViewById(R.id.txtPalabras);
        rbtnIntentos.setOnClickListener(this);
        rbtnTiempo.setOnClickListener(this);
    }

    private void inputData() {
        juegoC = getSharedPreferences("juegoC",MODE_PRIVATE);
        int modo= juegoC.getInt("modo",1);
        int tiempo = juegoC.getInt("tiempo",3);
        int cantidad = juegoC.getInt("cantidad",3);
        if (modo==1){
            rbtnTiempo.setChecked(true);
            txtTiempo.setEnabled(true);
            txtIntentos.setEnabled(false);
            txtTiempo.setText(Integer.toString(tiempo));
            txtIntentos.setText(Integer.toString(cantidad));
        }else {
            rbtnIntentos.setChecked(true);
            txtTiempo.setEnabled(false);
            txtIntentos.setEnabled(true);
            txtTiempo.setText(Integer.toString(tiempo));
            txtIntentos.setText(Integer.toString(cantidad));
        }
    }

    public void jugar(View view) {
        guardar();
        Intent intent = new Intent(Configuracion.this,JuegoC.class);
        startActivity(intent);
        finish();
    }

    private void guardar() {

        SharedPreferences.Editor editor = juegoC.edit();
        if (rbtnTiempo.isChecked()){
            editor.putInt("modo",1);
            try {
                int intentos = Integer.parseInt(txtIntentos.getText().toString());
                if (intentos>0 && intentos<11){
                    editor.putInt("cantidad",intentos);
                }else {
                    Toast.makeText(this, "No se guarará el tiempo por pasarse del límite de mayor 0 o menor a 11", Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e){
                Toast.makeText(this, "No se guarará el tiempo por tener otro tipo de caracteres", Toast.LENGTH_SHORT).show();
            }
        }else {
            editor.putInt("modo",2);
            try {
                int tiempo = Integer.parseInt(txtTiempo.getText().toString());
                if (tiempo>0 && tiempo<11){
                    editor.putInt("tiempo",tiempo);
                }else {
                    Toast.makeText(this, "No se guarará el tiempo por pasarse del límite de mayor 0 o menor a 11", Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e){
                Toast.makeText(this, "No se guarará el tiempo por tener otro tipo de caracteres", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rbtnTiempo:
                txtTiempo.setEnabled(true);
                txtIntentos.setEnabled(false);
                break;
            case R.id.rbtnIntentos:
                txtTiempo.setEnabled(false);
                txtIntentos.setEnabled(true);
                break;
        }
    }
}
