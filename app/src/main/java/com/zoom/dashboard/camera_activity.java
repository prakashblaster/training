package com.zoom.dashboard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class camera_activity extends AppCompatActivity {
  private Button cambutton;
    private ImageView capturedpic;
    public static final int CAMERA_REQUEST = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        cambutton =  findViewById(R.id.cambutn);
        capturedpic = findViewById(R.id.capturedImage);

        cambutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camera();

            }
        });
    }

    private void camera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, CAMERA_REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            if (data != null && data.getExtras() != null) {
                Bitmap bitmap= (Bitmap) data.getExtras().get("data");
                capturedpic.setImageBitmap(bitmap);
            }
        }
    }
}
