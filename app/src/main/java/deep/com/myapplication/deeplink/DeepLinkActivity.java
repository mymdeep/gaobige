package deep.com.myapplication.deeplink;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/8/13.
 */

public class DeepLinkActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deeplink);
        WebView webView = findViewById(R.id.deeplink_web);
        webView.loadUrl("file:///android_asset/deeplink.html");
    }
}
