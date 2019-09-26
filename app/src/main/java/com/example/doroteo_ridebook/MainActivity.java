package com.example.doroteo_ridebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AddRideFragment.OnFragmentInteractionListener {

    // Declare the variables so that you will be able to reference it later.
    ListView rideList;
    ArrayAdapter<Ride> rideAdapter;
    ArrayList<Ride> rideDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rideList = findViewById(R.id.ride_list);

        String []distances ={"0.7"};
        String []speeds={"10"};
        String []cadences={"4"};
        String []comments={"vv"};

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
                new AddRideFragment().show(getSupportFragmentManager(), "ADD_CITY");
            }
        });

    }


    @Override
    public void onOkPressed(Ride newRide) {
        rideAdapter.add(newRide);
    }
}
