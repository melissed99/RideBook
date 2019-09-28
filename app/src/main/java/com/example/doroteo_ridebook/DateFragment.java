package com.example.doroteo_ridebook;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.provider.CalendarContract;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DateFragment extends DialogFragment {

    //private OnFragmentInteractionListener listener;

//    public Dialog onCreateDialog(Bundle savedInstanceState){
//        Calendar c = Calendar.getInstance();
//        int year = c.get(Calendar.YEAR);
//        int month = c.get(Calendar.MONTH);
//        int day = c.get(Calendar.DAY_OF_MONTH);
//
//        return new DatePickerDialog(getActivity(),  (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof AddRideFragment.OnFragmentInteractionListener){
            //listener= (DateFragment.OnFragmentInteractionListener) context;
        }
        else {
            throw new RuntimeException(context.toString()
                    + "must implement OnFragmentInteractionListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),(DatePickerDialog.OnDateSetListener) getActivity(),year,month,day);
    }
}

