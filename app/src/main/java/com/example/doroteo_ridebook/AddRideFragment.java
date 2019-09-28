package com.example.doroteo_ridebook;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
//import android.support.v4.app.Fragment;

public class AddRideFragment extends DialogFragment {
    private EditText distanceVal;
    private EditText speedVal;
    private EditText cadenceVal;
    private EditText commentsVal;
    private OnFragmentInteractionListener listener;

    public Button addDate;
    public TextView dateAdd;

    private DatePickerDialog.OnDateSetListener dateSetListener;
//
//    @Override
//    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//
//        Calendar c = Calendar.getInstance();
//        c.set(Calendar.YEAR, year);
//        c.set(Calendar.MONTH, month);
//        c.set(Calendar.DAY_OF_MONTH, day);
//        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
//
//        TextView dateAdd = getView().findViewById(R.id.date_editText);
//        dateAdd.setText(currentDateString);
//
//    }

    public interface OnFragmentInteractionListener{
        void onOkPressed(Ride newRide);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener){
            listener= (OnFragmentInteractionListener) context;
        }
        else {
            throw new RuntimeException(context.toString()
                    + "must implement OnFragmentInteractionListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.add_ride_fragment, null);
        distanceVal=view.findViewById(R.id.distance_editText);
        speedVal=view.findViewById(R.id.speed_editText);
        cadenceVal=view.findViewById(R.id.cadence_editText);
        commentsVal=view.findViewById(R.id.comments_editText);

//        addDate=view.findViewById(R.id.add_ride_button);
//
//        addDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //DialogFragment datePicker = new DateFragment();
//                //datePicker.show(getSupportFragmentManager(),"date picker");
//                //new DateFragment().show(getSupportFragmentManager(), "ADD_DATE");
//
//
//                //final Button dateButton = (Button) view;
//
//                Calendar calendar = Calendar.getInstance();
//
//                int year = calendar.get(Calendar.YEAR);
//                int month = calendar.get(Calendar.MONTH);
//                int day = calendar.get(Calendar.DAY_OF_MONTH);
//
//
//                DatePickerDialog dialog = new DatePickerDialog(AddRideFragment.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth), dateSetListener, year, month, day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//
//            }
//        });
//
//
//        dateSetListener = new DialogPickerDialog.OnDateSetListener(){
//
//        }
//
//
//
//
//




        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        return builder
                .setView(view)
                .setTitle("Add city")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String distance = distanceVal.getText().toString();
                        String speed = speedVal.getText().toString();
                        String cadence = cadenceVal.getText().toString();
                        String comments= commentsVal.getText().toString();
                        listener.onOkPressed(new Ride(distance, speed, cadence, comments));
                    }
                }).create();
    }
}
