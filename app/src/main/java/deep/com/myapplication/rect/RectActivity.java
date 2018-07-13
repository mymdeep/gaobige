package deep.com.myapplication.rect;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/6/20.
 */

public class RectActivity extends Activity{
    View view;
    Rect rect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rect);
        view = findViewById(R.id.rectview);
        rect = new Rect();
        view.getDrawingRect(rect);
        findViewById(R.id.rect_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Matrix matrix= new Matrix();
                matrix.postTranslate(30,30);
                RectF f = new RectF(rect.left,rect.top,rect.right,rect.bottom);
                matrix.mapRect(f);
                rect = new Rect((int)f.left,(int)f.top,(int)f.right,(int)f.bottom);
                view.setX(rect.centerX()-rect.width()/2);
                view.setY(rect.centerY()-rect.height()/2);
            }
        });
        findViewById(R.id.rect_btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Matrix matrix= new Matrix();
                matrix.postRotate(90,rect.centerX(),rect.centerY());
                RectF f = new RectF(rect.left,rect.top,rect.right,rect.bottom);
                matrix.mapRect(f);
                rect = new Rect((int)f.left,(int)f.top,(int)f.right,(int)f.bottom);
                view.setX(rect.centerX()-rect.width()/2);
                view.setY(rect.centerY()-rect.height()/2);
            }
        });
        findViewById(R.id.rect_btn3).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Matrix matrix= new Matrix();
                matrix.setScale(2,2);
                RectF f = new RectF(rect.left,rect.top,rect.right,rect.bottom);
                matrix.mapRect(f);
                rect = new Rect((int)f.left,(int)f.top,(int)f.right,(int)f.bottom);
                view.setX(rect.centerX()-rect.width()/2);
                view.setY(rect.centerY()-rect.height()/2);
            }
        });
        findViewById(R.id.rect_btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Matrix matrix= new Matrix();
                matrix.postScale(1, -1);   //镜像垂直翻转
                matrix.postScale(-1, 1);   //镜像水平翻转
                RectF f = new RectF(rect.left,rect.top,rect.right,rect.bottom);
                matrix.mapRect(f);
                rect = new Rect((int)f.left,(int)f.top,(int)f.right,(int)f.bottom);
                view.setX(rect.centerX()-rect.width()/2);
                view.setY(rect.centerY()-rect.height()/2);
            }
        });
    }
    }
