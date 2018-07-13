package deep.com.myapplication.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by wangfei on 2018/6/6.
 */

public class VGroup extends RelativeLayout{
    private boolean isDispatch = false;
    private boolean isIntercept = false;
    private boolean isTouch = false;
    public String name = "Group1";
    public VGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("touch",name+"  "+"dispatchTouchEvent "+getAction(ev.getAction()));
        super.dispatchTouchEvent(ev);
        return isDispatch;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("touch",name+"  "+"onInterceptTouchEvent "+getAction(ev.getAction()));
        super.onInterceptTouchEvent(ev);
        return isIntercept;
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

    public void setIntercept(boolean intercept) {
        isIntercept = intercept;
    }
    public boolean getDispatch() {
        return isDispatch ;
    }

    public boolean getIntercept() {
        return isIntercept ;
    }
    public void setTouch(boolean intercept) {
        isTouch = intercept;
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
