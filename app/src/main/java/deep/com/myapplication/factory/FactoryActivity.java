package deep.com.myapplication.factory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;
import deep.com.myapplication.factory.abstractfactory.AbstractFactory;
import deep.com.myapplication.factory.abstractfactory.PhoneFactory;
import deep.com.myapplication.factory.normal.FuShiKangFactory;

/**
 * Created by wangfei on 2018/6/21.
 */

public class FactoryActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory);
        findViewById(R.id.factory_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                FuShiKangFactory factory = new FuShiKangFactory();
                factory.getPhone("p21").desc();
            }
        });
        findViewById(R.id.factory_btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                AbstractFactory iphoneFactory = PhoneFactory.getFactory(0);
                iphoneFactory.getPhone("iphonex").desc();

            }
        });
    }
}
