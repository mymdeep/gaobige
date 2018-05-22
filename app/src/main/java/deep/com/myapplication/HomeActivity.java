package deep.com.myapplication;

import java.util.ArrayList;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

/**
 * Created by wangfei on 2018/3/31.
 */

public class HomeActivity extends AppCompatActivity {
    public RecyclerView mRecyclerView;
    private HomeAdapter mAdapter;
    private CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle("民间闲散程序员");
        }

        initViews();
        //findViewById(R.id.home_btn1).setOnClickListener(new OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        startActivity(new Intent(HomeActivity.this, CallableActivity.class));
        //    }
        //});
        //findViewById(R.id.home_btn2).setOnClickListener(new OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        startActivity(new Intent(HomeActivity.this, GenericActivity.class));
        //    }
        //});
        //findViewById(R.id.home_btn3).setOnClickListener(new OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        startActivity(new Intent(HomeActivity.this, LActivity.class));
        //    }
        //});
        //findViewById(R.id.home_btn4).setOnClickListener(new OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        startActivity(new Intent(HomeActivity.this, QueueActivity.class));
        //    }
        //});
        //findViewById(R.id.home_btn5).setOnClickListener(new OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        startActivity(new Intent(HomeActivity.this, TimerActivity.class));
        //    }
        //});
        //findViewById(R.id.home_btn6).setOnClickListener(new OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        startActivity(new Intent(HomeActivity.this, ReflectActivity.class));
        //    }
        //});
        //findViewById(R.id.home_btn7).setOnClickListener(new OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        startActivity(new Intent(HomeActivity.this, AnnotationActivity.class));
        //    }
        //});
        //   findViewById(R.id.home_btn8).setOnClickListener(new OnClickListener() {
        //            @Override
        //            public void onClick(View view) {
        //                startActivity(new Intent(HomeActivity.this, TestActivity.class));
        //    }
        //});
        //findViewById(R.id.home_btn9).setOnClickListener(new OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        startActivity(new Intent(HomeActivity.this, PassByActivity.class));
        //    }
        //});
        //findViewById(R.id.home_btn10).setOnClickListener(new OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        startActivity(new Intent(HomeActivity.this, HookActivity.class));
        //    }
        //});
        //findViewById(R.id.home_btn11).setOnClickListener(new OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        startActivity(new Intent(HomeActivity.this, ProxyActivity.class));
        //    }
        //});
        //findViewById(R.id.home_btn12).setOnClickListener(new OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        startActivity(new Intent(HomeActivity.this, DataActivity.class));
        //    }
        //});
    }
    public void initViews(){
        Resources res =getResources();
        String[] intros = res.getStringArray(R.array.intros);
        ArrayList<String> l = new ArrayList<>();
        for (String k:intros){
            l.add(k);
        }
        mAdapter = new HomeAdapter(this,l);
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinationLayout);
        mRecyclerView = (RecyclerView)findViewById(R.id.btn_list);
        mRecyclerView.addItemDecoration(new SpaceItemDecoration(10));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    private class SpaceItemDecoration extends RecyclerView.ItemDecoration {

        private int space;

        public SpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

            super.getItemOffsets(outRect, view, parent, state);
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = space;
            }
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {

        super.onNewIntent(intent);
        if (intent!=null){
            if(intent.getBooleanExtra("exit",false)){
                Log.e("kill","finish");
                this.finish();
            }
        }
    }
}
