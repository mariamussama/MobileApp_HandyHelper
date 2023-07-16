package com.mariam.registeration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Accepted extends AppCompatActivity {
    private Button viewAppsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accepted);

        // Find the button in the layout
        viewAppsButton = findViewById(R.id.ViewApps);

        // Set click listener for the button
        viewAppsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to open the target activity
                Intent intent = new Intent(Accepted.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
