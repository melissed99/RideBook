package com.example.doroteo_ridebook;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AddRideFragment.OnFragmentInteractionListener, EditRideFragment.OnFragmentInteractionListener {

    // Declare the variables so that you will be able to reference it later.
    ListView rideList;
    ArrayAdapter<Ride> rideAdapter;
    ArrayList<Ride> rideDataList;
    Ride ridePos;

    String get_date;
    String get_time;
    String get_distance;
    String get_speed;
    String get_cadence;
    String get_comments;



    //message will display telling user to add a ride. message will disappear when there are rides
    @Override
    public void onContentChanged(){
        super.onContentChanged();

        View empty = findViewById(R.id.empty_rides_string);
        ListView list = (ListView) findViewById(R.id.ride_list);
        list.setEmptyView(empty);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rideList = findViewById(R.id.ride_list);

        String[] dates = {};
        String[] times = {};
        String[] distances = {};
        String[] speeds = {};
        String[] cadences = {};
        String[] comments = {};

        rideDataList = new ArrayList<>();

        for (int i = 0; i < dates.length; i++) {
            rideDataList.add((new Ride(dates[i], times[i], distances[i], speeds[i], cadences[i], comments[i])));
        }

        rideAdapter = new CustomList(this, rideDataList);
        rideList.setAdapter(rideAdapter);

        final FloatingActionButton addRideButton = findViewById(R.id.add_ride_button);
        addRideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AddRideFragment().show(getSupportFragmentManager(), "ADD_RIDE");
            }
        });

        rideList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ridePos = rideDataList.get(i);

                AlertDialog.Builder editDeleteAlert = new AlertDialog.Builder(MainActivity.this);
                editDeleteAlert.setMessage("edit or delete?")
                        .setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                get_date = ridePos.getDate();
                                get_time = ridePos.getTime();
                                get_distance = ridePos.getDistance();
                                get_speed = ridePos.getSpeed();
                                get_cadence = ridePos.getCadence();
                                get_comments = ridePos.getComments();

                                new EditRideFragment().show(getSupportFragmentManager(), "EDIT_RIDE");
                                updateTotalDist();
                            }
                        })
                        .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                rideDataList.remove(ridePos);
                                updateTotalDist();
                                rideAdapter.notifyDataSetChanged();

                            }
                        });
                AlertDialog alert = editDeleteAlert.create();
                alert.show();
            }

        }
        );

        updateTotalDist();
        rideAdapter.notifyDataSetChanged();
    }

    public String get_Date(){ return get_date; }
    public String get_Time(){ return get_time; }
    public String get_Distance(){ return get_distance; }
    public String get_Speed(){ return get_speed; }
    public String get_Cadence(){ return get_cadence; }
    public String get_Comments(){ return get_comments; }

    @Override
    public void onOkPressed(Ride newRide) {
        rideAdapter.add(newRide);

        updateTotalDist();
        rideAdapter.notifyDataSetChanged();
    }

    @Override
    public void onEditPressed(String dateVal, String timeVal, String distanceVal, String speedVal, String cadenceVal, String commentsVal){
        ridePos.setDate(dateVal);
        ridePos.setTime(timeVal);
        ridePos.setDistance(distanceVal);
        ridePos.setSpeed(speedVal);
        ridePos.setCadence(cadenceVal);
        ridePos.setComments(commentsVal);

        updateTotalDist();

    }

    public void updateTotalDist(){
        TextView totalDistance = findViewById(R.id.total_distance_value);
        double totalDistanceVal=0;

        if(rideDataList!=null){
            for (int i = 0;i<rideDataList.size();i++){
                Ride ride = rideDataList.get(i);
                String distanceVal = ride.getDistance();
                double distance = Double.valueOf(distanceVal);
                totalDistanceVal += distance;
            }
            totalDistance.setText(String.valueOf(totalDistanceVal));
        }else{
            totalDistance.setText(String.valueOf(0));
        }
    }


}
