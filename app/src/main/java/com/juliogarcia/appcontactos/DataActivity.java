package com.juliogarcia.appcontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvNacimiento;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvNacimiento = (TextView)findViewById(R.id.tvNacimiento);
        tvTelefono = (TextView)findViewById(R.id.tvTelefono);
        tvEmail = (TextView)findViewById(R.id.tvEmail);
        tvDescripcion = (TextView)findViewById(R.id.tvDescripcion);

        Bundle bundleName = getIntent().getExtras();
        Bundle bundleDate = getIntent().getExtras();
        Bundle bundlePhone = getIntent().getExtras();
        Bundle bundleEmail = getIntent().getExtras();
        Bundle bundleDescription = getIntent().getExtras();

        String datoName = bundleName.getString("InfoNombre").toString();
        String datoDate = bundleDate.getString("InfoFecha".toString());
        String datoTelefono = bundlePhone.getString("InfoTelefono".toString());
        String datoEmail = bundleEmail.getString("InfoEmail".toString());
        String datoDescription = bundleDescription.getString("InfoDescripcion".toString());

        tvNombre.setText("Nombre completo: " + datoName);
        tvNacimiento.setText("Fecha de nacimiento: " + datoDate);
        tvTelefono.setText("Telefono: " + tvTelefono);
        tvEmail.setText("E-mail: " + datoEmail);
        tvDescripcion.setText("Descripción: " + datoDescription);
    }

    public void onClick(View View){
        Intent myIntent=new Intent(DataActivity.this,MainActivity.class);
        finish();
    }

}