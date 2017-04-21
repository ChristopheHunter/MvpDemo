package com.quicker.mvpdemo.module.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.quicker.mvpdemo.R;
import com.quicker.mvpdemo.module.test.Circle;
import com.quicker.mvpdemo.module.test.MyCanvas;
import com.quicker.mvpdemo.module.test.Rectangle;
import com.quicker.mvpdemo.module.test.Shape;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        MyCanvas myCanvas = new MyCanvas();
        Circle circle1 = new Circle();
        Circle circle2 = new Circle();
        Circle circle3 = new Circle();
        Rectangle rectangle = new Rectangle();
//        myCanvas.draw(circle);
//        myCanvas.draw(rectangle);

        List<Circle> shapes = new ArrayList<>();
        shapes.add(circle1);
        shapes.add(circle2);
        shapes.add(circle3);
        myCanvas.drawAll(shapes);

        Integer[] array = new Integer[]{1,2,3,4};
        List<Integer> list = new ArrayList<>();

        Collection<?> collection = myCanvas.fromArrayToCollection(array,list);
        for (Object o : collection){
            Integer integer = (Integer) o;
            Log.d("fanxing","_____"+integer);
        }
    }

}
