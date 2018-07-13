package deep.com.myapplication.factory.abstractfactory;

import deep.com.myapplication.factory.Phone;
import deep.com.myapplication.factory.bean.IPhone8S;
import deep.com.myapplication.factory.bean.IPhoneX;

/**
 * Created by wangfei on 2018/6/21.
 */

public class IphoneFactory extends AbstractFactory{
    @Override
    public Phone getPhone(String name) {
       if (name.equals("iphone8s")){
           return new IPhone8S();
       }else if (name.equals("iphonex")){
           return new IPhoneX();

       }else {
           return null;
       }
    }
}
