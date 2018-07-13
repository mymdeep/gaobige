package deep.com.myapplication.touch;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/6/6.
 */

public class TouchActivity extends Activity{
    VGroup vg1,vg2;
    VView v3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        vg1 = findViewById(R.id.touch1);
        vg2 = findViewById(R.id.touch2);
        v3 = findViewById(R.id.touch3);
        vg1.name = "Group1";
        vg2.name = "Group2";

    }

    public void onClick(View v){
        Button b = (Button)v;
        switch (v.getId()){
            case R.id.touch_v1d:

                if (b.getText().equals("false")){
                    vg1.setDispatch(true);
                    b.setText("true");
                }else {
                    vg1.setDispatch(false);
                    b.setText("false");
                }
                break;
            case R.id.touch_v1i:

                if (b.getText().equals("false")){
                    vg1.setIntercept(true);
                    b.setText("true");
                }else {
                    vg1.setIntercept(false);
                    b.setText("false");
                }
                break;
            case R.id.touch_v1t:

                if (b.getText().equals("false")){
                    vg1.setTouch(true);
                    b.setText("true");
                }else {
                    vg1.setTouch(false);
                    b.setText("false");
                }
                break;
            case R.id.touch_v2d:

                if (b.getText().equals("false")){
                    vg2.setDispatch(true);
                    b.setText("true");
                }else {
                    vg2.setDispatch(false);
                    b.setText("false");
                }
                break;
            case R.id.touch_v2i:

                if (b.getText().equals("false")){
                    vg2.setIntercept(true);
                    b.setText("true");
                }else {
                    vg2.setIntercept(false);
                    b.setText("false");
                }
                break;
            case R.id.touch_v2t:

                if (b.getText().equals("false")){
                    vg2.setTouch(true);
                    b.setText("true");
                }else {
                    vg2.setTouch(false);
                    b.setText("false");
                }
                break;
            case R.id.touch_v3d:

                if (b.getText().equals("false")){
                    v3.setDispatch(true);
                    b.setText("true");
                }else {
                    v3.setDispatch(false);
                    b.setText("false");
                }
                break;

            case R.id.touch_v3t:

                if (b.getText().equals("false")){
                    v3.setTouch(true);
                    b.setText("true");
                }else {
                    v3.setTouch(false);
                    b.setText("false");
                }
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("touch","Activity"+"  "+"onTouchEvent "+getAction(event.getAction()));

        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("touch","Activity"+"  "+"dispatchTouchEvent "+getAction(ev.getAction()));
        return super.dispatchTouchEvent(ev);
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
