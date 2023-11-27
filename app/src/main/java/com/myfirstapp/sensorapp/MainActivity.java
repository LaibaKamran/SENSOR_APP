package com.myfirstapp.sensorapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
public class MainActivity extends AppCompatActivity {

    private TextView textViewAccelerometer, textViewGyroscope, textViewMagneticField;
    private SensorManager sensorManager;
    private Sensor accelerometerSensor, gyroscopeSensor, magneticFieldSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewAccelerometer = findViewById(R.id.textViewAccelerometer);
        textViewGyroscope = findViewById(R.id.textViewGyroscope);
        textViewMagneticField = findViewById(R.id.textViewMagneticField);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        magneticFieldSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        SensorListenerManager.registerSensorListeners(
                this,
                sensorManager,
                accelerometerSensor,
                gyroscopeSensor,
                magneticFieldSensor,
                textViewAccelerometer,
                textViewGyroscope,
                textViewMagneticField
        );
    }
}
