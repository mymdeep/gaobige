package deep.com.myapplication.lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/4/6.
 */

public class LActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        findViewById(R.id.list_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> list = new ArrayList<>();
               for (int i = 0;i<1000000;i++){
                   list.add(i+" item");
               }

                long time1 = System.currentTimeMillis();
                for (int i = 10000;i<20000;i++){
                    list.remove(i);
                }

                long time2 = System.currentTimeMillis();
                Log.e("time","ArrayList remove 耗时："+(time2-time1));
                for (int i = 0;i<10000;i++){
                    list.get(i);
                }
                long time3 = System.currentTimeMillis();
                Log.e("time","ArrayList 访问 耗时："+(time3-time2));
            }
        });
        findViewById(R.id.list_btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                LinkedList<String> list = new LinkedList<>();
                for (int i = 0;i<1000000;i++){
                    list.add(i+" item");
                }
                long time1 = System.currentTimeMillis();
                for (int i = 10000;i<20000;i++){
                    list.remove(i);
                }
                long time2 = System.currentTimeMillis();
                Log.e("time","LinkedList remove 耗时："+(time2-time1));
                for (int i = 0;i<10000;i++){
                    list.get(i);
                }
                long time3 = System.currentTimeMillis();
                Log.e("time","LinkedList 访问 耗时："+(time3-time2));
            }
        });
        findViewById(R.id.list_btn3).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<Integer,String > map = new HashMap<>();
                for (int i = 0;i<100;i++){
                    map.put(i,"value"+i);
                }

            }
        });
        findViewById(R.id.list_btn4).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                SparseArray<String > map = new SparseArray<>();
                for (int i = 0;i<100;i++){
                    map.put(i,"value"+i);
                }
            }
        });
        findViewById(R.id.list_btn5).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
