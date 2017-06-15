package com.example.srmar.groupproject;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Set;


public class MainActivity extends AppCompatActivity {
    BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void bluetooth(View view){
        String deviceName = "";
        String deviceHardwareAddress = "";
        final String macAddress = "00:1F:40:08:00:24";
        if (mBluetoothAdapter == null) {
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText("Bluetooth device is not available!");
        }
        if (!mBluetoothAdapter.isEnabled()) {
            startActivity(new Intent (BluetoothAdapter.ACTION_REQUEST_ENABLE));
//            startActivity(new Intent(Settings.ACTION_BLUETOOTH_SETTINGS));
        }
        if (mBluetoothAdapter.isEnabled()){
            Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
            if (pairedDevices.size() > 0) {
                // There are paired devices. Get the name and address of each paired device.
                for (BluetoothDevice device : pairedDevices) {
                    deviceName = device.getName();
                    deviceHardwareAddress = device.getAddress(); // MAC address
                }
            }
            if (deviceHardwareAddress.equals(macAddress)){
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText("You are here!");
            }else{
                startActivity(new Intent(Settings.ACTION_BLUETOOTH_SETTINGS));
            }
        }
    }
}
