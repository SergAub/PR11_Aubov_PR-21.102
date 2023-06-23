package com.example.pr11_aubov_pr_21102;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            getSupportActionBar().hide();
        }
        catch(NullPointerException e){}

        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public boolean Started = false;
    public boolean Finished = false;

    public void onclick_start(View v) {
        Button button = (Button)findViewById(R.id.start);
        if(!Finished){
            if(!Started){
                button.setBackgroundColor(Color.RED);
                button.setText("Пауза");
                Started = true;
            }
            else if(Started){
                button.setBackgroundColor(Color.GREEN);
                button.setText("Пауза");
                Started = false;
            }
        }
        else{
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void onclick_red(View view) {
        Button button = (Button)findViewById(R.id.redpedal);
        View Car = (View)findViewById(R.id.redcar);
        TextView result = (TextView)findViewById(R.id.textView);
        if(Started && !Finished){
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)Car.getLayoutParams();
            margin.leftMargin += Math.random() * 20 + 20;
            margin.rightMargin -= 40;
            Car.requestLayout();
            if(margin.rightMargin <= -100){
                result.setText("Победа 1 игрока");
                button.setText("Заново");
                result.setTextColor(0xffe91E63);
                Finished = true;
            }
        }
    }

    public void onclick_grey(View view) {
        Button button = (Button)findViewById(R.id.greypedal);
        View Car = (View)findViewById(R.id.greycar);
        TextView result = (TextView)findViewById(R.id.textView);
        if(Started && !Finished) {
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams) Car.getLayoutParams();
            margin.leftMargin += 40;
            margin.rightMargin -= 40;
            Car.requestLayout();
            if (margin.rightMargin <= -100) {
                result.setText("Победа 2 игрока");
                button.setText("Заново");
                result.setTextColor(0xff00000);
                Finished = true;
            }
        }
    }
}
