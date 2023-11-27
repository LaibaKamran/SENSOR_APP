package com.myfirstapp.sensorapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;

public class SensorListenerManager {

    public static void registerSensorListeners(
            Context context,
            SensorManager sensorManager,
            Sensor accelerometerSensor,
            Sensor gyroscopeSensor,
            Sensor magneticFieldSensor,
            TextView accelerometerTextView,
            TextView gyroscopeTextView,
            TextView magneticFieldTextView
    ) {
        // Implement the logic to register sensor listeners (similar to your original registerSensorListeners method)
        // You can call the helper method below to register individual listeners
        registerSensorListener(
                context,
                sensorManager,
                accelerometerSensor,
                new SensorEventListenerAdapter(accelerometerTextView, "Accelerometer")
        );
        registerSensorListener(
                context,
                sensorManager,
                gyroscopeSensor,
                new SensorEventListenerAdapter(gyroscopeTextView, "Gyroscope")
        );
        registerSensorListener(
                context,
                sensorManager,
                magneticFieldSensor,
                new SensorEventListenerAdapter(magneticFieldTextView, "Magnetic Field")
        );
    }

    private static void registerSensorListener(
            Context context,
            SensorManager sensorManager,
            Sensor sensor,
            SensorEventListener listener
    ) {
        if (sensor != null) {
            sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            // Handle the case where the sensor is not available
        }
    }
}
