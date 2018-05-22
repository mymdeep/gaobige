package deep.com.myapplication.design.mvvm;

import android.databinding.BaseObservable;

/**
 * Created by wangfei on 2018/5/21.
 */

public class Result extends BaseObservable {
    String r;
    String text;
    public void setR(String r) {
        this.r = r;
        notifyChange();
    }

    public String getR() {
        return r;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
