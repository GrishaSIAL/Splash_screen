package com.example.splash;

import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ListActivity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int numberOfCircles = 3;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Integer[] colors = initColors(numberOfCircles);
        CustomListAdapter adapter = new CustomListAdapter(this, colors);
        list = (ListView) findViewById(android.R.id.list);
        list.setAdapter(adapter);
    }

    private Integer[] initColors(int number) {
        List<Integer> colors = new ArrayList<>();
        int[] colorsSet = {
                Color.RED,
//                Color.parseColor("#FFFFBB33"),
                Color.YELLOW,
                Color.GREEN,
//                Color.parseColor("#87ceeb"),
//                Color.parseColor("#00008b"),
//                Color.parseColor("#FFAA66CC")

        };
        for (int i = 0; i < number; i++) {
            int id = number % colorsSet.length;
            colors.add(colorsSet[i]);
        }

        Integer[] array = new Integer[colors.size()];
        colors.toArray(array);
        System.out.print(array);
        return array;
    }
}
