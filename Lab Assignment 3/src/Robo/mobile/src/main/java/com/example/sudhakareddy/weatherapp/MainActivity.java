package com.example.sudhakareddy.weatherapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat;
import android.app.Notification;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener, LocationListener {
    SensorManager sm;
    Sensor mAcc;
    Sensor mLight;
    Sensor mProximity;
    Sensor mMagnetic;
    TextView proxText, proxText1;
    private final int REQ_CODE_CAMERA=200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mLight = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        mProximity = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        sm.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button mButton = (Button) findViewById(R.id.button);
        proxText=(TextView)findViewById(R.id.proximityText);
        proxText1=(TextView)findViewById(R.id.proximityText1);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Notification notification = new NotificationCompat.Builder(getApplication())
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("ROBO STATUS:")
                        .setContentText("MOVING")
                        .extend(
                                new NotificationCompat.WearableExtender().setHintShowBackgroundOnly(true))
                        .build();
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplication());
                int notificationId = 1;
                notificationManager.notify(notificationId, notification);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        proxText1.setText(String.valueOf(event.values[0]));
    if(event.values[0]>5.0){
        proxText.setText("STOPPED, CHANGING DIRECTION");
        Notification notification = new NotificationCompat.Builder(getApplication())
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("ROBO STATUS:")
                .setContentText("STOPPED")
                .extend(
                        new NotificationCompat.WearableExtender().setHintShowBackgroundOnly(true))
                .build();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplication());
        int notificationId = 1;
        notificationManager.notify(notificationId, notification);
    }
else {
        proxText.setText("MOVING");
        Notification notification = new NotificationCompat.Builder(getApplication())
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("ROBO STATUS:")
                .setContentText("MOVING")
                .extend(
                        new NotificationCompat.WearableExtender().setHintShowBackgroundOnly(true))
                .build();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplication());
        int notificationId = 1;
        notificationManager.notify(notificationId, notification);
    }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
