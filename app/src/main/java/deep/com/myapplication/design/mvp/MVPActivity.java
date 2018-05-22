package deep.com.myapplication.design.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/5/18.
 */

public class MVPActivity extends Activity implements IView{
    TextView tv;
    EditText ed;
    Presenter p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        tv = findViewById(R.id.text);
        ed = findViewById(R.id.ed);
        p = new Presenter(getSp(),this);
        findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                p.save(ed.getText().toString());
            }
        });
    }
    public SharedPreferences getSp(){
        SharedPreferences sp = getSharedPreferences("deep", Context.MODE_PRIVATE);
      return sp;
    }

    @Override
    public void update(boolean isOk) {
        if (isOk){
            tv.setText("数据已保存");

        }else {
            tv.setText("请先输入数据");
        }
    }
}
