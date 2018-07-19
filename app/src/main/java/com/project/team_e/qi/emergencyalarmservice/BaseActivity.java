package com.project.team_e.qi.emergencyalarmservice;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class BaseActivity extends AppCompatActivity implements OnMapReadyCallback{
    TabHost hstTabs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        hstTabs = findViewById(R.id.hstTabs);
        hstTabs.setup();

        TabHost.TabSpec tsFirst = hstTabs.newTabSpec("tsFirst");
        tsFirst.setContent(R.id.tsFirst);
        tsFirst.setIndicator("1");
        hstTabs.addTab(tsFirst);

        TabHost.TabSpec tsSecond = hstTabs.newTabSpec("tsSecond");
        tsSecond.setContent(R.id.tsSecond);
        tsSecond.setIndicator("2");
        hstTabs.addTab(tsSecond);

        TabHost.TabSpec tsThird = hstTabs.newTabSpec("tsThird");
        tsThird.setContent(R.id.tsThird);
        tsThird.setIndicator("3");
        hstTabs.addTab(tsThird);

        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager.findFragmentById(R.id.frgMap);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng CMRR = new LatLng(32.880589, -117.235587);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(CMRR);
        markerOptions.title("CMRR");
        googleMap.addMarker(markerOptions);

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(CMRR));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(10));
    }
}
