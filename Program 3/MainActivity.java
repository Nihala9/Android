package com.example.program3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText fno = findViewById(R.id.etNumber1);
        EditText sno = findViewById(R.id.etNumber2);
        Button add = findViewById(R.id.btnAdd);
        Button sub = findViewById(R.id.btnSub);
        Button mul = findViewById(R.id.btnMul);
        Button div = findViewById(R.id.btnDiv);
        TextView tv = findViewById(R.id.tvResult);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fstr = fno.getText().toString();
                String sstr = sno.getText().toString();

                if (fstr.isEmpty() || sstr.isEmpty()) {
                    tv.setText("Plz enter both numbers");
                    return;
                }

                double n1 = Double.parseDouble(fstr);
                double n2 = Double.parseDouble(sstr);
                double result = 0.0;

                int id = v.getId();

                if (id == R.id.btnAdd) {
                    result = n1 + n2;
                } else if (id == R.id.btnSub) {
                    result = n1 - n2;
                } else if (id == R.id.btnMul) {
                    result = n1 * n2;
                } else if (id == R.id.btnDiv) {
                    if (n2 == 0) {
                        tv.setText("Can't divide by zero");
                        return;
                    }
                    result = n1 / n2;
                }

                tv.setText("Result = " + String.valueOf(result));

            }
        };

        add.setOnClickListener(listener);
        sub.setOnClickListener(listener);
        mul.setOnClickListener(listener);
        div.setOnClickListener(listener);
    }
}
