package com.example.srmar.groupproject;

/**
 * Created by srmar on 2017-06-08.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wolkabout.hexiwear.R;

public class AthleteRangeActivity extends AppCompatActivity{
    //variables returned for ranges
    int stepRangeLow;
    int stepRangeHigh;
    int hrRangeLow;
    int hrRangeHigh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete_range);
        //initializing ui elements
        final EditText stepLow = (EditText) findViewById(R.id.stepLow);
        final EditText stepHigh = (EditText) findViewById(R.id.stepHigh);
        final EditText hrLow = (EditText) findViewById(R.id.hrLow);
        final EditText hrHigh = (EditText) findViewById(R.id.hrHigh);
        final Button stepEnter = (Button) findViewById(R.id.stepEnter);
        final Button hrEnter = (Button) findViewById(R.id.hrEnter);
        final Button rangeBack = (Button) findViewById(R.id.rangeBack);
        //on click edit text values are set to variables
        stepEnter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                stepRangeLow = Integer.parseInt(stepLow.getText().toString());
                stepRangeHigh = Integer.parseInt(stepHigh.getText().toString());
            }
        });
        hrEnter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                hrRangeLow = Integer.parseInt(hrLow.getText().toString());
                hrRangeHigh = Integer.parseInt(hrHigh.getText().toString());
            }
        });
        rangeBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent athlete = new Intent(view.getContext(), com.example.srmar.groupproject.AthleteActivity.class);
                startActivityForResult(athlete, 0);
            }
        });

    }
    //return range variables
    public int getStepLow(){
        return stepRangeLow;
    }
    public int getStepHigh(){
        return stepRangeHigh;
    }
    public int getHrLow(){
        return hrRangeLow;
    }
    public int getHrHigh(){
        return hrRangeHigh;
    }
}
