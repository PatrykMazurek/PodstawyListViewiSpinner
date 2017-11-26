package com.example.patryyyk21.podstawylistviewispinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public List<String> city = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Wypełnienie przygotowanej listy
        city.add("Kraków");
        city.add("Katowice");
        city.add("Kielce");

        // Pobieranie identyfikatora List View i Spinner-a
        Spinner citySpinner = (Spinner)findViewById(R.id.spinner);
        ListView cityList = (ListView)findViewById(R.id.ListView);

        // Tworzenie Adaptera dla List View
        ArrayAdapter<String> cityAdapterList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, city);
        cityList.setAdapter(cityAdapterList);

        // Tworzenie Adaptera dla Spinner-a
        ArrayAdapter<String> cityAdapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, city);
        citySpinner.setAdapter(cityAdapterSpinner);

        // Tworzenie metody odpowiedzialnej za akcje na kontrolce Spinner
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                // Wyświetlanie id ze Spinner-a
                Toast.makeText(getApplicationContext(),Long.toString(id) , Toast.LENGTH_SHORT ).show();

                //Wyświetlenie informacji ze Spinner-a
                Toast.makeText(view.getContext(), adapterView.getItemAtPosition(position).toString() ,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
