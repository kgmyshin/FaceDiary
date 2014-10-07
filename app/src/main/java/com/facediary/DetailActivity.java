package com.facediary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;


public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ((BootstrapButton) findViewById(R.id.history_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, HisotryActivity.class);
                startActivity(intent);
            }
        });

        ((BootstrapButton) findViewById(R.id.mental_more_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, MentalMoreActivity.class);
                startActivity(intent);
            }
        });
        ((BootstrapButton) findViewById(R.id.mental_more_history_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, MentalConditionHistoryActivity.class);
                startActivity(intent);
            }
        });
    }

}
