package com.example.doroteo_ridebook;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class EditRideFragment extends DialogFragment {
    private EditText dateVal;
    private EditText timeVal;
    private EditText distanceVal;
    private EditText speedVal;
    private EditText cadenceVal;
    private EditText commentsVal;
    private OnFragmentInteractionListener listener;

    public interface OnFragmentInteractionListener{
        void onEditPressed(String dateVal, String timeVal, String distanceVal, String speedVal, String cadenceVal, String commentsVal);
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
        dateVal= view.findViewById(R.id.date_editText);
        timeVal=view.findViewById(R.id.time_editText);
        distanceVal=view.findViewById(R.id.distance_editText);
        speedVal=view.findViewById(R.id.speed_editText);
        cadenceVal=view.findViewById(R.id.cadence_editText);
        commentsVal=view.findViewById(R.id.comments_editText);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        return builder
                .setView(view)
                .setTitle("Edit city")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String date = dateVal.getText().toString();
                        String time= timeVal.getText().toString();
                        String distance = distanceVal.getText().toString();
                        String speed = speedVal.getText().toString();
                        String cadence = cadenceVal.getText().toString();
                        String comments= commentsVal.getText().toString();
                        listener.onEditPressed(date, time, distance, speed, cadence, comments);
                    }
                }).create();
    }
}
