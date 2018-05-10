package deep.com.myapplication.testactivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by wangfei on 2018/5/2.
 */

public class TestDialog extends Dialog {
    public TestDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("test","dialog onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("test","dialog onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("test","dialog onStop");
    }

    @Override
    public void dismiss() {
        super.dismiss();
        Log.e("test","dialog dismiss");
    }

    @Override
    public void cancel() {
        super.cancel();
        Log.e("test","dialog cancel");
    }

    @Override
    public void show() {
        super.show();
        Log.e("test","dialog show");
    }
}
