package com.example.milton.desplegables;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class SpinnerActivity extends ActionBarActivity {

    String[] mDatos;
    Spinner mSpinner;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_layout);
        mDatos = getResources().getStringArray(R.array.datos);
        mTextView = (TextView) findViewById(R.id.textView);
        mSpinner = (Spinner) findViewById(R.id.spinner);

/* Spinner Adapter*/
        ArrayAdapter<String> mMensaje = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mDatos);
        mMensaje.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mMensaje);
/* Escucha Items Spinner */
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seleccionadoString = getResources().getString(R.string.select) + mDatos[position];
                Toast.makeText(getApplicationContext(), seleccionadoString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

