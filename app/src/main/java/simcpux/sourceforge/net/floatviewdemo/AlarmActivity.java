package simcpux.sourceforge.net.floatviewdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        final TextView tv = (TextView) findViewById(R.id.test);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("update_time_action");
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("update_time_action")) {
                    Log.i("test"," 收到广播。。。");
//                  接收到广播之后先设置tv，然后重新设置AlarmManager
                    tv.setText(getText());
                    AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                    PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
                    long nextTime = getNextTime();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        am.setExact(AlarmManager.RTC_WAKEUP, nextTime, pi);
                    } else {
                        am.set(AlarmManager.RTC_WAKEUP, nextTime, pi);
                    }
                }
            }
        }, intentFilter);

        sendBroadcast(new Intent("update_time_action"));


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //    获取当前时间的样式
    private String getText() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(date);
    }

    //    获取下次更新TextView的时间
    private long getNextTime() {
        long now = System.currentTimeMillis();
        return now + 60 * 1000 - now % (60 * 1000);
    }


}
