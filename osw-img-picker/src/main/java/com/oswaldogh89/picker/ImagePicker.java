package com.oswaldogh89.picker;
/**
 * Created by oswaldogh89 on 13/04/17.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;
import rebus.bottomdialog.BottomDialog;

public class ImagePicker extends LinearLayout implements View.OnClickListener {

    private final ImagePicker mContext;
    private CircleImageView im2, im3, im4, im5, im6, im7, im8, im9, im10, im11;
    private DialogOptions dialog;
    private Activity mainactivity;
    private Fragment fragment;
    private boolean calledFromFragment = false;
    private HashMap<Integer, String> hmap;
    private TextView count;
    private Button BorrarTodas;

    public final int REQUEST_CAMERA = 8848;
    public final int REQUEST_GALLERY = 8849;

    public ImagePicker(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);
        inflate(context, R.layout.template, this);
        mContext = this;

        ImageView addNew = (ImageView) findViewById(R.id.AddNew);
        BorrarTodas = (Button) findViewById(R.id.BorrarTodas);
        BorrarTodas.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteAllImages();
            }
        });
        count = (TextView) findViewById(R.id.CountImg);
        count.setText(context.getString(R.string.eip_images) + " 0");
        hmap = new HashMap<>();
        initImages();

        dialog = new DialogOptions(context);
        dialog.title(context.getString(R.string.eip_select_image));
        dialog.canceledOnTouchOutside(true);
        dialog.cancelable(true);
        dialog.inflateMenu(R.menu.upload_menu);
        dialog.setOnItemSelectedListener(new BottomDialog.OnItemSelectedListener() {
            @Override
            public boolean onItemSelected(int id) {
                if (id == R.id.camera_action) {
                    Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if(calledFromFragment){
                        fragment.startActivityForResult(takePicture,REQUEST_CAMERA);
                    }else{
                        mainactivity.startActivityForResult(takePicture, REQUEST_CAMERA);
                    }
                    return true;
                } else if (id == R.id.gallery_action) {
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    if(calledFromFragment){
                        fragment.startActivityForResult(pickPhoto, REQUEST_GALLERY);
                    }else{
                        mainactivity.startActivityForResult(pickPhoto, REQUEST_GALLERY);
                    }
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

    public HashMap<Integer, String> GetPathImages() {
        return hmap;
    }

    public void setMainactivity(Activity mainactivity) {
        this.mainactivity = mainactivity;
    }

    public void setFragment(Fragment fragment){
        this.fragment = fragment;
        this.calledFromFragment = true;
    }

    public void SetBorderImageColor(String color) {
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

    private void initImages() {

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

        im2.setOnClickListener(mContext);
        im3.setOnClickListener(mContext);
        im4.setOnClickListener(mContext);
        im5.setOnClickListener(mContext);
        im6.setOnClickListener(mContext);
        im7.setOnClickListener(mContext);
        im8.setOnClickListener(mContext);
        im9.setOnClickListener(mContext);
        im10.setOnClickListener(mContext);
        im11.setOnClickListener(mContext);
    }

    public void AddNewImage(Intent imageReturnedIntent) {
        if (im2.getVisibility() != View.VISIBLE) {
            ChangeVisible(im2, imageReturnedIntent, 2);
        } else if (im3.getVisibility() != View.VISIBLE) {
            ChangeVisible(im3, imageReturnedIntent, 3);
        } else if (im4.getVisibility() != View.VISIBLE) {
            ChangeVisible(im4, imageReturnedIntent, 4);
        } else if (im5.getVisibility() != View.VISIBLE) {
            ChangeVisible(im5, imageReturnedIntent, 5);
        } else if (im6.getVisibility() != View.VISIBLE) {
            ChangeVisible(im6, imageReturnedIntent, 6);
        } else if (im7.getVisibility() != View.VISIBLE) {
            ChangeVisible(im7, imageReturnedIntent, 7);
        } else if (im8.getVisibility() != View.VISIBLE) {
            ChangeVisible(im8, imageReturnedIntent, 8);
        } else if (im9.getVisibility() != View.VISIBLE) {
            ChangeVisible(im9, imageReturnedIntent, 9);
        } else if (im10.getVisibility() != View.VISIBLE) {
            ChangeVisible(im10, imageReturnedIntent, 10);
        } else if (im11.getVisibility() != View.VISIBLE) {
            ChangeVisible(im11, imageReturnedIntent, 11);
        }

        final HorizontalScrollView horizontalScroll = (HorizontalScrollView) findViewById(R.id.horizontalScroll);
        horizontalScroll.postDelayed(new Runnable() {
            public void run() {
                horizontalScroll.fullScroll(HorizontalScrollView.FOCUS_LEFT);
            }
        }, 100L);
    }

    private void EliminarImagen(int ID) {
        HashMap<Integer, String> hmaps = hmap;
        if (ID == R.id.im2) {
            hmap.remove(2);
        } else if (ID == R.id.im3) {
            hmap.remove(3);
        } else if (ID == R.id.im4) {
            hmap.remove(4);
        } else if (ID == R.id.im5) {
            hmap.remove(5);
        } else if (ID == R.id.im6) {
            hmap.remove(6);
        } else if (ID == R.id.im7) {
            hmap.remove(7);
        } else if (ID == R.id.im8) {
            hmap.remove(8);
        } else if (ID == R.id.im9) {
            hmap.remove(9);
        } else if (ID == R.id.im10) {
            hmap.remove(10);
        } else if (ID == R.id.im11) {
            hmap.remove(11);
        }
    }

    private void deleteAllImages() {
        hmap.clear();
        im2.setVisibility(View.GONE);
        im3.setVisibility(View.GONE);
        im4.setVisibility(View.GONE);
        im5.setVisibility(View.GONE);
        im6.setVisibility(View.GONE);
        im7.setVisibility(View.GONE);
        im8.setVisibility(View.GONE);
        im9.setVisibility(View.GONE);
        im10.setVisibility(View.GONE);
        im11.setVisibility(View.GONE);
        count.setText(mainactivity.getString(R.string.eip_images) + " " + getImageCount() + "/10");
    }

    private String AbrirImagen(int ID) {
        if (ID == R.id.im2) {
            return hmap.get(2);
        } else if (ID == R.id.im3) {
            return hmap.get(3);
        } else if (ID == R.id.im4) {
            return hmap.get(4);
        } else if (ID == R.id.im5) {
            return hmap.get(5);
        } else if (ID == R.id.im6) {
            return hmap.get(6);
        } else if (ID == R.id.im7) {
            return hmap.get(7);
        } else if (ID == R.id.im8) {
            return hmap.get(8);
        } else if (ID == R.id.im9) {
            return hmap.get(9);
        } else if (ID == R.id.im10) {
            return hmap.get(10);
        } else if (ID == R.id.im11) {
            return hmap.get(11);
        }

        return null;
    }

    public int getImageCount() {
        return hmap.size();
    }

    public void enableDelateAll(Boolean enble) {
        if (enble)
            BorrarTodas.setVisibility(View.VISIBLE);
    }

    private void ChangeVisible(CircleImageView image, Intent imageReturnedIntent, int position) {
        Uri path = imageReturnedIntent.getData();
        image.setVisibility(View.VISIBLE);
        Glide.with(getContext()).load(path).override(150, 150).into(image);
        hmap.put(position, path.getPath());
        count.setText(mainactivity.getString(R.string.eip_images) + " " + getImageCount() + "/10");
    }

    private void ChangeVisibleFromUrl(CircleImageView image, String url, int position) {
        image.setVisibility(View.VISIBLE);
        Glide.with(getContext()).load(url).centerCrop().into(image);
        hmap.put(position, url);
        count.setText(mainactivity.getString(R.string.eip_images) + " " + getImageCount() + "/10");
    }

    public void addImagesFromUrl(ArrayList<String> urls) {
        for (int i = 0; i < urls.size(); i++) {
            if (i == 0) {
                ChangeVisibleFromUrl(im2, urls.get(i), 2);
            } else if (i == 1) {
                ChangeVisibleFromUrl(im3, urls.get(i), 3);
            } else if (i == 2) {
                ChangeVisibleFromUrl(im4, urls.get(i), 4);
            } else if (i == 3) {
                ChangeVisibleFromUrl(im5, urls.get(i), 5);
            } else if (i == 4) {
                ChangeVisibleFromUrl(im6, urls.get(i), 6);
            } else if (i == 5) {
                ChangeVisibleFromUrl(im7, urls.get(i), 7);
            } else if (i == 6) {
                ChangeVisibleFromUrl(im8, urls.get(i), 8);
            } else if (i == 7) {
                ChangeVisibleFromUrl(im9, urls.get(i), 9);
            } else if (i == 8) {
                ChangeVisibleFromUrl(im10, urls.get(i), 10);
            } else if (i == 9) {
                ChangeVisibleFromUrl(im11, urls.get(i), 11);
            }
        }

    }

    @Override
    public void onClick(final View view) {
        final int ID = view.getId();
        DialogOptions dialog2 = new DialogOptions(getContext());
        dialog2.title(mainactivity.getString(R.string.eip_image_options));
        dialog2.canceledOnTouchOutside(true);
        dialog2.cancelable(true);
        dialog2.inflateMenu(R.menu.options_menu);
        dialog2.setOnItemSelectedListener(new BottomDialog.OnItemSelectedListener() {
            @Override
            public boolean onItemSelected(int id) {
                if (id == R.id.delete_action) {
                    view.setVisibility(View.GONE);
                    EliminarImagen(ID);
                    count.setText(mainactivity.getString(R.string.eip_images) + " " + getImageCount() + "/10");
                    return true;
                } else if (id == R.id.see_action) {
                    String val = AbrirImagen(ID);
                    mainactivity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/" + val)));
                    return true;
                } else {
                    return false;
                }
            }
        });
        dialog2.show();
    }
}
