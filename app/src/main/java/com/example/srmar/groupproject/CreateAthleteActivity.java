package com.example.srmar.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.sql.DatabaseMetaData;

/**
 * This class displays the interface for creating a new athlete.
 * @author Scott Martell, Jenna McNeil.
 */
public class CreateAthleteActivity extends AppCompatActivity{

    private EditText athleteName;
    private Button submitButton;
    private Button deleteButton;
    private MyApplicationData appState;
    Random rand = new Random();

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
        deleteButton = (Button) findViewById(R.id.deleteButton);

    }


    /**
     * On click creates the athlete and goes back to the previous screen.
     * @param view sets the ui.
     */
    public void submitInfoButton(View view){
        String personID = appState.firebaseReference.push().getKey();
        String name = athleteName.getText().toString();
        int randSteps = rand.nextInt(39500) + 500;
        String steps = Integer.toString(randSteps);
        int randHr = rand.nextInt(100) + 50;
        String heartRate = Integer.toString(randHr);
        int setStepHigh = 0;
        String stepsHigh = Integer.toString(setStepHigh);
        int setStepLow = 0;
        String stepsLow = Integer.toString(setStepLow);
        int setHrHigh = 0;
        String hrHigh = Integer.toString(setHrHigh);
        int setHrLow = 0;
        String hrLow = Integer.toString(setHrLow);

        Athlete person = new Athlete(personID, name, steps, heartRate, stepsHigh, stepsLow, hrHigh, hrLow);
        appState.firebaseReference.child(personID).setValue(person);

        finish();
    }
    
    public void deleteAthlete(View view){
        String name = athleteName.getText().toString();
        Query q = appState.firebaseReference.orderByChild("name").equalTo(name);
        q.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                DataSnapshot d = dataSnapshot;
                appState.firebaseReference.child(d.getKey()).removeValue();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
            finish();
    }
}
