package com.zoom.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dialpad(View view) {
        Intent phonecall = new Intent(this, dialpad.class);
        startActivity(phonecall);
    }

    public void contact_list(View v) {

        Intent contactList = new Intent(this, contact_activity.class);
        startActivity(contactList);

    }

    public void openCamera(View v) {
        Intent cam = new Intent(this, camera_activity.class);
        startActivity(cam);

    }

    public void bluetooth(View v) {
        Intent mBlue = new Intent(this, bluetooth_activity.class);
        startActivity(mBlue);

    }

    public void mail(View v) {
        Intent memail = new Intent(this, email.class);
        startActivity(memail);
    }

}
