package com.example.android.quakereport;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.graphics.drawable.GradientDrawable;

import java.util.ArrayList;

/**
 * Created by hamonteroa on 8/17/16.
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent,false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        Double magnitude = currentEarthquake.getMagnitude();
        magnitudeTextView.setText(new DecimalFormat("0.0").format(magnitude));

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(getMagnitudeColor(magnitude));


        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        locationTextView.setText(currentEarthquake.getLocation());

        TextView distanceTextView = (TextView) listItemView.findViewById(R.id.distance);
        distanceTextView.setText(currentEarthquake.getDistance());

        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        dateTextView.setText(formatDate(dateObject));

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        timeTextView.setText(formatTime(dateObject));

        return listItemView;
    }

    private int getMagnitudeColor(Double magnitude) {

        if (magnitude < 2) {
            return ContextCompat.getColor(getContext(), R.color.magnitude1);
        } else if (magnitude < 3) {
            return ContextCompat.getColor(getContext(), R.color.magnitude2);
        } else if (magnitude < 4) {
            return ContextCompat.getColor(getContext(), R.color.magnitude3);
        } else if (magnitude < 5) {
            return ContextCompat.getColor(getContext(), R.color.magnitude4);
        } else if (magnitude < 6) {
            return ContextCompat.getColor(getContext(), R.color.magnitude5);
        } else if (magnitude < 7) {
            return ContextCompat.getColor(getContext(), R.color.magnitude6);
        } else if (magnitude < 8) {
            return ContextCompat.getColor(getContext(), R.color.magnitude7);
        } else if (magnitude < 9) {
            return ContextCompat.getColor(getContext(), R.color.magnitude8);
        } else if (magnitude < 10) {
            return ContextCompat.getColor(getContext(), R.color.magnitude9);
        } else {
            return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        }
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
