package deep.com.myapplication.design.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/5/18.
 */

public class MVPActivity extends Activity implements IView{
    TextView tv;
    Presenter p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        tv = findViewById(R.id.text);

        p = new Presenter(this);
        findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            p.download();
            }
        });
    }


    @Override
    public void update() {
        tv.setText("数据已保存");
    }
}
