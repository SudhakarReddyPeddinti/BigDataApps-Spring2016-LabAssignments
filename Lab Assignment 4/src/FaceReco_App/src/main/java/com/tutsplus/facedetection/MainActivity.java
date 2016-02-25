package com.tutsplus.facedetection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.InputStream;

/**
 * Created by Sudhakar on 21/2/16.
 */
public class MainActivity extends AppCompatActivity {

    private FaceOverlayView FaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FaceView = (FaceOverlayView) findViewById( R.id.face_overlay );

        InputStream stream = getResources().openRawResource( R.raw.face );
        Bitmap bitmap = BitmapFactory.decodeStream(stream);

        FaceView.setBitmap(bitmap);

    }
}
