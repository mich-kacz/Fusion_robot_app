package com.example.robot_agv;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TableLayout;



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
        ImageButton arrow_up=findViewById(R.id.imageButton_up);
        ImageButton arrow_down=findViewById(R.id.imageButton_down);
        ImageButton arrow_right=findViewById(R.id.imageButton_right);
        ImageButton arrow_left=findViewById(R.id.imageButton_left);
        ImageButton button_plus=findViewById(R.id.imageButton_plus);
        ImageButton button_minus=findViewById(R.id.imageButton_minus);
        WebView browser=findViewById(R.id.webview_stream);



        options.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Do something in response to button click
                if (table_gears.getVisibility()==View.VISIBLE && table_arrows.getVisibility()==View.VISIBLE)
                {
                    table_gears.setVisibility(View.GONE);
                    table_arrows.setVisibility(View.GONE);
                    table_options.setVisibility(View.VISIBLE);

                }
                else
                    {
                        table_gears.setVisibility(View.VISIBLE);
                        table_arrows.setVisibility(View.VISIBLE);
                        table_options.setVisibility(View.GONE);
                    }
            }
        });

            exit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    // Do something in response to button click
                    new UDP_Client(IP, "010", 5006).start();
                    new UDP_Client(IP, "q").start();
                    new UDP_Client(IP, "000", 5006).start();
                    finishAffinity();
                }
            });



            back.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    // Do something in response to button click
                    new UDP_Client(IP, "010", 5006).start();
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


            browser.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            browser.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
            browser.loadUrl("http://"+IP+":5000/video_feed");




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
                        arrow_down.setPressed(true);
                        new UDP_Client(IP, "s").start();
                        break;
                    case ( MotionEvent.ACTION_UP):
                        arrow_down.setPressed(false);
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
                        arrow_right.setPressed(true);
                        new UDP_Client(IP, "d").start();
                        break;
                    case ( MotionEvent.ACTION_UP):
                        arrow_right.setPressed(false);
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
                        arrow_left.setPressed(true);
                        new UDP_Client(IP, "a").start();
                        break;
                    case ( MotionEvent.ACTION_UP):
                        arrow_left.setPressed(false);
                        new UDP_Client(IP, "k").start();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        //new Worker().start();


    }

    /*private class Worker extends Thread {
        WebView browser=findViewById(R.id.webview_stream);

        @Override
        public void run() {

           this.browser.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
           //this.browser.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
           //this.browser.loadUrl("http://192.168.50.63:5000/video_feed");
            System.out.println("Glupia JAVA");
        }
        }*/

}

