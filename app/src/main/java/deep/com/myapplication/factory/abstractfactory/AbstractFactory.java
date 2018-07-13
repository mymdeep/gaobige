package deep.com.myapplication.factory.abstractfactory;

import deep.com.myapplication.factory.Phone;

/**
 * Created by wangfei on 2018/6/21.
 */

public abstract class AbstractFactory {
    public abstract Phone getPhone(String name);
}
