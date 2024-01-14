package com.sea.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("MyReceiver", "Received broadcast: " + intent.getAction());
        String action = intent.getAction();
        if (action != null) {
            switch (action) {
                case "com.sea.ACTION_ONE":
                    showToast(context, "Received command: com.sea.ACTION_ONE");
                    handleActionOne(context, intent);
                    break;
                case "com.sea.ACTION_TWO":
                    showToast(context, "Received command: com.sea.ACTION_TWO");
                    handleActionTwo(context, intent);
                    break;
                case "com.sea.ACTION_THREE":
                    showToast(context, "Received command: com.sea.ACTION_THREE");
                    handleActionThree(context, intent);
                    break;
                // Add more cases for other custom actions
                default:
                    // Handle default or unknown action
                    showToast(context, "Received command: " + intent.getAction());
                    Log.d("MyReceiver-default", "Received broadcast: " + intent.getAction());

                    //throw new UnsupportedOperationException("Not yet implemented");
            }
        }
    }

    private void handleActionOne(Context context, Intent intent) {
        // Handle actions specific to "com.example.ACTION_ONE"
        String extraData = intent.getStringExtra("extra_key");
        if (extraData != null) {
            // Process the extra data as needed
            Log.d("handleActionOne-MyReceiver", "Received extra data: " + extraData);

            // adb shell am broadcast -a com.sea.ACTION_ONE --es extra_key one -n com.sea.broadcastreceiver/.MyReceiver
        }
    }

    private void handleActionTwo(Context context, Intent intent) {
        // Handle actions specific to "com.example.ACTION_TWO"
        String extraData = intent.getStringExtra("extra_key");
        if (extraData != null) {
            // Process the extra data as needed
            Log.d("handleActionTwo-MyReceiver", "Received extra data: " + extraData);

            // adb shell am broadcast -a com.sea.ACTION_TWO --es extra_key two -n com.sea.broadcastreceiver/.MyReceiver
        }
    }
    // Add more methods for handling other custom actions

    private void handleActionThree(Context context, Intent intent) {
        String extraString = intent.getStringExtra("key_string");
        int extraInteger = intent.getIntExtra("key_integer", -1); // Default value if not provided
        boolean extraBoolean = intent.getBooleanExtra("key_boolean", false); // Default value if not provided

        // Process the extras as needed
        Log.d("handleActionThree-MyReceiver", "Received extras: " + extraString + ", " + extraInteger + ", " + extraBoolean);

        // adb shell am broadcast -a com.sea.ACTION_THREE --es key_string go --ei key_integer 100 --ez key_boolean true -n com.sea.broadcastreceiver/.MyReceiver
    }


    private void showToast(Context context, String message) {
        // Use application context to avoid potential memory leaks
        Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
    // Add more methods for handling other custom actions
}