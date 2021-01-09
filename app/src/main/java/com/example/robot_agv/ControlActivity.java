package com.example.robot_agv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;

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


    }
}