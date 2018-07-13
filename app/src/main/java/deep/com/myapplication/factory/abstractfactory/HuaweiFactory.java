package deep.com.myapplication.factory.abstractfactory;

import deep.com.myapplication.factory.Phone;
import deep.com.myapplication.factory.bean.HuaweiPhoneP20;
import deep.com.myapplication.factory.bean.HuaweiPhoneP21;

/**
 * Created by wangfei on 2018/6/21.
 */

public class HuaweiFactory extends AbstractFactory{
    @Override
    public Phone getPhone(String name) {
       if (name.equals("p20")){
           return new HuaweiPhoneP20();
       }else if (name.equals("p21")){
           return new HuaweiPhoneP21();

       }else {
           return null;
       }
    }
}
