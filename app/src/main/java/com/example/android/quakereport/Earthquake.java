package com.example.android.quakereport;

public class Earthquake {

    /** Magnitude of the Eq */
    private String mMagnitude;

    /** Place of the Eq */
    private String mPlace;

    /** Date of the Eq */
    private String mDate;


    public Earthquake(String mag, String eqLocation, String timing) {
        mMagnitude = mag;
        mPlace = eqLocation;
        mDate = timing;
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getEqPlace() {
        return mPlace;
    }

    public String getEqDate() {
        return mDate;
    }

}
