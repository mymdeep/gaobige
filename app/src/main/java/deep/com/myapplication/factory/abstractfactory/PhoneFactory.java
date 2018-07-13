package deep.com.myapplication.factory.abstractfactory;

/**
 * Created by wangfei on 2018/6/21.
 */

public class PhoneFactory {

    public static AbstractFactory getFactory(int type){
            if (type == 0){
                return new IphoneFactory();
            }else {
                return new HuaweiFactory();
            }
    }
}
