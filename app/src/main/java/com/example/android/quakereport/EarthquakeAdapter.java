package com.example.android.quakereport;

import android.widget.ArrayAdapter;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.v4.content.ContextCompat;

import java.text.DateFormat;
import java.util.ArrayList;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {



    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context,0,earthquakes);

    }

    @Nullable
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //   return super.getView(position, convertView, parent);

        // Get the {@link AndroidFlavor} object located at this position in the list
        Earthquake currentEq = getItem(position);

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magTV);


        // Get the version name from the current AndroidFlavor object and format it with one decimal place i.e 0.0
        // set this text on the name TextView
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(currentEq.getMagnitude());
        magnitudeTextView.setText(output);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView primaryLocationTextView = (TextView) listItemView.findViewById(R.id.placePrimaryTV);
        TextView secondaryLocationTextView = (TextView) listItemView.findViewById(R.id.placeSecondaryTV);

        int StrLenght = currentEq.getEqPlace().length();
        int isSecondaryLocationGiven = currentEq.getEqPlace().indexOf("of",0);

        String secondaryText;
        String primaryText;

        if (isSecondaryLocationGiven == -1) {
            secondaryText = "Near the";
            primaryText = currentEq.getEqPlace();
        } else {
            secondaryText = currentEq.getEqPlace().substring(0,(isSecondaryLocationGiven+2));
            primaryText = currentEq.getEqPlace().substring((isSecondaryLocationGiven+3));
            }

        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        primaryLocationTextView.setText(primaryText);
        secondaryLocationTextView.setText(secondaryText);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.dateTV);
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.timeTV);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        Date dateObj = new Date (currentEq.getEqDate());
        SimpleDateFormat niceFormatDate = new SimpleDateFormat("DD MMM yyyy,");
        SimpleDateFormat niceFormatTime = new SimpleDateFormat("HH:mm");
        String dateToDisplay = niceFormatDate.format(dateObj);
        String timeToDisplay = niceFormatTime.format(dateObj);
        dateTextView.setText(dateToDisplay);
        timeTextView.setText(timeToDisplay);


        // Return the whole list item layout (containing 3 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }

}