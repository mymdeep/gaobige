package deep.com.myapplication.factory.normal;

import deep.com.myapplication.factory.Phone;
import deep.com.myapplication.factory.bean.HuaweiPhoneP20;
import deep.com.myapplication.factory.bean.HuaweiPhoneP21;
import deep.com.myapplication.factory.bean.IPhone8S;
import deep.com.myapplication.factory.bean.IPhoneX;

/**
 * Created by wangfei on 2018/6/21.
 */

public class FuShiKangFactory {
    public Phone getPhone(String name){
        if (name.equals("iphone8s")){
            return new IPhone8S();
        }else if (name.equals("iphonex")){
            return new IPhoneX();
        }else if (name.equals("p20")){
            return new HuaweiPhoneP20();
        }else if (name.equals("p21")){
            return new HuaweiPhoneP21();
        }else {
            return null;
        }
    }
}
