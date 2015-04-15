package com.example.milton.desplegables;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class ListviewActivity extends ActionBarActivity {
    String[] mDatos;
    ListView mListView;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        mDatos = getResources().getStringArray(R.array.datos);
        mTextView = (TextView) findViewById(R.id.textView);
        mListView = (ListView) findViewById(R.id.listView);

/* ListView Adapter*/
        ArrayAdapter<String> mMensaje = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mDatos);
        mListView.setAdapter(mMensaje);
/* Escucha Items ListView */
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seleccionadoString = getResources().getString(R.string.select) + mDatos[position];
                Toast.makeText(getApplicationContext(), seleccionadoString, Toast.LENGTH_SHORT).show();
            }
        });
    }