package umeng.com.deeplink;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by wangfei on 2018/8/13.
 */

public class DeepLinkResultActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deeplinkrr);
        Uri data = getIntent().getData();
        try {
            Log.e("deeplink","scheme="+data.getScheme()+"   host="+data.getHost()+"   PathSegments="+data.getPathSegments()+"   Path="+data.getPath()+"    port="+data.getPort());
            Log.e("deeplink","Query="+data.getQuery());
            //scheme = data.getScheme(); // "will"
            //host = data.getHost(); // "share"
            //params = data.getPathSegments();
            //String testId = params.get(0); // "uuid"
            //tv_data.setText("Scheme: " + scheme + "\n" + "host: " + host + "\n" + "params: " + testId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
