package deep.com.myapplication.annotation;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/4/26.
 */

public class AnnotationActivity extends Activity {
    @Deep(k = "this is a key")
    private String key;
    @Deep(v = 100)
    private int a;
    @Deep(b = true)
    private boolean isB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);
        Log.e("annotation","key="+key+"   a="+a+"   isB="+isB);
        ParseAnnotation.parse(AnnotationActivity.class,this);
        findViewById(R.id.annotation_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("annotation","key="+key+"   a="+a+"   isB="+isB);
                //testCheck(10);
            }
        });
        findViewById(R.id.annotation_btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

        ParseAnnotation.invoke(AnnotationActivity.class,AnnotationActivity.this,"testAnnotaition");

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Deep(methodParam = "oooo")
  private void testAnnotaition(String aa){
        Log.e("annotation",aa);
  }


}
