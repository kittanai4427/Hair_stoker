package com.example.hairdresser_new;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class AppointmentUserFragment extends Fragment {
    View view;
    LinearLayout app_details;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_appointment_user, container, false);
        app_details = view.findViewById(R.id.appointment_details);
        app_details.setOnClickListener(fragmentappintment);


        return view;
    }
    private View.OnClickListener fragmentappintment = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = null;
            switch (view.getId()) {
                case R.id.appointment_details:
                    fragment = new Appointment_DetailsFragment();
                    replaceFragment(fragment);
                    break;

            }
        }
    };


    private void replaceFragment(Fragment fragment) {

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_left_to_right,R.anim.exit_left_to_right,R.anim.enter_right_to_left, R.anim.exit_right_to_left);
        transaction.replace(R.id.fragment_container, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack(null);

        transaction.commit();

    }
}