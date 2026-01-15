package com.example.listcity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
public class MainActivity extends AppCompatActivity {
    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> datalist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        cityList = findViewById(R.id.city_List);
        String []cities = {"Edmonton","Vancouver","Moscow","Sydney","Berlin","Vienna","Beijing","Tokyo","Osaka","New Delhi"};
        datalist = new ArrayList<>();
        datalist.addAll(Arrays.asList(cities));
        cityAdapter = new ArrayAdapter<>(this, R.layout.content,datalist);
        cityList.setAdapter(cityAdapter);




        Button badd = findViewById(R.id.badd);
        Button bdelet = findViewById(R.id.bdelet);

        final int[] sel = {-1};

        cityList.setOnItemClickListener((p,v,i,id)-> sel[0]=i);

        badd.setOnClickListener(v -> {
            EditText e = new EditText(this);
            new AlertDialog.Builder(this).setView(e).setPositiveButton("OK",(d,w)->{
                String s = e.getText().toString();
                if(!s.isEmpty()){
                    datalist.add(s);
                    cityAdapter.notifyDataSetChanged();
                }
            }).setNegativeButton("Cancel",null).show();
        });

        bdelet.setOnClickListener(v -> {
            if(sel[0]>=0){
                datalist.remove(sel[0]);
                sel[0] = -1;
                cityAdapter.notifyDataSetChanged();
            }
        });


    }
}