package com.example.program7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView img1,img2;
    private boolean showFirst=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1=findViewById(R.id.imageView);
        img2=findViewById(R.id.imageView2);
        Button toglebtn=findViewById(R.id.button1);

        toglebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showFirst) {
                    img1.setVisibility(View.GONE);
                    img2.setVisibility(View.VISIBLE);
                }
                else {
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.GONE);
                }
                showFirst=!showFirst;
            }
        });
    }
}