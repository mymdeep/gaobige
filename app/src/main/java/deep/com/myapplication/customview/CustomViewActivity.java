package deep.com.myapplication.customview;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/5/28.
 */

public class CustomViewActivity extends Activity {
    DeepView deepView;
    DeepGroup deepGroup;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customview);
        deepView = findViewById(R.id.custom1);
        deepGroup = findViewById(R.id.custom2);
       findViewById(R.id.custom_btn1).setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
               Random r = new Random();
               String t = deepView.getText().toString()+"随机数："+r.nextInt();
               deepView.setText(t);
           }
       });
        findViewById(R.id.custom_btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
              deepView.postInvalidate();
            }
        });
        findViewById(R.id.custom_btn3).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                deepView.requestLayout();
            }
        });
        findViewById(R.id.custom_btn4).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deepGroup.getVertical()){
                    deepGroup.setVertical(false);
                }else {
                    deepGroup.setVertical(true);
                }
            }
        });
    }
}
