package com.myfirstapp.sensorapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

public class SensorEventListenerAdapter implements SensorEventListener {

    private final TextView textView;
    private final String sensorName;

    public SensorEventListenerAdapter(TextView textView, String sensorName) {
        this.textView = textView;
        this.sensorName = sensorName;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];

        displaySensorData(x, y, z);

        // Send data to the server
        sendDataToServer(sensorName + "\nX: " + x + "\nY: " + y + "\nZ: " + z);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Handle accuracy changes if needed
    }

    private void displaySensorData(float x, float y, float z) {
        String sensorData = sensorName + "\nX: " + x + "\nY: " + y + "\nZ: " + z;
        // Display data in the corresponding TextView
        // (Note: You may want to update the UI on the main thread using runOnUiThread or other methods)
        textView.setText(sensorData);
    }

    private void sendDataToServer(String data) {
        new SendDataToServerTask().execute(data);
    }
}
