package deep.com.myapplication.factory.bean;

import android.util.Log;
import deep.com.myapplication.factory.Phone;

/**
 * Created by wangfei on 2018/6/21.
 */

public class HuaweiPhoneP20 implements Phone {
    @Override
    public void desc() {
        Log.e("factory","this is HuaweiPhoneP20");
    }
}
