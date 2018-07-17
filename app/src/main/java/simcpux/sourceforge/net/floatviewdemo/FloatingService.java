package simcpux.sourceforge.net.floatviewdemo;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.WindowManager;

/**
 * Created by changhong on 2018/6/24.
 */


public class FloatingService extends Service {

    private WindowManager mWindowManager;
    private FloatView floatView;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        floatView = new FloatView(getApplicationContext());
        floatView.setBackgroundColor(Color.RED);
        floatView.setAlpha(0.2f);
        mWindowManager = (WindowManager) this.getSystemService(WINDOW_SERVICE);
            WindowManager.LayoutParams mLayoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT, 0, 0, PixelFormat.TRANSPARENT);
            mLayoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
            mLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                    | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH |
                    WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
            mWindowManager.addView(floatView, mLayoutParams);
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if(null!=mWindowManager){
            mWindowManager.removeView(floatView);
        }
        Log.i("test","service onDestroy()");
    }
}
