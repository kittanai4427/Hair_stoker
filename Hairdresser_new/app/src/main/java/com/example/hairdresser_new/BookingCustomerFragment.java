package com.example.hairdresser_new;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class BookingCustomerFragment extends Fragment {

    View view;
    ImageButton btnbackhome;
    Button goapp;

//    GoogleMap mGooglMap;
//    MapView mMapview;
//    View mView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_booking_customer, container, false);
//        SupportMapFragment supportMapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.goole_map);


        btnbackhome = view.findViewById(R.id.btnhome);
        btnbackhome.setOnClickListener(BackHome);
        goapp = view.findViewById(R.id.showmsg);
        goapp.setOnClickListener(BackHome);
//        goapp.setOnClickListener(mag);
//        //ส่วนการแจ้งเตือนการนัดหมาย
//        Button button = view.findViewById(R.id.showmsg);

//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            NotificationChannel channel = new NotificationChannel("My ti","mt ti1",NotificationManager.IMPORTANCE_DEFAULT);
//            NotificationManager manager = getActivity().getSystemService(NotificationManager.class);
//            manager.createNotificationChannel(channel);
//        }
//
//        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
//            @Override
//            public void onMapReady(@NonNull GoogleMap googleMap) {
//                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
//                    @Override
//                    public void onMapClick(@NonNull LatLng latLng) {
//                        MarkerOptions markerOptions = new MarkerOptions();
//                        markerOptions.position(latLng);
//                        markerOptions.title(latLng.latitude+" : " + latLng.longitude);
//                        googleMap.clear();
//                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
//                                latLng, 10
//                        ));
//                       googleMap.addMarker(markerOptions);
//                    }
//                });
//
//            }
//        });

        return view;
    }

    private View.OnClickListener BackHome = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = null;
            switch (view.getId()) {
                case R.id.btnhome:
                    fragment = new CourseFragment();
                    replaceFragment(fragment);
                    break;
                case R.id.showmsg:
                    fragment = new AppointmentUserFragment();
                    replaceFragment(fragment);
                    break;
            }
        }
    };

    //    private View.OnClickListener mag = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            goapp.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    NotificationCompat.Builder buildar = new NotificationCompat.Builder(getActivity(),"my App");
//
//                    buildar.setSmallIcon(R.drawable._41430916_323547716213714_8063163232219428235_n).setContentTitle("ช่าง A").setContentText("ยอมรับงานของท่านเรียบร้อยแล้ว");;
//                    buildar.setAutoCancel(true);
//
//                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getActivity());
//                    managerCompat.notify(1,buildar.build());
//                }
//            });
//
//
//
//
//
//
//        }
//    };
    private void replaceFragment(Fragment fragment) {

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_left_to_right,R.anim.exit_left_to_right,R.anim.enter_right_to_left, R.anim.exit_right_to_left);
        transaction.replace(R.id.fragment_container, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}