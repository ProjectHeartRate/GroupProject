package com.example.srmar.groupproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * This class, currently does nothing but open an empty screen. Eventually it will be show
 * the user interface for the coach.
 * @author Scott Martell, Jenna McNeil
 */
public class CoachActivity extends AppCompatActivity {
    /**
     * This method creates the coach activity user interface.
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach);
    }
}
