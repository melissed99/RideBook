package com.example.doroteo_ridebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;

import androidx.annotation.Nullable;

//code used from the custom list tutorial from CMPUT 301 lab 3
//

public class CustomList extends ArrayAdapter<Ride> {

    //holds the rides
    private ArrayList<Ride> rides;
    // holds the activity context
    private Context context;

    //customlist constructor
    public CustomList(Context context, ArrayList<Ride> rides){
        super(context, 0, rides);
        this.rides=rides;
        this.context=context;
    }


    //set the values for the views inh the listview
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        View view = convertView;

        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent, false);
        }

        Ride ride = rides.get(position);

        TextView date = view.findViewById(R.id.date_text);
        TextView time = view.findViewById(R.id.time_text);
        TextView distance = view.findViewById(R.id.distance_text);
        TextView speed = view.findViewById(R.id.speed_text);
        TextView cadence = view.findViewById(R.id.cadence_text);
        TextView comments = view.findViewById(R.id.comments_text);

        //gets the new values added/updated and put onto the list
        date.setText(ride.getDate());
        time.setText(ride.getTime());
        distance.setText(ride.getDistance());
        speed.setText(ride.getSpeed());
        cadence.setText(ride.getCadence());
        comments.setText(ride.getComments());

        return view;
    }

}
