package com.example.android.quakereport;

public class Earthquake {

    /** Magnitude of the Eq */
    private double mMagnitude;

    /** Place of the Eq */
    private String mPlace;

    /** Date of the Eq */
    private long mDate;


    public Earthquake(double mag, String eqLocation, long timing) {
        mMagnitude = mag;
        mPlace = eqLocation;
        mDate = timing;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getEqPlace() {
        return mPlace;
    }

    public long getEqDate() {
        return mDate;
    }

}