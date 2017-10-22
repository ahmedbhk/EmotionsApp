package justsmart.esprit.com.zaiedhospital.Services;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AutoStart extends BroadcastReceiver
{
    public void onReceive(Context context, Intent arg1)
    {
        Intent intent = new Intent(context,ServiceNotification.class);
        context.startService(intent);
        Log.i("Autostart", "started");
    }
}