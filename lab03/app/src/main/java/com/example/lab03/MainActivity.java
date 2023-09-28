package com.example.lab03;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNazwaUzytkownika = findViewById(R.id.btnNazwaUżytkownika);
        Button btnPlanLekcji = findViewById(R.id.btnPlanLekcji);
        Button btnLocation = findViewById(R.id.btnLocation);

        btnNazwaUzytkownika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);
            }
        });

        btnPlanLekcji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvPlanLekcjiURL = findViewById(R.id.tvPlanLekcjiURL);
                String url = tvPlanLekcjiURL.getText().toString();


                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Activity4.class);
                startActivity(intent);
            }
        });


    }
}