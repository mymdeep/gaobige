package deep.com.myapplication.design;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;
import deep.com.myapplication.design.mvc.MVCActivity;
import deep.com.myapplication.design.mvp.MVPActivity;
import deep.com.myapplication.design.mvpdb.MVPDataBindingActivity;
import deep.com.myapplication.design.mvvm.MVVMActivity;

/**
 * Created by wangfei on 2018/5/18.
 */

public class DesignActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);
        findViewById(R.id.design_mvc).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DesignActivity.this,MVCActivity.class));
            }
        });
        findViewById(R.id.design_mvp).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DesignActivity.this,MVPActivity.class));
            }
        });
        findViewById(R.id.design_mvvm).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DesignActivity.this,MVVMActivity.class));
            }
        });
        findViewById(R.id.design_mvpdb).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DesignActivity.this,MVPDataBindingActivity.class));
            }
        });
    }

}
