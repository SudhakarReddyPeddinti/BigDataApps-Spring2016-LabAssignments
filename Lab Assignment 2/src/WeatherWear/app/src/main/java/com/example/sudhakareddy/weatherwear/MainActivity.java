package com.example.sudhakareddy.weatherwear;

import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final JSONObject json = RemoteFetch.getJSON(getActivity());
        currentTemperatureField = (TextView)rootView.findViewById(R.id.WEATHER);

                if(json == null){

                            Toast.makeText(getActivity(),
                                    getActivity().getString(R.string.place_not_found),
                                    Toast.LENGTH_LONG).show();

                } else {

                            renderWeather(json);

                    }

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Notification notification = new NotificationCompat.Builder(getApplication())
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Weather Status:")
                        .setContentText("Sunny ")
                        .extend(
                                new NotificationCompat.WearableExtender().setHintShowBackgroundOnly(true))
                        .build();
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplication());
                int notificationId = 1;
                notificationManager.notify(notificationId, notification);

            }

            private void renderWeather(JSONObject json) {
                try {

                    currentTemperatureField.setText(
                            String.format("%.2f", main.getDouble("temp")) + " ℃");


                    updatedField.setText("Last update: " + updatedOn);


                } catch (Exception e) {
                    Log.e("SimpleWeather", "One or more fields not found in the JSON data");
                }
            }
        }
