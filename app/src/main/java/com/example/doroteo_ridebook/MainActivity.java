package com.example.doroteo_ridebook;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AddRideFragment.OnFragmentInteractionListener, EditRideFragment.OnFragmentInteractionListener {

    // Declare the variables so that you will be able to reference it later.
    ListView rideList;
    ArrayAdapter<Ride> rideAdapter;
    ArrayList<Ride> rideDataList;
    Ride ridePos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rideList = findViewById(R.id.ride_list);

        String []distances ={"0.8"};
        String []speeds={"10"};
        String []cadences={"4"};
        String []comments={"vv"};

        rideDataList = new ArrayList<>();

        //rideAdapter = new ArrayAdapter<Ride>(MainActivity.this, android.R.layout.simple_list_item_multiple_choice);

        for(int i=0;i<distances.length;i++){
            rideDataList.add((new Ride(distances[i],speeds[i], cadences[i], comments[i])));
        }

        rideAdapter = new CustomList(this,rideDataList);
        rideList.setAdapter(rideAdapter);

        final FloatingActionButton addRideButton = findViewById(R.id.add_ride_button);
        addRideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AddRideFragment().show(getSupportFragmentManager(), "ADD_CITY");
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
                                new EditRideFragment().show(getSupportFragmentManager(), "EDIT_CITY");
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

                //ridePos = rideDataList.get(i);
                //new EditRideFragment().show(getSupportFragmentManager(), "EDIT_CITY");
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

    //rideList.setAdapter(rideAdapter);
    }
}
