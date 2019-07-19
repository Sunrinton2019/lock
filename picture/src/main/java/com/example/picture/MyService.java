package com.example.picture;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.app.Activity.RESULT_OK;

public class MyService extends Service {

    private float aceVal;
    private float aceLast;
    private float shake;
    private int cnt = 0;

    private String imageFilePath;
    private Uri photoUri;
    private static final int REQUEST_IMAGE_CAPTURE = 672;


    private SensorManager sensorManager;


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
        // sendTakePhotoIntent();


    }

    @Override
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent(MyService.this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
//
//    private void sendTakePhotoIntent() {
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//            File photoFile = null;
//            try {
//                photoFile = createImageFile();
//            } catch (IOException ex) {
//                // Error occurred while creating the File
//            }
//
//            if (photoFile != null) {
//                photoUri = FileProvider.getUriForFile(this, getPackageName(), photoFile);
//                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
//                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//            }
//        }
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
//            Bitmap bitmap = BitmapFactory.decodeFile(imageFilePath);
//            ExifInterface exif = null;
//
//            try {
//                exif = new ExifInterface(imageFilePath);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            int exifOrientation;
//            int exifDegree;
//
//            if (exif != null) {
//                exifOrientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
//                exifDegree = exifOrientationToDegrees(exifOrientation);
//            } else {
//                exifDegree = 0;
//            }
//
//            ((ImageView) findViewById(R.id.photo)).setImageBitmap(rotate(bitmap, exifDegree));
//        }
//    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "TEST_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,      /* prefix */
                ".jpg",         /* suffix */
                storageDir          /* directory */
        );
        imageFilePath = image.getAbsolutePath();
        return image;
    }


//    private final SensorEventListener sensorListener = new SensorEventListener() {
//        @Override
//        public void onSensorChanged(SensorEvent sensorEvent) {
//
//            float x = sensorEvent.values[0];
//            float y = sensorEvent.values[1];
//            float z = sensorEvent.values[2];
//
//            aceLast = aceVal;
//            aceVal = (float) Math.sqrt((double) (x + x + y * y + z * z));
//            float delta = aceVal - aceLast;
//            shake = shake * 0.8f + delta;
//
//            if (shake > 10) {
//                Intent intent = new Intent(MainActivity.this, MyService.class);
//                Log.i("shake count", String.valueOf(shake));
//                startService(intent);
//                cnt++;
//            }
//        }
//
//        @Override
//        public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//        }
//    };
}


//package com.example.myapplication;
//
//        import android.app.Service;
//        import android.content.Intent;
//        import android.hardware.SensorManager;
//        import android.os.IBinder;
//        import android.support.annotation.Nullable;
//
//public class MyService extends Service {
//    private SensorManager sensorManager;
//
//
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        return START_STICKY;
//    }
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        Intent intent = new Intent(MyService.this, Main2Activity.class);
//        startActivity(intent);
//
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//
//    }
//}