package com.example.srmar.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class displays the interface for creating a new athlete.
 * @author Scott Martell, Jenna McNeil.
 */
public class CreateAthleteActivity extends AppCompatActivity{

    private EditText athleteName;
    private Button submitButton;
    private MyApplicationData appState;

    /**
     * Creates ui for creating athlete.
     * @param savedInstanceState not sure what it does.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_athlete);

        appState = ((MyApplicationData) getApplicationContext());

        athleteName = (EditText) findViewById(R.id.athleteName);
        submitButton = (Button) findViewById(R.id.submitButton);
    }


    /**
     * On click creates the athlete and goes back to the previous screen.
     * @param view sets the ui.
     */
    public void submitInfoButton(View view){
        String personID = appState.firebaseReference.push().getKey();
        String name = athleteName.getText().toString();
        Athlete person = new Athlete(personID, name);
        appState.firebaseReference.child(personID).setValue(person);

        finish();
    }
}
