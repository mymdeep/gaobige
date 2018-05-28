package deep.com.myapplication.design.mvpdb;

import android.databinding.BaseObservable;

/**
 * Created by wangfei on 2018/5/21.
 */

public class Display extends BaseObservable {
    String text;

    public void setText(String text) {
        this.text = text;
        notifyChange();
    }

    public String getText() {
        return text;
    }


}
