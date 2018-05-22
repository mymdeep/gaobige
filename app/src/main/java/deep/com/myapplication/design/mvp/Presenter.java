package deep.com.myapplication.design.mvp;

import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * Created by wangfei on 2018/5/18.
 */

public class Presenter {
    private IView iView;
    private SharedPreferences sp;
    public Presenter(SharedPreferences sp,IView iView) {
        this.iView = iView;
        this.sp = sp;
    }
    public void save(String s){
        if (!TextUtils.isEmpty(s)){
         iView.update(true);
            sp.edit().putString("aa",s).apply();

        }else {
            iView.update(false);
        }
    }
}
