package deep.com.myapplication.callable;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;
import deep.com.myapplication.utils.MyQueue;

public class CallableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                MyQueue.runInBack(new Runnable() {
                    @Override
                    public void run() {
                        long time1 = System.currentTimeMillis();
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < 10; i++) {
                            if (i % 2 == 0) {
                                sb.append(internetRequestBy1sec());
                            } else {
                                sb.append(internetRequestBy2sec());
                            }
                        }
                        long time2 = System.currentTimeMillis();
                        Log.e("time", "顺序进行网络请求 时间消耗：" + (time2 - time1));
                    }
                });

            }
        });
        findViewById(R.id.btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                MyQueue.runInBack(new Runnable() {
                    @Override
                    public void run() {
                        long time1 = System.currentTimeMillis();
                        Callable<String> callable1 = new Callable<String>() {
                            @Override
                            public String call() throws Exception {

                                return internetRequestBy1sec();
                            }
                        };
                        Callable<String> callable2 = new Callable<String>() {
                            @Override
                            public String call() throws Exception {

                                return internetRequestBy2sec();
                            }
                        };
                        ArrayList<FutureTask<String>> list = new ArrayList<>();
                        for (int i = 0; i < 10; i++) {
                            FutureTask<String> future;
                            if (i % 2 == 0) {
                                future = new FutureTask<String>(callable1);

                            } else {
                                future = new FutureTask<String>(callable2);
                            }
                            new Thread(future).start();
                            list.add(future);
                        }
                        StringBuilder sb = new StringBuilder();
                        for (FutureTask<String> f : list) {
                            try {
                                sb.append(f.get());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                        }
                        long time2 = System.currentTimeMillis();
                        Log.e("time", "Callable + FutureTask 时间消耗：" + (time2 - time1));
                    }
                });

            }
        });
        findViewById(R.id.btn3).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                MyQueue.runInBack(new Runnable() {
                    @Override
                    public void run() {
                        long time1 = System.currentTimeMillis();
                        Callable<String> callable1 = new Callable<String>() {
                            @Override
                            public String call() throws Exception {

                                return internetRequestBy1sec();
                            }
                        };
                        Callable<String> callable2 = new Callable<String>() {
                            @Override
                            public String call() throws Exception {

                                return internetRequestBy2sec();
                            }
                        };
                        ExecutorService threadPool = Executors.newFixedThreadPool(10);
                        ArrayList<Future<String>> list = new ArrayList<>();
                        for (int i = 0; i < 10; i++) {
                            Future<String> future;
                            if (i % 2 == 0) {
                                future = threadPool.submit(callable1);

                            } else {
                                future = threadPool.submit(callable2);
                            }

                            list.add(future);
                        }
                        StringBuilder sb = new StringBuilder();
                        for (Future<String> f : list) {
                            try {
                                sb.append(f.get());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                        }
                        long time2 = System.currentTimeMillis();
                        Log.e("time", "Callable+ Future时间消耗：" + (time2 - time1));
                    }
                });

            }
        });
    }

    private String internetRequestBy1sec() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "1s ";
    }

    private String internetRequestBy2sec() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "2s ";
    }
}
