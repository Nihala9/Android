package com.example.program10;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spin;
    TextView tv;

    String[] items = {"Select", "Java", "Kotlin", "Python", "C++", "JavaScript"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin = findViewById(R.id.spinner);
        tv = findViewById(R.id.textView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(adapter);

        // Event Handling
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = items[position];
                if (!value.equals("Select")) {
                    tv.setText("You selected: " + value);
                    Toast.makeText(MainActivity.this, "Selected: " + value, Toast.LENGTH_SHORT).show();
                } else {
                    tv.setText("Please select a language");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tv.setText("No item selected");
            }
        });
    }
}
