package fakher.husayn.tvshowapp.Networking;

/**
 * Created By Fakher_Husayn on 07-Nov-19
 **/

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class  ConnectionBroadcastReceiver extends BroadcastReceiver {

    private Context context;
    private boolean starting = true;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;

        boolean noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);

        if(!noConnectivity) {
            onConnectionFound();
        } else {
            onConnectionLost();
        }
    }

    private void onConnectionLost() {
        Toast.makeText(context, "You have lost data connectivity", Toast.LENGTH_LONG).show();
    }

    private void onConnectionFound() {
        if(starting) {
            Toast.makeText(context, "Loading data...", Toast.LENGTH_LONG).show();
            starting = false;
        }else{
            Toast.makeText(context, "Connected.", Toast.LENGTH_LONG).show();
        }
    }
    }
