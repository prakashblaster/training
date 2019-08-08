package com.zoom.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.webkit.PermissionRequest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.Permission;
import java.security.Permissions;

public class dialpad extends AppCompatActivity {
    private static final int REQUEST_PHONE_CALL = 1;

    private EditText mtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialpad);

        mtext = findViewById(R.id.edit_num);
        Button mButton = findViewById(R.id.dail_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneCall();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==REQUEST_PHONE_CALL){
            if (grantResults.length >0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                phoneCall();
            }else {
                Toast.makeText(this,"Permission denied",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void phoneCall() {
        String number = mtext.getText().toString();

        if (number.trim().length() > 0) {
            int checkpermission = ContextCompat.checkSelfPermission(dialpad.this, Manifest.permission.CALL_PHONE);
            if (checkpermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        dialpad.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL);
            } else {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:" + number));
                startActivity(call);
            }
        }
            else {
                Toast.makeText(dialpad.this, "enter phone num",Toast.LENGTH_SHORT).show();
        }

    }
    }



