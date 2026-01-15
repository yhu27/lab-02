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
public class MainActivity extends AppCompatActivity {
    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> datalist;

    int sel = -1;
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


        cityList.setOnItemClickListener((p,v,i,id) -> sel = i);

        badd.setOnClickListener(v -> {
            String s = ((EditText)findViewById(R.id.inputCity)).getText().toString();
            if(!s.isEmpty()){
                datalist.add(s);
                cityAdapter.notifyDataSetChanged();
            }
        });

        bdelet.setOnClickListener(v -> {
            if(sel >= 0){
                datalist.remove(sel);
                sel = -1;
                cityAdapter.notifyDataSetChanged();
            }
        });


    }
}