package com.example.robot_agv;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.Toast;



public class ControlActivity extends AppCompatActivity {

    private String IP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        IP=getIntent().getStringExtra("IP");

        ImageButton options=findViewById(R.id.imageButton_options);
        TableLayout table_gears=findViewById(R.id.table_gears);
        TableLayout table_arrows=findViewById(R.id.table_arrows);
        FrameLayout table_options=findViewById(R.id.table_options);
        ImageButton exit=findViewById(R.id.imageButton_EXIT);
        ImageButton back=findViewById(R.id.imageButton_Back);
        ProgressBar loading=findViewById(R.id.progressBar);
        ImageButton arrow_up=findViewById(R.id.imageButton_up);
        ImageButton arrow_down=findViewById(R.id.imageButton_down);
        ImageButton arrow_right=findViewById(R.id.imageButton_right);
        ImageButton arrow_left=findViewById(R.id.imageButton_left);
        ImageButton button_plus=findViewById(R.id.imageButton_plus);
        ImageButton button_minus=findViewById(R.id.imageButton_minus);



        options.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Do something in response to button click
                if (table_gears.getVisibility()==View.VISIBLE && table_arrows.getVisibility()==View.VISIBLE)
                {
                    table_gears.setVisibility(View.GONE);
                    table_arrows.setVisibility(View.GONE);
                    table_options.setVisibility(View.VISIBLE);
                    loading.setVisibility(View.GONE);
                }
                else
                    {
                        table_gears.setVisibility(View.VISIBLE);
                        table_arrows.setVisibility(View.VISIBLE);
                        loading.setVisibility(View.VISIBLE);
                        table_options.setVisibility(View.GONE);
                    }
            }
        });

            exit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    // Do something in response to button click
                    finishAffinity();
                }
            });



            back.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    // Do something in response to button click
                    finish();
                }
            });

        button_plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Do something in response to button click
                new UDP_Client(IP, "+").start();
            }
        });

        button_minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Do something in response to button click
                new UDP_Client(IP, "-").start();
            }
        });




        arrow_up.setOnTouchListener((View view, MotionEvent event)->
        {
            super.onTouchEvent(event);
                switch (event.getAction()) {
                    case (MotionEvent.ACTION_DOWN ):
                        arrow_up.setPressed(true);
                        new UDP_Client(IP, "w").start();
                        break;
                    case ( MotionEvent.ACTION_UP):
                        arrow_up.setPressed(false);
                        new UDP_Client(IP, "k").start();
                        break;
                    default:
                        break;
                }
                return true;
        });

        arrow_down.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent event)
            {
                switch (event.getAction()) {
                    case (MotionEvent.ACTION_DOWN ):
                        new UDP_Client(IP, "s").start();
                        break;
                    case ( MotionEvent.ACTION_UP):
                        new UDP_Client(IP, "k").start();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });


        arrow_right.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent event)
            {
                switch (event.getAction()) {
                    case (MotionEvent.ACTION_DOWN ):
                        new UDP_Client(IP, "d").start();
                        break;
                    case ( MotionEvent.ACTION_UP):
                        new UDP_Client(IP, "k").start();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });


        arrow_left.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent event)
            {
                switch (event.getAction()) {
                    case (MotionEvent.ACTION_DOWN ):
                        new UDP_Client(IP, "a").start();
                        break;
                    case ( MotionEvent.ACTION_UP):
                        new UDP_Client(IP, "k").start();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

    }

}

