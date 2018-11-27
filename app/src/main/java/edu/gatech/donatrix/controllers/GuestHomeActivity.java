package edu.gatech.donatrix.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import edu.gatech.donatrix.R;

public class GuestHomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_guest);
    }

    public void onLocationListPressed(View view) {
        Intent intent = new Intent(view.getContext(), LocationListActivity.class);
        view.getContext().startActivity(intent);
    }
}
