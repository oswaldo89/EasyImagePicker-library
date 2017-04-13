package com.oswaldogh89.novus_logger;
/**
 * Created by oswaldogh89 on 13/04/17.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;
import rebus.bottomdialog.BottomDialog;

public class NovusPicker extends LinearLayout {

    private CircleImageView im2, im3, im4, im5, im6, im7, im8, im9, im10, im11;
    private BottomDialogMaterial dialog;
    private Activity mainactivity;
    private HashMap<Integer, String> hmap;
    private TextView count;

    public NovusPicker(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);
        inflate(context, R.layout.template, this);

        ImageView addNew = (ImageView) findViewById(R.id.AddNew);
        count = (TextView) findViewById(R.id.CountImg);
        hmap = new HashMap<>();

        dialog = new BottomDialogMaterial(context);
        dialog.title("Seleccionar Imagen");
        dialog.canceledOnTouchOutside(true);
        dialog.cancelable(true);
        dialog.inflateMenu(R.menu.upload_menu);
        dialog.setOnItemSelectedListener(new BottomDialog.OnItemSelectedListener() {
            @Override
            public boolean onItemSelected(int id) {
                if (id == R.id.camera_action) {
                    Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    mainactivity.startActivityForResult(takePicture, 0);
                    return true;
                } else if (id == R.id.gallery_action) {
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    mainactivity.startActivityForResult(pickPhoto, 1);
                    return true;
                } else {
                    return false;
                }
            }
        });

        addNew.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
    }

    public void setMainactivity(Activity mainactivity) {
        this.mainactivity = mainactivity;
    }

    public void SetBorderImageColor(String color) {
        im2 = (CircleImageView) findViewById(R.id.im2);
        im3 = (CircleImageView) findViewById(R.id.im3);
        im4 = (CircleImageView) findViewById(R.id.im4);
        im5 = (CircleImageView) findViewById(R.id.im5);
        im6 = (CircleImageView) findViewById(R.id.im6);
        im7 = (CircleImageView) findViewById(R.id.im7);
        im8 = (CircleImageView) findViewById(R.id.im8);
        im9 = (CircleImageView) findViewById(R.id.im9);
        im10 = (CircleImageView) findViewById(R.id.im10);
        im11 = (CircleImageView) findViewById(R.id.im11);
        im2.setBorderColor(Color.parseColor(color));
        im3.setBorderColor(Color.parseColor(color));
        im4.setBorderColor(Color.parseColor(color));
        im5.setBorderColor(Color.parseColor(color));
        im6.setBorderColor(Color.parseColor(color));
        im7.setBorderColor(Color.parseColor(color));
        im8.setBorderColor(Color.parseColor(color));
        im9.setBorderColor(Color.parseColor(color));
        im10.setBorderColor(Color.parseColor(color));
        im11.setBorderColor(Color.parseColor(color));
    }

    public void AddNewImage(Intent imageReturnedIntent) {
        if (im2.getVisibility() != View.VISIBLE) {
            ChangeVisible(im2, imageReturnedIntent, 0);
        } else if (im3.getVisibility() != View.VISIBLE) {
            ChangeVisible(im3, imageReturnedIntent, 1);
        } else if (im4.getVisibility() != View.VISIBLE) {
            ChangeVisible(im4, imageReturnedIntent, 2);
        } else if (im5.getVisibility() != View.VISIBLE) {
            ChangeVisible(im5, imageReturnedIntent, 3);
        } else if (im6.getVisibility() != View.VISIBLE) {
            ChangeVisible(im6, imageReturnedIntent, 4);
        } else if (im7.getVisibility() != View.VISIBLE) {
            ChangeVisible(im7, imageReturnedIntent, 5);
        } else if (im8.getVisibility() != View.VISIBLE) {
            ChangeVisible(im8, imageReturnedIntent, 6);
        } else if (im9.getVisibility() != View.VISIBLE) {
            ChangeVisible(im9, imageReturnedIntent, 7);
        } else if (im10.getVisibility() != View.VISIBLE) {
            ChangeVisible(im10, imageReturnedIntent, 8);
        } else if (im11.getVisibility() != View.VISIBLE) {
            ChangeVisible(im11, imageReturnedIntent, 9);
        }

        final HorizontalScrollView horizontalScroll = (HorizontalScrollView) findViewById(R.id.horizontalScroll);
        horizontalScroll.postDelayed(new Runnable() {
            public void run() {
                horizontalScroll.fullScroll(HorizontalScrollView.FOCUS_LEFT);
            }
        }, 100L);
    }

    public int getImageCount() {
        return hmap.size();
    }

    private void ChangeVisible(CircleImageView image, Intent imageReturnedIntent, int position) {
        image.setVisibility(View.VISIBLE);
        Glide.with(getContext()).load(imageReturnedIntent.getData()).override(150, 150).into(image);
        hmap.put(position, imageReturnedIntent.getData().getPath());
        count.setText("Imagenes: " + getImageCount());
    }

}
