package com.facediary;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;


public class HomeActivity extends Activity {

    private static final int REQUEST_CAPTURE_IMAGE = 1011;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BootstrapButton cameraBtn = (BootstrapButton) findViewById(R.id.camera_btn);
        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(
                        intent,
                        REQUEST_CAPTURE_IMAGE);
            }
        });
    }


    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            Intent data) {
        if(REQUEST_CAPTURE_IMAGE == requestCode
                && resultCode == Activity.RESULT_OK ){
            Bitmap capturedImage = (Bitmap) data.getExtras().get("data");
            Intent intent = new Intent(HomeActivity.this, PictureActivity.class);
            intent.putExtra("data", capturedImage);
            startActivity(intent);
        }
    }
}
