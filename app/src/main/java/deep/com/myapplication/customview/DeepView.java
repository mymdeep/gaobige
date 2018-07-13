package deep.com.myapplication.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/5/28.
 */

public class DeepView extends android.support.v7.widget.AppCompatTextView{
    Drawable icon;
    Paint paint;
    Rect rect;
    public DeepView(Context context) {
        super(context);
    }
    public DeepView(Context context, AttributeSet attrs) {

        this(context,attrs,0);
    }

    public DeepView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView, defStyleAttr, 0);
        Log.e(Constant.TAG,"TypedArray:"+a.getIndexCount());
        //自定义属性的数量
        int count = a.getIndexCount();
        for (int i = 0; i <count;i++){
            int attr = a.getIndex(i);
            switch (attr){
                case R.styleable.CustomView_deep_icon:
                    icon = a.getDrawable(attr);

                    break;
                default:
                    break;
            }
        }
        a.recycle();

        paint = new Paint();
        rect = new Rect();
        icon.setBounds(new Rect(0,0,icon.getIntrinsicWidth(),icon.getIntrinsicHeight()));
    }

    /**@info EXACTLY：一般是设置了明确的值或者是MATCH_PARENT

    AT_MOST：表示子布局限制在一个最大值内，一般为WARP_CONTENT

    UNSPECIFIED：表示子布局想要多大就多大，很少使用
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {

        super.onLayout(true, left-1, top-1, right, bottom);
        Log.e(Constant.TAG,"onLayout ");

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e(Constant.TAG,"onMeasure");
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height ;

        paint.setTextSize(getTextSize());
        paint.getTextBounds(getText().toString(), 0, getText().length(), rect);

        if (widthMode == MeasureSpec.EXACTLY)
        {
            width = widthSize;
        } else
        {

            float textWidth = rect.width();
             width = (int) (getPaddingLeft() + textWidth + getPaddingRight()+icon.getIntrinsicWidth());

        }
        if (heightMode == MeasureSpec.EXACTLY)
        {
            height = heightSize;
        } else
        {

           if (rect.height()>icon.getIntrinsicHeight()){
               height = rect.height();
           }
           else {
               height = icon.getIntrinsicHeight();
           }
        }
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        paint.setColor(Color.YELLOW);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),paint);
        paint.setColor(Color.BLACK);
        canvas.drawText(getText().toString(),getPaddingLeft()+icon.getIntrinsicWidth()-rect.left,getPaddingTop()-rect.top,paint);
        icon.draw(canvas);
        Log.e(Constant.TAG,"onDraw");
    }
}
