package deep.com.myapplication.hook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;
import deep.com.myapplication.utils.MyQueue;

/**
 * Created by wangfei on 2018/5/15.
 */

public class HookActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hook);

        findViewById(R.id.hook_btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                MyQueue.runInBack(new Runnable() {
                    @Override
                    public void run() {
                        URL url = null;
                        try {
                            url = new URL("https://www.baidu.com");
                            hookHttp(url);
                            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                            connection.setConnectTimeout(8000);
                            connection.setRequestMethod("GET");
                            connection.setReadTimeout(8000);
                            connection.connect();
                            Log.e("hook","connect");
                            if (connection.getResponseCode() == 200){

                                InputStreamReader read=new InputStreamReader(connection.getInputStream());
                                BufferedReader bufferReader=new BufferedReader(read);
                                String str;//读取每一行数据
                                StringBuffer buffer=new StringBuffer();//接受全部数据
                                while((str=bufferReader.readLine())!=null){
                                    buffer.append(str + "\n");
                                }
                                Log.e("hook","success:"+buffer.toString());
                                //关闭连接
                                read.close();
                                connection.disconnect();
                            }else {
                                Log.e("hook","fail");
                            }
                        } catch (MalformedURLException e) {

                            e.printStackTrace();
                        } catch (ProtocolException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });



            }
        });
    }

    private void hookHttp(URL url)  {
        try {
            Class urlClass = Class.forName("java.net.URL");
            Field field = urlClass.getDeclaredField("streamHandler");
            field.setAccessible(true);
            field.set(url,new ProxyURLStreamHandler((URLStreamHandler)field.get(url)));
            Log.e("hook","hookHttp");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
    public class ProxyURLStreamHandler extends URLStreamHandler{
        URLStreamHandler h;

        public ProxyURLStreamHandler(URLStreamHandler h){
            Log.e("hook","URLStreamHandler="+h.getClass().getSimpleName());
            this.h = h;
        }

        @Override
        protected URLConnection openConnection(URL u) throws IOException {
            try {
                Log.e("hook","openConnection");
                Class hnlderClass = Class.forName("java.net.URLStreamHandler");
                Method openMethod = hnlderClass.getDeclaredMethod("openConnection",URL.class);
                openMethod.setAccessible(true);
                HttpsURLConnection httpConnectInstance = (HttpsURLConnection)openMethod.invoke(h,u);
                Log.e("hook","httpConnectInstance="+httpConnectInstance.getClass().getSimpleName());
                ProxyHttpConnect p = new ProxyHttpConnect(u, (HttpsURLConnection)httpConnectInstance);
                return p;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {

                e.printStackTrace();
            }


            return null;
        }
    }
    public class ProxyHttpConnect extends HttpsURLConnection{
        private HttpsURLConnection h;
        public ProxyHttpConnect(URL url,HttpsURLConnection h){
            super(url);
            this.h = h;
        }

        @Override
        public String getCipherSuite() {
            return h.getCipherSuite();
        }

        @Override
        public Certificate[] getLocalCertificates() {
            return h.getLocalCertificates();
        }

        @Override
        public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
            return h.getServerCertificates();
        }

        @Override
        public void disconnect() {
            h.disconnect();
        }

        @Override
        public boolean usingProxy() {
            return  h.usingProxy();
        }

        @Override
        public void connect() throws IOException {
            Map<String, List<String>> headers = h.getHeaderFields();
            for (String key:headers.keySet()){
                Log.e("hook","key:"+key+"   value:"+headers.get(key).get(0));
            }
            h.connect();
        }

        @Override
        public InputStream getInputStream() throws IOException {
            Log.e("hook","inputScream="+h.getInputStream());
            return    h.getInputStream();
        }

        @Override
        public int getResponseCode() throws IOException {
            Log.e("hook","code="+h.getResponseCode());
            return 200;
        }
    }
}
