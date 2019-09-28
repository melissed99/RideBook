package com.example.doroteo_ridebook;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
//import android.widget.DatePicker;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AddRideFragment.OnFragmentInteractionListener, EditRideFragment.OnFragmentInteractionListener {

    // Declare the variables so that you will be able to reference it later.
    ListView rideList;
    ArrayAdapter<Ride> rideAdapter;
    ArrayList<Ride> rideDataList;
    Ride ridePos;

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

        String []distances ={};
        String []speeds={};
        String []cadences={};
        String []comments={};

        rideDataList = new ArrayList<>();

        for(int i=0;i<distances.length;i++){
            rideDataList.add((new Ride(distances[i],speeds[i], cadences[i], comments[i])));
        }

        rideAdapter = new CustomList(this,rideDataList);
        rideList.setAdapter(rideAdapter);

        final FloatingActionButton addRideButton = findViewById(R.id.add_ride_button);
        addRideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AddRideFragment().show(getSupportFragmentManager(), "ADD_RIDE");
            }
        });

        //new
        rideList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ridePos = rideDataList.get(i);

                AlertDialog.Builder editDeleteAlert = new AlertDialog.Builder(MainActivity.this);
                editDeleteAlert.setMessage("edit or delete?")
                        .setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                new EditRideFragment().show(getSupportFragmentManager(), "EDIT_RIDE");
                            }
                        })
                        .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                rideDataList.remove(ridePos);
                                rideAdapter.notifyDataSetChanged();

                            }
                        });
                AlertDialog alert = editDeleteAlert.create();
                alert.show();
            }
        });

    }


    @Override
    public void onOkPressed(Ride newRide) {
        rideAdapter.add(newRide);
    }

    @Override
    public void onEditPressed(String distanceVal, String speedVal, String cadenceVal, String commentsVal){
        ridePos.setDistance(distanceVal);
        ridePos.setSpeed(speedVal);
        ridePos.setCadence(cadenceVal);
        ridePos.setComments(commentsVal);

    }
}
