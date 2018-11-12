package edu.gatech.donatrix.model;

import java.sql.Timestamp;

import android.content.Context;


public class LocationEmployee extends User {
    private Location location;

    public LocationEmployee(String email, String password, String name, Location location) {
        super(email, password, name, false, UserType.LOCATION_EMPLOYEE);
        this.location = location;
    }


    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void addItem(Timestamp time, String sDescription, String fDescription,
                        double value, ItemCategory category, String comments, Context context) {
        Item item = new Item(time, this.location, sDescription, fDescription,
                value, category, comments);
        location.addItem(item, context, this);
    }
}