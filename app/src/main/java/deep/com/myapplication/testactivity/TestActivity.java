package deep.com.myapplication.testactivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/5/2.
 */

public class TestActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("test","onCreate");
        super.onCreate(savedInstanceState);
        if (savedInstanceState!=null){
            int IntTest = savedInstanceState.getInt("deep");
            String StrTest = savedInstanceState.getString("deepStr");
            Log.e("test", "onCreate   deep="+IntTest+"+deepStr="+StrTest);
        }
        setContentView(R.layout.activity_test);
        findViewById(R.id.test_btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestDialog dialog = new TestDialog(TestActivity.this);
                dialog.show();
            }
        });
        findViewById(R.id.test_btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                ComponentName cn = new ComponentName("deep.com.test",  "deep.com.myapplication.MainActivity");
                i.setComponent(cn);
                i.setAction("android.intent.action.MAIN");
                startActivityForResult(i,233); //or startActivityForResult(i, RESULT_OK);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("deep", 0);
        outState.putString("deepStr", "deep test");
        super.onSaveInstanceState(outState);
        Log.e("test","onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e("test","onRestoreInstanceState");
        int IntTest = savedInstanceState.getInt("deep");
        String StrTest = savedInstanceState.getString("deepStr");
        Log.e("test", "onRestoreInstanceState   deep="+IntTest+"+deepStr="+StrTest);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("test","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("test","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("test","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("test","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("test","onDestroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("test","onActivityResult  requestCode="+requestCode+"  resultCode="+resultCode);

    }
}
