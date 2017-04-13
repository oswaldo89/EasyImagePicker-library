package com.oswaldogh89.novuslibraries;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.oswaldogh89.novus_logger.NovusPicker;

public class MainActivity extends AppCompatActivity {
    private NovusPicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        picker = (NovusPicker) findViewById(R.id.picker);
        picker.setMainactivity(MainActivity.this);
        picker.SetBorderImageColor("#075e55");
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
