package deep.com.myapplication.design.mvpdb;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import deep.com.myapplication.R;
import deep.com.myapplication.databinding.ActivityMvpdbBinding;

/**
 * Created by wangfei on 2018/5/25.
 */

public class MVPDataBindingActivity extends Activity implements IView {
    TextView tv;
    Presenter p;
    Result r;
    Display d;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         ActivityMvpdbBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvpdb);
        tv = findViewById(R.id.text);
         d = new Display();
        binding.setClick(new OnClickListener() {
            @Override
            public void onClick(View v) {
                p.download();
            }
        });
        binding.setDisplay(d);
        p = new Presenter(this);
    }

    @Override
    public void update() {
       d.setText("数据已更新");
    }
}
