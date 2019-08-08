package com.zoom.dashboard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.invoke.CallSite;

public class contact_activity extends AppCompatActivity {
    private final int PICK_CONTACT = 1;
    public static int REQUEST_PHONE_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    public void contact(View v) {
        Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(i, PICK_CONTACT);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_CONTACT) {
            if (resultCode == AppCompatActivity.RESULT_OK) {
                Cursor c = getContentResolver().query(CallLog.Calls.CONTENT_URI,
                        null, null, null, null);
                int number = c.getColumnIndex(CallLog.Calls.NUMBER);

                if (c.moveToFirst()) {

                        int checkpermission = ContextCompat.checkSelfPermission(contact_activity.this, Manifest.permission.CALL_PHONE);
                        if (checkpermission != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(
                                    contact_activity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL);
                        } else {
                            Intent call = new Intent(Intent.ACTION_CALL);
                            call.setData(Uri.parse("tel:" + number));
                            startActivity(call);
                        }
                    }
                }

            }
        }
    }




