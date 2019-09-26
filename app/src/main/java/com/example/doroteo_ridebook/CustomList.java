package com.example.doroteo_ridebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class CustomList extends ArrayAdapter<Ride> {

    private ArrayList<Ride> rides;
    private Context context;

    public CustomList(Context context, ArrayList<Ride> rides){
        super(context, 0, rides);
        this.rides=rides;
        this.context=context;
    }

    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        View view = convertView;

        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent, false);
        }

        Ride ride = rides.get(position);

        TextView distance = view.findViewById(R.id.distance_text);
        TextView speed = view.findViewById(R.id.speed_text);
        TextView cadence = view.findViewById(R.id.cadence_text);
        TextView comments = view.findViewById(R.id.comments_text);

        distance.setText(ride.getDistance());
        speed.setText(ride.getSpeed());
        cadence.setText(ride.getCadence());
        comments.setText(ride.getComments());

        return view;
    }
}
