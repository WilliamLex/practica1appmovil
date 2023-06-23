package com.example.tarea1controlescomunes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class DatosRecibidos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_recibidos);


        TextView txtSaludo = (TextView) findViewById(R.id.lblsaludo);
        Bundle bundle = this.getIntent().getExtras();
        txtSaludo.setText("Hola, Bienvenido \n\n " + " Cedula: \n " + bundle.getString("ID")+ "\n\n" +

                "Nombre: \n " + bundle.getString("NOMBRES") + "\n\n" +

                " Fecha: \n " + bundle.getString("FN") + "\n\n" +

                " Ciudad: \n " + bundle.getString("CIUDAD") + "\n\n" +

                " Género: \n " + bundle.getString("MASCULINO") + "\n\n" +

                " Género: \n " + bundle.getString("FEMENINO") + "\n\n" +

                " Correo: \n " + bundle.getString("CORREO") + "\n\n\n" +

                " Telefono: \n " + bundle.getString("TELEFONO"));



    }



}