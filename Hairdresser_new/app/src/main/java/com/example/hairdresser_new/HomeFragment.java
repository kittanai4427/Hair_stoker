package com.example.hairdresser_new;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;


public class HomeFragment extends Fragment {
    View view;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_home, container, false);
        Switch switchOne = (Switch) view.findViewById(R.id.switchone);
        TextView textsw = (TextView) view.findViewById(R.id.textsw);
        switchOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(switchOne.isChecked()){
                    textsw.setText("ออนไลน์");
                }
                else {
                    textsw.setText("ปิด");
                }
            }
        });



        return view;
    }

}
