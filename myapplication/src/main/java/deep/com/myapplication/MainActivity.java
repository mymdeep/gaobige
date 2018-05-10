package deep.com.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.test.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.setResult(33);
                finish();
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                ComponentName componentName = new ComponentName("deep.com.myapplication","deep.com.myapplication.testactivity.TestActivity");
                i.setComponent(componentName);
                startActivity(i);
            }
        });
    }
}
