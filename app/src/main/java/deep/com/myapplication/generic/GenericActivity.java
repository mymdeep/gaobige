package deep.com.myapplication.generic;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/3/31.
 */

public class GenericActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic);
        findViewById(R.id.generic_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
    private Response netRequest(){
        Response res = null;
        try {
            Thread.sleep(1000);
            res = new Response("result") {
                @Override
                public void parseResult() {

                }
            };
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

}
