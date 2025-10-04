package com.example.program9;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView tv1, tv2, tv3;
    Button btnLogout;
    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tv1 = findViewById(R.id.tvName);
        tv2 = findViewById(R.id.tvEmail);
        tv3 = findViewById(R.id.tvPassword);
        btnLogout = findViewById(R.id.btnLogout);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        // Load values
        String name = sharedPreferences.getString("Name", "No Name");
        String mail = sharedPreferences.getString("Email", "No Email");
        String pass = sharedPreferences.getString("Password", "No Password");

        tv1.setText("Name: " + name);
        tv2.setText("Email: " + mail);
        tv3.setText("Password: " + pass);

        btnLogout.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();

            // Return to MainActivity
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}
