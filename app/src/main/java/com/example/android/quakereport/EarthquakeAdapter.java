package com.example.android.quakereport;

import android.widget.ArrayAdapter;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.v4.content.ContextCompat;
import java.util.ArrayList;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;

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
            // Get the version name from the current AndroidFlavor object and
            // set this text on the name TextView
            magnitudeTextView.setText(currentEq.getMagnitude());

            // Find the TextView in the list_item.xml layout with the ID version_number
            TextView placeTextView = (TextView) listItemView.findViewById(R.id.placeTV);
            // Get the version number from the current AndroidFlavor object and
            // set this text on the number TextView
            placeTextView.setText(currentEq.getEqPlace());

            // Find the TextView in the list_item.xml layout with the ID version_number
            TextView dateTextView = (TextView) listItemView.findViewById(R.id.dateTV);
            // Get the version number from the current AndroidFlavor object and
            // set this text on the number TextView
            dateTextView.setText(currentEq.getEqDate());



            // Return the whole list item layout (containing 3 TextViews)
            // so that it can be shown in the ListView
            return listItemView;
        }

}
