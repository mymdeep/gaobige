package deep.com.myapplication.design.mvc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/5/18.
 */

public class MVCActivity extends Activity{
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        tv = findViewById(R.id.text);
        findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Result r = download();
                save(r);

            }
        });
    }
    public void save(Result r){
        tv.setText("数据已保存");
        Log.e("design","save Result:"+r.getR());
    }

    public Result download(){
        Log.e("design","download Result");
        Result r = new Result();
        r.setR("aaaa");
        return r;
    }

}
