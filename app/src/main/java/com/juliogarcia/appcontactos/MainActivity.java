package com.juliogarcia.appcontactos;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnSig;
    EditText etNombre;
    EditText etTelefono;
    TextView tvNacimiento;
    EditText etEmail;
    EditText etDescripcion;


    private static final String TAG = "MainActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSig = (Button)findViewById(R.id.btnSig);

        etNombre = (EditText)findViewById(R.id.etNombre);
        tvNacimiento = (TextView)findViewById(R.id.tvNacimiento);
        etTelefono = (EditText)findViewById(R.id.etTelefono);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etDescripcion = (EditText)findViewById(R.id.etDescripcion);

        btnSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataActivity.class);
                intent.putExtra("InfoNombre", etNombre.getText().toString());
                intent.putExtra("InfoFecha",tvNacimiento.getText().toString());
                intent.putExtra("InfoTelefono",etTelefono.getText().toString());
                intent.putExtra("InfoEmail",etEmail.getText().toString());
                intent.putExtra("InfoDescripcion",etDescripcion.getText().toString());
                startActivity(intent);
            }
        });

        mDisplayDate = (TextView) findViewById(R.id.tvNacimiento);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };
    }

}
