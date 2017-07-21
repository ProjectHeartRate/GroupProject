package com.example.srmar.groupproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This class presents a user interface with four edit text fields, two for setting high and low
 * desired ranges for steps, and two for doing the same with heart rate. There is an enter
 * button for setting the ranges for each, and a textview for displaying the ranges for each.
 * @author Scott Martell, Jenna McNeil
 */
public class AthleteRangeActivity extends AppCompatActivity{
    int stepRangeLow;
    int stepRangeHigh;
    int hrRangeLow;
    int hrRangeHigh;
    private Athlete person;
    private MyApplicationData appState;
    private EditText stepLow;
    private EditText stepHigh;
    private EditText hrLow;
    private EditText hrHigh;
    private Button stepEnter;
    private Button hrEnter;
    private Button rangeBack;
    private TextView hrSetRange;
    private TextView stepSetRange;

    /**
     * This method creates the athlete range activity ui.
     * @param savedInstanceState not sure what it does.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete_range);
        person = (Athlete)getIntent().getSerializableExtra("Athlete");
        appState = ((MyApplicationData) getApplicationContext());

        stepRangeLow = Integer.parseInt(person.stepLow);
        stepRangeHigh = Integer.parseInt(person.stepHigh);
        hrRangeLow = Integer.parseInt(person.hrLow);
        hrRangeHigh = Integer.parseInt(person.hrHigh);

        //initializing ui elements
        stepLow = (EditText) findViewById(R.id.stepLow);
        stepHigh = (EditText) findViewById(R.id.stepHigh);
        hrLow = (EditText) findViewById(R.id.hrLow);
        hrHigh = (EditText) findViewById(R.id.hrHigh);
        stepEnter = (Button) findViewById(R.id.stepEnter);
        hrEnter = (Button) findViewById(R.id.hrEnter);
        rangeBack = (Button) findViewById(R.id.rangeBack);
        hrSetRange = (TextView) findViewById(R.id.hrSetRange);
        stepSetRange = (TextView) findViewById(R.id.stepSetRange);

        //checks the initial values for stepRangeLow and stepRangeHigh
        if(stepRangeLow > stepRangeHigh){
            stepSetRange.setText("Steps: Invalid range.");
        }
        else if(stepRangeLow == 0 && stepRangeHigh == 0){
            stepSetRange.setText("Steps: No range set.");
        }
        else{
            stepSetRange.setText("Steps: "+stepRangeLow+" to "+stepRangeHigh+".");
        }

        //checks the initial values for hrRangeLow and hrRangeHigh
        if(hrRangeLow > hrRangeHigh){
            hrSetRange.setText("Heart Rate: Invalid range.");
        }
        else if(hrRangeLow == 0 && hrRangeHigh == 0){
            hrSetRange.setText("Heart Rate: No range set.");
        }
        else{
            hrSetRange.setText("Heart Rate: "+hrRangeLow+" to "+hrRangeHigh+".");
        }
    }

    /**
     * On click sets the step ranges or shows that the entered values are invalid.
     * @param view sets the ui.
     */
    public void enterStepRange(View view){
        person.stepLow = stepLow.getText().toString();
        person.stepHigh = stepHigh.getText().toString();
        stepRangeLow = Integer.parseInt(stepLow.getText().toString());
        stepRangeHigh = Integer.parseInt(stepHigh.getText().toString());
        if(stepRangeLow > stepRangeHigh){
            stepSetRange.setText("Steps: Invalid range.");
        }
        else if(stepRangeLow == 0 && stepRangeHigh == 0){
            stepSetRange.setText("Steps: No range set.");
        }
        else{
            stepSetRange.setText("Steps: "+stepRangeLow+" to "+stepRangeHigh+".");
        }
        appState.firebaseReference.child(person.uid).setValue(person);
    }

    /**
     * On click sets the heart rate ranges or lets the user know the range is invalid.
     * @param view sets the ui.
     */
    public void enterHrRange(View view){
        person.hrLow = hrLow.getText().toString();
        person.hrHigh = hrHigh.getText().toString();
        hrRangeLow = Integer.parseInt(hrLow.getText().toString());
        hrRangeHigh = Integer.parseInt(hrHigh.getText().toString());
        if(hrRangeLow > hrRangeHigh){
            hrSetRange.setText("Heart Rate: Invalid range.");
        }
        else if(hrRangeLow == 0 && hrRangeHigh == 0){
            hrSetRange.setText("Heart Rate: No range set.");
        }
        else{
            hrSetRange.setText("Heart Rate: "+hrRangeLow+" to "+hrRangeHigh+".");
        }
        appState.firebaseReference.child(person.uid).setValue(person);
    }

    /**
     * On click opens the Athlete activity ui.
     * @param view sets the ui.
     */
    public void rangeBack(View view){
        Intent athlete = new Intent(this, AthleteActivity.class);
        athlete.putExtra("Athlete", person);
        startActivity(athlete);
    }

    /**
     * Setter for stepRangeLow.
     * @param stepRangeLow low end of range for steps
     */
    public void setStepRangeLow(int stepRangeLow){this.stepRangeLow = stepRangeLow;}

    /**
     * Setter for stepRangeHigh.
     * @param stepRangeHigh high end of range for steps
     */
    public void setStepRangeHigh(int stepRangeHigh){this.stepRangeHigh = stepRangeHigh;}

    /**
     * Setter for hrRangeLow.
     * @param hrRangeLow low end of range for heart rate
     */
    public void setHrRangeLow(int hrRangeLow){this.hrRangeLow = hrRangeLow;}

    /**
     * Setter for hrRangeHigh.
     * @param hrRangeHigh high end of range for heart rate
     */
    public void setHrRangeHigh(int hrRangeHigh){this.hrRangeHigh = hrRangeHigh;}

    /**
     * getter for stepRangeLow.
     * @return stepRangeLow
     */
    public int getStepLow(){
        return stepRangeLow;
    }

    /**
     * getter for stepRangeHigh.
     * @return stepRangeHigh
     */
    public int getStepHigh(){
        return stepRangeHigh;
    }

    /**
     * getter for hrRangeLow.
     * @return hrRangeLow
     */
    public int getHrLow(){
        return hrRangeLow;
    }

    /**
     * getter for hrRangeHigh.
     * @return hrRangeHigh
     */
    public int getHrHigh(){
        return hrRangeHigh;
    }
}
