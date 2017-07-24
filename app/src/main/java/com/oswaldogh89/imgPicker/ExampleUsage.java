package com.oswaldogh89.imgPicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.oswaldogh89.picker.ImagePicker;

import java.util.ArrayList;
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
        picker.enableDelateAll(true);


        //Si vas a cargar imagenes en el control desde una URL
        ArrayList<String> urls = new ArrayList<>();
        urls.add("https://static.independent.co.uk/s3fs-public/styles/article_small/public/thumbnails/image/2017/01/19/15/earth-from-space.jpg");
        urls.add("http://www.slate.com/content/dam/slate/blogs/bad_astronomy/2016/03/09/shutterstock_earthfromhubble.jpg.CROP.original-original.jpg");
        picker.addImagesFromUrl(urls);

        Button btnUpload = (Button) findViewById(R.id.UploadImages);
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<Integer, String> images = picker.GetPathImages();
                for (Map.Entry entry : images.entrySet()) {
                    Log.v("IMAGENES_AGREGADAS", "TAMAÑO : " + entry.getValue());
                }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch (requestCode) {
            case ImagePicker.REQUEST_CAMERA:
                if (resultCode == RESULT_OK) {
                    picker.AddNewImage(imageReturnedIntent);
                }
                break;
            case ImagePicker.REQUEST_GALLERY:
                if (resultCode == RESULT_OK) {
                    picker.AddNewImage(imageReturnedIntent);
                }
                break;
        }
    }
}
