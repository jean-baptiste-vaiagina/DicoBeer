package com.example.dicobeer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView image_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.image_bottom = (ImageView) findViewById(R.id.image_bottom);

        image_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ortherActivity = new Intent(getApplicationContext(), DataBeer.class);
                startActivity(ortherActivity);
                finish();
            }
        });
    }
}
