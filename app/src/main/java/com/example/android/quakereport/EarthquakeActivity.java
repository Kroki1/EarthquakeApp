/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
/*        final ArrayList<Earthquake> earthquakes = new ArrayList<Earthquake>();
        earthquakes.add(new Earthquake("2.1","San Francisco","21st June 2000"));
        earthquakes.add(new Earthquake("8.8","London", "11th Sep 2001"));
        earthquakes.add(new Earthquake("2.5","Tokyo","11th May 1987"));
        earthquakes.add(new Earthquake("8.8","Mexico City","11th May 1987"));
        earthquakes.add(new Earthquake("8.8","Moscow","11th May 1987"));
        earthquakes.add(new Earthquake("8.8","Rio de Janeiro","11th May 1987"));
        earthquakes.add(new Earthquake("8.8","Paris","11th May 1987"));*/

        final ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();
        EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        // Find a reference to the {@link ListView} in the layout
        ListView listView = (ListView) findViewById(R.id.list);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        listView.setAdapter(adapter);
    }
}
