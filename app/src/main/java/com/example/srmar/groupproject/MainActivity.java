package com.example.srmar.groupproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

/**
 * This class presents an interface with two buttons, Coach and Athlete, which opens the UI
 * for the coach or the athlete, respectively.
 * @author Scott Martell, Jenna McNeil
 */
public class MainActivity extends AppCompatActivity {

    private FirebaseListAdapter<Athlete> firebaseAdapter;
    private Button coachButton;
    private Button athleteButton;
    private Athlete person;

    /**
     * This method creates the main activity user interface.
     * @param savedInstanceState not sure what it does.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the app wide shared variables
        MyApplicationData appData = (MyApplicationData)getApplication();

        //Set-up Firebase
        appData.firebaseDBInstance = FirebaseDatabase.getInstance();
        appData.firebaseReference = appData.firebaseDBInstance.getReference("athletes");

        //initializing ui elements
        coachButton = (Button) findViewById(R.id.coach);
        athleteButton = (Button) findViewById(R.id.athlete);

        //takes athlete from firebase for application user
        Query q = appData.firebaseReference.limitToFirst(1);
        q.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                DataSnapshot d = dataSnapshot;
                person = d.getValue(Athlete.class);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }

    /**
     * On click opens CoachActivity ui.
     * @param view sets the ui.
     */
    public void showCoachActivity(View view){
        Intent coachScreen = new Intent(this, CoachActivity.class);
        startActivity(coachScreen);
    }

    /**
     * On click opens AthleteActivity ui.
     * @param view sets the ui.
     */
    public void showAthleteActivity(View view){
        Intent athleteScreen = new Intent(this, AthleteActivity.class);
        athleteScreen.putExtra("Athlete", person);
        startActivity(athleteScreen);
    }
}
