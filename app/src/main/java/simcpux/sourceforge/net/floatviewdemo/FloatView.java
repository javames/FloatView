package simcpux.sourceforge.net.floatviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by changhong on 2018/6/24.
 */

public class FloatView extends FrameLayout {
    public FloatView(@NonNull Context context) {
        this(context, null);
    }
    public FloatView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }
    public FloatView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
