package com.example.robot_agv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class ConnectActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);




        // Do something in response to button click Back
        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Do something in response to button click
                finish();
            }
        });


        // Do something in response to button click Back
        Button button_next = (Button) findViewById(R.id.button_next);
        button_next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Do something in response to button click
                String IP = "";
                TextInputEditText textinput_IP=findViewById(R.id.textInput_IP);
                IP=textinput_IP.getText().toString();

                if(IP.length()==0 || IP.indexOf(".")==-1)
                {
                    textinput_IP.setBackgroundColor(Color.RED);
                    textinput_IP.setHint("Uncorrect form of IP address");
                    return;
                }

                textinput_IP.setHint(IP);

                Intent intent = new Intent(ConnectActivity.this, ControlActivity.class);
                intent.putExtra("IP",IP);
                startActivity(intent);

            }
        });


    }
}