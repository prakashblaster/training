package com.zoom.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class bluetooth_activity extends AppCompatActivity {
ToggleButton bluetooth;
BluetoothAdapter ba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        bluetooth = (ToggleButton)findViewById(R.id.toggle);
        ba=BluetoothAdapter.getDefaultAdapter();

        bluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE),0);
                }
                else{
                    ba.disable();
                }

            }
        });
    }



    }

