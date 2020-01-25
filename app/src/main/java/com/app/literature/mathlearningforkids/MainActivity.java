package com.app.literature.mathlearningforkids;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button0,button1,button2,button3,playAgainButton;
    TextView scoretext,timertext,sumText,resultText,reportCardTotalAttemptText,reportCardTotalCorrectText;
    int correctAnsTag;
    int correctCount=0;
    int totalproblemCount=0;
    ArrayList<String> arrayList;
    String operation=null;
    String timer = null;
    ConstraintLayout reportCardView;

    public void  playAgain(View v)
    {
        reportCardView.setVisibility(View.INVISIBLE);
       // reportCardView.animate().translationY(-5000);
        resultText.setText("");
        scoretext.setText("0 / 0");
        correctCount=0;
        totalproblemCount=0;

        if(operation.equals("sum"))
            newQuestionSum();
        else if(operation.equals("subtract"))
            newQuestionSubtract();
//        else if(operation.equals("divide"))
//            newQuestionSum();
        else if(operation.equals("multiply"))
            newQuestionMultiply();


        playAgainButton.setVisibility(View.INVISIBLE);

        int t = Integer.parseInt(timer)*1000 + 100;

        new CountDownTimer(t,1000)
        {
            @Override
            public void onTick(long l) {
                timertext.setText(Integer.toString((int)l/1000) + "sec");
            }

            @Override
            public void onFinish() {
                resultText.setText("Done!");

                reportCardView.setVisibility(View.VISIBLE);
                reportCardView.setY(2000);
                reportCardView.animate().translationYBy(-1990).setDuration(2000);
                reportCardTotalAttemptText.setText(Integer.toString(totalproblemCount));
                reportCardTotalCorrectText.setText(Integer.toString(correctCount));
               playAgainButton.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    public void CheckAnswer(View v)
    {
        if(Integer.toString(correctAnsTag).equals(v.getTag().toString()))
        {
            resultText.setText("Correct!");


            if(operation.equals("sum"))
                newQuestionSum();
            else if(operation.equals("subtract"))
                newQuestionSubtract();
//        else if(operation.equals("divide"))
//            newQuestionSum();
            else if(operation.equals("multiply"))
                newQuestionMultiply();

            //newQuestionSum();
            correctCount++;

        }
        else
        {
            resultText.setText("Wrong");

            if(operation.equals("sum"))
                newQuestionSum();
            else if(operation.equals("subtract"))
                newQuestionSubtract();
//        else if(operation.equals("divide"))
//            newQuestionSum();
            else if(operation.equals("multiply"))
                newQuestionMultiply();

            //newQuestionSum();
        }
        totalproblemCount++;

        scoretext.setText(correctCount + " / " + totalproblemCount);

    }

    private void newQuestionSum() {
        Random rand = new Random();
        int a = rand.nextInt(50);
        int b = rand.nextInt(50);

        sumText.setText(a + " + " + b);

        correctAnsTag = rand.nextInt(4);
        arrayList = new ArrayList<>();
        for(int i=0;i<4;i++)
        {
            if(i==correctAnsTag)
                arrayList.add(Integer.toString(a+b));
            else {
                int wrongAns = rand.nextInt(50);
                while(wrongAns == a+b)
                    wrongAns =  rand.nextInt(50);
                arrayList.add(Integer.toString(wrongAns));
            }
        }

        button0.setText(arrayList.get(0));
        button1.setText(arrayList.get(1));
        button2.setText(arrayList.get(2));
        button3.setText(arrayList.get(3));
    }

    private void newQuestionMultiply() {
        Random rand = new Random();
        int a = rand.nextInt(20);
        int b = rand.nextInt(20);

        sumText.setText(a + " x " + b);

        correctAnsTag = rand.nextInt(4);
        arrayList = new ArrayList<>();
        for(int i=0;i<4;i++)
        {
            if(i==correctAnsTag)
                arrayList.add(Integer.toString(a*b));
            else {
                int wrongAns = rand.nextInt(400);
                while(wrongAns == a*b)
                    wrongAns = rand.nextInt(400);
                arrayList.add(Integer.toString(wrongAns));
            }
        }

        button0.setText(arrayList.get(0));
        button1.setText(arrayList.get(1));
        button2.setText(arrayList.get(2));
        button3.setText(arrayList.get(3));
    }

    private void newQuestionSubtract() {
        Random rand = new Random();
        int a = rand.nextInt(50);
        int b = rand.nextInt(50);

        sumText.setText(a + " - " + b);

        correctAnsTag = rand.nextInt(4);
        arrayList = new ArrayList<>();
        for(int i=0;i<4;i++)
        {
            if(i==correctAnsTag)
                arrayList.add(Integer.toString(a-b));
            else {
                int wrongAns = rand.nextInt(45);
                while(wrongAns == a-b)
                    wrongAns = rand.nextInt(45);
                arrayList.add(Integer.toString(wrongAns));
            }
        }

        button0.setText(arrayList.get(0));
        button1.setText(arrayList.get(1));
        button2.setText(arrayList.get(2));
        button3.setText(arrayList.get(3));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        playAgainButton = findViewById(R.id.playAgainButton);
        reportCardView = findViewById(R.id.reportCardScene);


        resultText = findViewById(R.id.resultText);
        sumText = findViewById(R.id.sumText);
        timertext = findViewById(R.id.timerText);
        scoretext = findViewById(R.id.scoreText);
        reportCardTotalAttemptText = findViewById(R.id.totalAttemptReportCardText);
        reportCardTotalCorrectText = findViewById(R.id.totalCorrectReportCardText);

        //playAgainButton.setVisibility(View.INVISIBLE);
        reportCardView.setVisibility(View.INVISIBLE);

        operation = getIntent().getStringExtra("operation");
        timer = getIntent().getStringExtra("timer");
        playAgain(scoretext);

    }
}
