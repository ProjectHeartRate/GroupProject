package com.example.srmar.groupproject;

import android.app.Application;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * This class contains code required for firbase.
 * @author Scott Martell, Jenna McNeil
 */
public class MyApplicationData extends Application{
    public DatabaseReference firebaseReference;
    public FirebaseDatabase firebaseDBInstance;
}
