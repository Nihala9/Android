package com.example.program9;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText et1, et2, et3;
    Button btn1;

    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        et1 = findViewById(R.id.etName);
        et2 = findViewById(R.id.etEmail);
        et3 = findViewById(R.id.etPassword);
        btn1 = findViewById(R.id.btnReg);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        // Pre-fill if already registered
        et1.setText(sharedPreferences.getString("Name", ""));
        et2.setText(sharedPreferences.getString("Email", ""));
        et3.setText(sharedPreferences.getString("Password", ""));

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = et1.getText().toString().trim();
                String mail = et2.getText().toString().trim();
                String pass = et3.getText().toString().trim();

                if(name.isEmpty() || mail.isEmpty() || pass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Name", name);
                editor.putString("Email", mail);
                editor.putString("Password", pass);
                editor.apply();

                Toast.makeText(MainActivity.this, "Registration saved!", Toast.LENGTH_SHORT).show();

                // Navigate to ProfileActivity
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
