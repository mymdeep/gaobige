package deep.com.myapplication.design.mvvm;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import deep.com.myapplication.R;
import deep.com.myapplication.databinding.ActivityMvvmBinding;

/**
 * Created by wangfei on 2018/5/18.
 */

public class MVVMActivity extends Activity{
    TextView tv;
    EditText ed;
    Result r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        final ActivityMvvmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        binding.setClick(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(r.getText())){
                    r.setR("数据已保存");
                    save(r.getText());
                }else {
                    r.setR("请先输入数据");
                }
            }
        });
        r = new Result();
        r.setR("请先输入数据");
        r.setText("请输入");
        binding.setResult(r);



    }
    public void save(String c){
        SharedPreferences sp = getSharedPreferences("deep", Context.MODE_PRIVATE);
        sp.edit().putString("aa",c).apply();
    }
}
