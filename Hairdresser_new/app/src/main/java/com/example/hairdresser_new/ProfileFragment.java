package com.example.hairdresser_new;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment implements View.OnClickListener {

    View view;
    FloatingActionButton fab_add;
    private RecyclerView recyclerView;
    private List<DataModel> mlist;
    private itemAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);

        fab_add = (FloatingActionButton) view.findViewById(R.id.add_button);
        fab_add.setOnClickListener(this);


        recyclerView = view.findViewById(R.id.appointment);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        mlist = new ArrayList<>();
        List<String> nestedList1 = new ArrayList<>();
        nestedList1.add("10.00 น.");
        nestedList1.add("11.00 น.");
        nestedList1.add("12.00 น.");
        nestedList1.add("13.00 น.");
        nestedList1.add("14.00 น.");
        nestedList1.add("15.00 น.");
        nestedList1.add("16.00 น.");

        List<String> nestedList2 = new ArrayList<>();
        nestedList2.add("10.00 น.");
        nestedList2.add("11.00 น.");
        nestedList2.add("12.00 น.");
        nestedList2.add("13.00 น.");
        nestedList2.add("14.00 น.");
        nestedList2.add("15.00 น.");
        nestedList2.add("16.00 น.");

        List<String> nestedList3 = new ArrayList<>();
        nestedList3.add("10.00 น.");
        nestedList3.add("11.00 น.");
        nestedList3.add("12.00 น.");
        nestedList3.add("13.00 น.");
        nestedList3.add("14.00 น.");
        nestedList3.add("15.00 น.");
        nestedList3.add("16.00 น.");

        List<String> nestedList4 = new ArrayList<>();
        nestedList4.add("10.00 น.");
        nestedList4.add("11.00 น.");
        nestedList4.add("12.00 น.");
        nestedList4.add("13.00 น.");
        nestedList4.add("14.00 น.");
        nestedList4.add("15.00 น.");
        nestedList4.add("16.00 น.");

        List<String> nestedList5 = new ArrayList<>();
        nestedList5.add("10.00 น.");
        nestedList5.add("11.00 น.");
        nestedList5.add("12.00 น.");
        nestedList5.add("13.00 น.");
        nestedList5.add("14.00 น.");
        nestedList5.add("15.00 น.");
        nestedList5.add("16.00 น.");

        List<String> nestedList6 = new ArrayList<>();
        nestedList6.add("10.00 น.");
        nestedList6.add("11.00 น.");
        nestedList6.add("12.00 น.");
        nestedList6.add("13.00 น.");
        nestedList6.add("14.00 น.");
        nestedList6.add("15.00 น.");
        nestedList6.add("16.00 น.");

        List<String> nestedList7 = new ArrayList<>();
        nestedList7.add("10.00 น.");
        nestedList7.add("11.00 น.");
        nestedList7.add("12.00 น.");
        nestedList7.add("13.00 น.");
        nestedList7.add("14.00 น.");
        nestedList7.add("15.00 น.");
        nestedList7.add("16.00 น.");

        mlist.add(new DataModel(nestedList1, "วันจันทร์"));
        mlist.add(new DataModel(nestedList2, "วันอังคาร"));
        mlist.add(new DataModel(nestedList3, "วันพุธ"));
        mlist.add(new DataModel(nestedList4, "วันพฤหัสบดี"));
        mlist.add(new DataModel(nestedList5, "วันศุกร์"));
        mlist.add(new DataModel(nestedList6, "วันเสาร์"));
        mlist.add(new DataModel(nestedList7, "วันอาทิตย์"));

        adapter = new itemAdapter(mlist);
        recyclerView.setAdapter(adapter);


        return view;
    }

    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.add_button:
                fragment = new Add_Time();
                replaceFragment(fragment);
                break;


        }
    }

    private void replaceFragment(Fragment fragment) {

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_left_to_right,R.anim.exit_left_to_right,R.anim.enter_right_to_left, R.anim.exit_right_to_left);
        transaction.replace(R.id.fragment_container, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack(null);

        transaction.commit();

    }
}