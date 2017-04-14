package com.oswaldogh89.imgPicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.oswaldogh89.picker.ImagePicker;

import java.util.HashMap;
import java.util.Map;

public class ExampleUsage extends AppCompatActivity {
    private ImagePicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        picker = (ImagePicker) findViewById(R.id.picker);
        picker.setMainactivity(ExampleUsage.this);
        picker.SetBorderImageColor("#075e55");


        Button btnUpload = (Button) findViewById(R.id.UploadImages);
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<Integer, String> images = picker.GetPathImages();


                for(Map.Entry entry: images.entrySet()){
                    Log.v("IMAGENES_AGREGADAS", "TAMAÑO : " + entry.getValue());
                }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch (requestCode) {
            case 0:
                if (resultCode == RESULT_OK) {
                    picker.AddNewImage(imageReturnedIntent);
                }
                break;
            case 1:
                if (resultCode == RESULT_OK) {
                    picker.AddNewImage(imageReturnedIntent);
                }
                break;
        }
    }
}
