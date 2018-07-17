package simcpux.sourceforge.net.floatviewdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by changhong on 2018/7/17.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == Alarm2Activity.INTENT_ALARM_LOG) {
            Log.d("AlarmReceiver", "log log log");
        }

    }


}
