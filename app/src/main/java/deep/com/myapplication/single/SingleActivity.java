package deep.com.myapplication.single;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/7/18.
 */

public class SingleActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        findViewById(R.id.single_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
