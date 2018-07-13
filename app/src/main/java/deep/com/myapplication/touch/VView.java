package deep.com.myapplication.touch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wangfei on 2018/6/6.
 */

public class VView extends View{
    private boolean isDispatch = false;
    private boolean isTouch = false;
    public String name = "View";
    public VView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("touch",name+"  "+"dispatchTouchEvent "+getAction(ev.getAction()));
        super.dispatchTouchEvent(ev);
        return isDispatch;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("touch",name+"  "+"onTouchEvent "+getAction(event.getAction()));
       super.onTouchEvent(event);
        return isTouch;
    }

    public void setDispatch(boolean dispatch) {

        isDispatch = dispatch;
    }

    public void setTouch(boolean isTouch) {
        this.isTouch = isTouch;
    }
    public boolean getDispatch() {
        return isDispatch ;
    }

    public boolean getTouch() {
        return isTouch ;
    }
    private String getAction(int action){
        if (action == MotionEvent.ACTION_DOWN){
            return "down";
        }
        if (action == MotionEvent.ACTION_UP){
            return "up";
        }
        if (action == MotionEvent.ACTION_MOVE){
            return "move";
        }

        return "";
    }
}
