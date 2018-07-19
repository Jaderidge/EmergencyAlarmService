package com.project.team_e.qi.emergencyalarmservice;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.os.Handler;


public class BluetoothService {
    private static final String TAG = "BluetoothService";

    private BluetoothAdapter btAdapter;
    private Activity mActivity;
    private Handler mHandler;

    public BluetoothService(Activity activity, Handler handler) {
        mActivity = activity;
        mHandler = handler;
        btAdapter = BluetoothAdapter.getDefaultAdapter();
    }
}
