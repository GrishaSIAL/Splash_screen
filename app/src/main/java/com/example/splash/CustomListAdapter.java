package com.example.splash;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final Integer[] imgid;

    public CustomListAdapter(Activity context, Integer[] imgid) {
        super(context, R.layout.list, new String[imgid.length]);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.imgid = imgid;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        txtTitle.setText("Element № " + Integer.toString(position + 1));
        System.out.println(imgid[position]);
        setCyrcle(imageView, imgid[position]);

        return rowView;

    }

    private void setCyrcle(ImageView imageView, Integer color) {
        int imageWidth = 96;
        int imageHeight = 96;
        Bitmap bitMap = Bitmap.createBitmap(imageWidth, imageHeight, Bitmap.Config.ARGB_8888);  //creates bmp
        bitMap = bitMap.copy(bitMap.getConfig(), true);     //lets bmp to be mutable
        Canvas canvas = new Canvas(bitMap);                 //draw a canvas in defined bmp

        Paint paint = new Paint();                          //define paint and paint color
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(0.5f);
        paint.setAntiAlias(true);                           //smooth edges


        imageView.setImageBitmap(bitMap);

        int radius = Math.min(imageWidth, imageHeight);
        canvas.drawCircle(imageWidth / 2, imageHeight / 2, radius / 2, paint);
        imageView.invalidate();
    }
}