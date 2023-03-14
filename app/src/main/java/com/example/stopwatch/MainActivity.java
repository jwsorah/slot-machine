package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //TextView timeView;
    //TextView timeView2;
    //TextView timeView3;
    Button button;
    Button button2;
    CountEvent event;
    CountEvent2 event2;
    CountEvent3 event3;
    Handler handler;
    int time;
    int time2;
    int time3;

    int speed;
    int speed2;
    int speed3;
    Drawable cherry;
    Drawable grape;
    Drawable pear;
    Drawable strawberry;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //timeView = findViewById(R.id.timeView);
        //timeView2 = findViewById(R.id.timeView2);
        //timeView3 = findViewById(R.id.timeView3);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        cherry = getDrawable(R.drawable.cherry);
        grape = getDrawable(R.drawable.grape);
        pear = getDrawable(R.drawable.pear);
        strawberry = getDrawable(R.drawable.strawberry);



        time = 0;
        time2 = 0;
        time3 = 0;
        speed = 100;
        speed2 = 125;
        speed3 = 150;

        event = new CountEvent();
        event2 = new CountEvent2();
        event3 = new CountEvent3();
        handler = new Handler();

        if(savedInstanceState != null) {
            time = savedInstanceState.getInt("time");
            //timeView.setText(time + "");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (button.getText().equals("Start")) {

                    handler.postDelayed(event, speed);
                    handler.postDelayed(event2, speed2);
                    handler.postDelayed(event3, speed3);
                    button.setText("Stop");

                } else {

                    if(time == time2 && time2 == time3){

                        Toast t = Toast.makeText(getApplicationContext(), "Big Win!", Toast.LENGTH_SHORT);
                        t.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        t.show();

                    }

                    handler.removeCallbacks(event);
                    handler.removeCallbacks(event2);
                    handler.removeCallbacks(event3);
                    button.setText("Start");


                }

            }

        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                handler.removeCallbacks(event);
                time = 0;
                imageView2.setImageDrawable(cherry);
                //timeView.setText(time + "");
                handler.removeCallbacks(event2);
                time2 = 0;
                imageView3.setImageDrawable(cherry);
                //timeView2.setText(time2 + "");
                handler.removeCallbacks(event3);
                time3 = 0;
                imageView4.setImageDrawable(cherry);
                //timeView3.setText(time3 + "");


            }
        });



    }

    private class CountEvent implements Runnable {

        @Override
        public void run() {

            time++;
            if (time == 4){
                time = 0;
            }

            if(time == 0){
                imageView2.setImageDrawable(cherry);
            }else if(time == 1){
                imageView2.setImageDrawable(grape);
            }else if(time == 2){
                imageView2.setImageDrawable(pear);
            }else if(time == 3){
                imageView2.setImageDrawable(strawberry);
            }



            //timeView.setText(time + "");
            handler.postDelayed(event, speed);

        }

    }

    private class CountEvent2 implements Runnable {

        @Override
        public void run(){

            time2++;
            if(time2 == 4){
                time2 = 0;
            }

            if(time2 == 0){
                imageView3.setImageDrawable(cherry);
            }else if(time2 == 1){
                imageView3.setImageDrawable(grape);
            }else if(time2 == 2){
                imageView3.setImageDrawable(pear);
            }else if(time2 == 3){
                imageView3.setImageDrawable(strawberry);
            }

            //timeView2.setText(time2 + "");
            handler.postDelayed(event2, speed2);

        }

    }

    private class CountEvent3 implements Runnable {

        @Override
        public void run(){

            time3++;
            if(time3 == 4){
                time3 = 0;
            }
            if(time3 == 0){
                imageView4.setImageDrawable(cherry);
            }else if(time3 == 1){
                imageView4.setImageDrawable(grape);
            }else if(time3 == 2){
                imageView4.setImageDrawable(pear);
            }else if(time3 == 3){
                imageView4.setImageDrawable(strawberry);
            }

            //timeView3.setText(time3 + "");
            handler.postDelayed(event3, speed3);

        }


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){

        savedInstanceState.putInt("time", time);
        super.onSaveInstanceState(savedInstanceState);

    }

}