package com.example.hairdresser_new;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class WorknewFragment extends Fragment {

    View view;
    CardView bookinguser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_worknew, container, false);
        bookinguser = (CardView) view.findViewById(R.id.bookingUser);
        bookinguser.setOnClickListener(Booking);


        return view;
    }
    private  View.OnClickListener  Booking = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = null;
            switch (view.getId()) {
                case R.id.bookingUser:
                    fragment = new BookingCustomerFragment();
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