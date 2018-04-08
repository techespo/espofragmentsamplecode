package com.techespo.techespofragmentsamplecode;


import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.techespo.techespofragmentsamplecode.fragments.FragmentOne;
import com.techespo.techespofragmentsamplecode.fragments.FragmentTwo;

public class DynamicFragmentActivity extends AppCompatActivity implements FragmentTwo.OnFragmentTwoInteractionListener {
    @Override
    public void onFragmentOptionSelected(String event) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);


        ((Button)findViewById(R.id.btn_f1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm =  getSupportFragmentManager();
                FragmentTransaction t =  fm.beginTransaction();
                FragmentOne  f1 = new FragmentOne();
                t.replace(R.id.ll_container,f1);
                t.commit();
            }
        });
        ((Button)findViewById(R.id.btn_f2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm =  getSupportFragmentManager();
                FragmentTransaction t =  fm.beginTransaction();
                FragmentTwo f2 = FragmentTwo.newInstance("Value1" ,"Value2");
                t.replace(R.id.ll_container,f2);
                t.commit();
            }
        });


    }

    @Override
    public void onFragmentInteraction(String event) {
        Toast.makeText(DynamicFragmentActivity.this,"Event Happen:" + event,Toast.LENGTH_LONG).show();

    }
}
