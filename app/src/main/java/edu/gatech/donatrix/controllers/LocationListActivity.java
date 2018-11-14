package edu.gatech.donatrix.controllers;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import edu.gatech.donatrix.R;
import edu.gatech.donatrix.dao.LocationDao;
import edu.gatech.donatrix.model.Location;

/**
 * An Activity for Location List
 */
public class LocationListActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {

    @Nullable
    private Location location;

    /**
     * Activity initializer
     *
     * @param savedInstanceState the activity state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);

        Spinner locationSpinner = findViewById(R.id.locationListLocationSpinner);
        locationSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<Location> locationArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, LocationDao.
                getLocations(this).toArray());
        locationArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locationArrayAdapter);
    }

    /**
     * Called when item is selected
     * @param parent the parent of the item
     * @param view the current view
     * @param position position of the item
     * @param id the items id
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        location = (Location) parent.getItemAtPosition(position);
    }

    /**
     * Do nothing
     *
     * @param parent pointless
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        location = null;
    }

    /**
     * Will go back from this screen
     * @param view XML
     */
    public void onBackButtonPressed(View view) {
        finish();
    }

    /**
     * This is select a location to view
     * @param view XML
     */
    public void onChooseButtonPressed(View view) {

        Intent intent = new Intent(LocationListActivity.this, ItemListActivity.class);
        if (location != null) {
            intent.putExtra("location_id", location.getKey());
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(this, "Location is null", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

    }
}
