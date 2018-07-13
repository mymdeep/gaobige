package deep.com.myapplication.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/5/29.
 */

public class DeepGroup extends ViewGroup {
    private boolean isVertical = false;
    public DeepGroup(Context context) {
        super(context);
    }
    public DeepGroup(Context context, AttributeSet attrs) {

        this(context,attrs,0);
    }

    public DeepGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomViewGroup, defStyleAttr, 0);
        int count = a.getIndexCount();
        for (int i = 0; i <count;i++){
            int attr = a.getIndex(i);
            switch (attr){
                case R.styleable.CustomViewGroup_orientation:
                    String s = a.getString(attr);
                    if (!TextUtils.isEmpty(s)&&s.equals("h")){
                        isVertical = false;
                    }else {
                        isVertical = true;
                    }
                    break;
                default:
                    break;
            }
        }
        a.recycle();
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (isVertical){
            int height = 0;
            for (int i = 0; i < getChildCount(); i++) {
                View view = getChildAt(i);
                int childWidth = view.getMeasuredWidth();
                int childHeigth = view.getMeasuredHeight();
                Log.e(Constant.TAG,"111="+childWidth+"  "+childHeigth);
                view.layout(0,height,childWidth,height+childHeigth);
                height = height+childHeigth;
            }
        }else {
            int width = 0;
            for (int i = 0; i < getChildCount(); i++) {
                View view = getChildAt(i);
                int childWidth = view.getMeasuredWidth();
                int childHeigth = view.getMeasuredHeight();
                Log.e(Constant.TAG,"222"+childWidth+"  "+childHeigth);
                view.layout(width,0,width+childWidth,childHeigth);
                width = width+childHeigth;
            }
        }


    }
    public void setVertical(boolean b){
        isVertical = b;
        requestLayout();
    }
    public boolean getVertical(){
        return isVertical ;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            measureChild(childView,widthMeasureSpec,heightMeasureSpec);
        }


    }

}
