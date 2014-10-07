package com.facediary;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.beardedhen.androidbootstrap.BootstrapButton;


public class PictureActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        Bitmap bmp = (Bitmap) b.get("data");
        Matrix matrix = new Matrix();
        matrix.preScale(1, -1);
        bmp = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), matrix, false);
        ImageView picImageView = (ImageView) findViewById(R.id.pic_image);
        picImageView.setImageBitmap(bmp);
        ((BootstrapButton) findViewById(R.id.judge_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PictureActivity.this, ResultActivity.class);
                startActivity(intent);
            }
        });
    }
}
