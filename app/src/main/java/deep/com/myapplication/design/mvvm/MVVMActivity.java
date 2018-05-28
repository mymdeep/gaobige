package deep.com.myapplication.design.mvvm;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import deep.com.myapplication.R;
import deep.com.myapplication.databinding.ActivityMvvmBinding;

/**
 * Created by wangfei on 2018/5/18.
 */

public class MVVMActivity extends Activity{
    TextView tv;

    Result r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        final ActivityMvvmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        binding.setClick(new OnClickListener() {
            @Override
            public void onClick(View v) {

               Result r=  download();
               save(r);
            }
        });
        r = new Result();
        r.setR("");
        r.setText("");
        binding.setResult(r);



    }
    public void save(Result r){
        Log.e("design","save Result:"+r.getR());
    }

    public Result download(){
        Log.e("design","download Result");
        Result r = new Result();
        r.setR("aaaa");
        r.setText("数据已保存");
        return r;
    }
}
