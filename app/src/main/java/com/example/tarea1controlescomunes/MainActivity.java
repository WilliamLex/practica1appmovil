package com.example.tarea1controlescomunes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton rdbmasculino,rdbfemenino;
    private EditText txtid;
    private EditText txtnombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLimpiar = findViewById(R.id.btnlimpiar);
        txtid = findViewById(R.id.txtid);
        txtnombres = findViewById(R.id.txtnombres);


        // Configurar el listener para el botón Limpiar
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarFormulario();
            }
        });


    }

    public void btnenviar(View view){
        //Creamos el Intent
        Intent intent = new Intent(MainActivity.this, DatosRecibidos.class);
        EditText txtid = (EditText)findViewById(R.id.txtid);
        EditText txtnombres = (EditText)findViewById(R.id.txtnombres);
        EditText txtfecha = (EditText)findViewById(R.id.txtfecha);
        EditText txtciudad = (EditText)findViewById(R.id.txtciudad);
        RadioButton rdbmasculino = (RadioButton) findViewById(R.id.rdbmasculino);
        RadioButton rdbfemenino = (RadioButton)findViewById(R.id.rdbfemenino);
        EditText txtcorreo = (EditText)findViewById(R.id.txtcorreo);
        EditText txttelefono = (EditText)findViewById(R.id.txttelefono);


        //Creamos la información a pasar entre actividades - Pares Key-Value
        Bundle b = new Bundle();

        b.putString("ID", txtid.getText().toString());
        b.putString("NOMBRES", txtnombres.getText().toString());
        b.putString("FN", txtfecha.getText().toString());
        b.putString("CIUDAD", txtciudad.getText().toString());
        b.putString("MASCULINO", rdbmasculino.getText().toString());
        b.putString("FEMENINO", rdbfemenino.getText().toString());
        b.putString("CORREO", txtcorreo.getText().toString());
        b.putString("TELEFONO", txttelefono.getText().toString());


        //Añadimos la información al intent
        intent.putExtras(b);
        // Iniciamos la nueva actividad
        startActivity(intent);
        if(view.getId()==R.id.btnenviar){
            validar();
        }
    }
    private boolean validarCampos() {

        String cedula = txtid.getText().toString();
        String nombres = txtnombres.getText().toString();

        if (!validarCedula(cedula)) {
            mostrarToast("Cédula inválida");
            return false;
        }

        if (!validarNombres(nombres)) {
            mostrarToast("Nombres inválidos");
            return false;
        }



        return true;
    }

    private boolean validarCedula(String cedula) {
        return cedula.matches("\\d{1,10}");
    }

    private boolean validarNombres(String nombres) {
        return nombres.matches("[A-Za-z\\s]{1,500}");
    }

    private void mostrarToast(String mensaje) {
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
    }





    private void validar(){
        String selec="Seleccionado: \n";
        if(rdbmasculino.isChecked()==true){
            selec+="Opcion1\n";
        }
        if (rdbfemenino.isChecked()) {
            selec += "Opcion2\n";
        }

        Toast.makeText(getApplicationContext(),selec,Toast.LENGTH_SHORT).show();
    }

    private void limpiarFormulario()
    {
        EditText txtid = findViewById(R.id.txtid);
        EditText txtnombres = findViewById(R.id.txtnombres);
        EditText txtfecha = findViewById(R.id.txtfecha);
        EditText txtciudad = findViewById(R.id.txtciudad);
        RadioButton rdbmasculino = findViewById(R.id.rdbmasculino);
        RadioButton rdbfemenino = findViewById(R.id.rdbfemenino);
        EditText txtcorreo = findViewById(R.id.txtcorreo);
        EditText txttelefono = findViewById(R.id.txttelefono);

        txtid.setText("");
        txtnombres.setText("");
        txtfecha.setText("");
        txtciudad.setText("");
        rdbmasculino.setChecked(false);
        rdbfemenino.setChecked(false);
        txtcorreo.setText("");
        txttelefono.setText("");

        Toast.makeText(getApplicationContext(), "Formulario limpiado", Toast.LENGTH_SHORT).show();
    }

}