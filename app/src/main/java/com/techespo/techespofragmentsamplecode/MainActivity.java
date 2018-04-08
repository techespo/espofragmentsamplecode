package com.techespo.techespofragmentsamplecode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.btn_static_fragment)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,StaticFragmentActivity.class));
            }
        });

        ((Button)findViewById(R.id.btn_dynamic_frag)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,DynamicFragmentActivity.class));
            }
        });

        final String [] name = {"Please select","Ram","Jack"};
        sp = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_dropdown_item_1line,name);
        sp.setAdapter(adapter);
        //sp.setSelection(1);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this,name[position],Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
