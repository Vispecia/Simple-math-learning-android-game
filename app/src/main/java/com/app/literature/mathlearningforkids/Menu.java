package com.app.literature.mathlearningforkids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static com.app.literature.mathlearningforkids.R.array.Operations;
import static com.app.literature.mathlearningforkids.R.array.Timer;


public class Menu extends AppCompatActivity {

    Spinner operations,timer;
    String op,t;
    public void goToGame(View v)
    {
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("operation",op);
        i.putExtra("timer",t);
        startActivity(i);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        operations = findViewById(R.id.operationSpinner);
        timer = findViewById(R.id.timerSpinner);

        ArrayAdapter<CharSequence> opAdapter = ArrayAdapter
                .createFromResource(this, Operations,
                        android.R.layout.simple_spinner_item);
        opAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> timerAdapter = ArrayAdapter
                .createFromResource(this, Timer,
                        android.R.layout.simple_spinner_item);
        timerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        operations.setAdapter(opAdapter);
        timer.setAdapter(timerAdapter);


       operations.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
               switch (position) {
                   case 0:
                       op = "sum";
                       break;
                   case 1:
                       op = "subtract";
                       break;
                   case 2:
                       op = "multiply";
                       break;

               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });

        timer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        t = "30";
                        break;
                    case 1:
                        t = "45";
                        break;
                    case 2:
                        t = "60";
                        break;
                    case 3:
                        t = "90";
                        break;
                    case 4:
                        t = "120";
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }
}
