package com.example.dependentspinners;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner_Parent, spinner_Child;

    ArrayList<String> arrayList_Parent;
    ArrayAdapter<String> arrayAdapter_Parent;

    ArrayList<String> arrayList_Animals, arrayList_Birds, arrayList_Flowers;
    ArrayAdapter<String> arrayAdapter_Child;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner_Parent = findViewById(R.id.spinnerParent);
        spinner_Child = findViewById(R.id.spinnerChild);

        arrayList_Parent = new ArrayList<>();
        arrayList_Parent.add("Animals");
        arrayList_Parent.add("Birds");
        arrayList_Parent.add("Flowers");

        arrayAdapter_Parent = new ArrayAdapter<>(getApplicationContext(), R.layout.textview_blue, arrayList_Parent);

        spinner_Parent.setAdapter(arrayAdapter_Parent);

       // ===================== child spinner process starts =====================

        arrayList_Animals = new ArrayList<>();
        arrayList_Animals.add("Tiger");
        arrayList_Animals.add("Lion");
        arrayList_Animals.add("Elephant");
        arrayList_Animals.add("Monkey");
        arrayList_Animals.add("Cow");

        arrayList_Birds = new ArrayList<>();
        arrayList_Birds.add("Sparrow");
        arrayList_Birds.add("Peacock");
        arrayList_Birds.add("Eagle");

        arrayList_Flowers = new ArrayList<>();
        arrayList_Flowers.add("Rose");
        arrayList_Flowers.add("Lotus");

        spinner_Parent.setOnItemSelectedListener(new  AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    arrayAdapter_Child = new ArrayAdapter<>(getApplicationContext(), R.layout.textview_red, arrayList_Animals);
                }

                if (position == 1){
                    arrayAdapter_Child = new ArrayAdapter<>(getApplicationContext(), R.layout.textview_red, arrayList_Birds);
                }

                if (position == 2){
                    arrayAdapter_Child = new ArrayAdapter<>(getApplicationContext(), R.layout.textview_red, arrayList_Flowers);
                }

                spinner_Child.setAdapter(arrayAdapter_Child);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // ===================== child spinner process ends =====================
    }
}