package deep.com.myapplication.design.mvc;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/5/18.
 */

public class MVCActivity extends Activity{
    TextView tv;
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        tv = findViewById(R.id.text);
        ed = findViewById(R.id.ed);
        findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(ed.getText().toString())){
                    tv.setText("数据已保存");
                    save(ed.getText().toString());
                }else {
                    tv.setText("请先输入数据");
                }

            }
        });
    }
    public void save(String c){
        SharedPreferences sp = getSharedPreferences("deep", Context.MODE_PRIVATE);
        sp.edit().putString("aa",c).apply();
    }

}
