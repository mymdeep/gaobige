package deep.com.myapplication.passby;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import deep.com.myapplication.R;
import deep.com.myapplication.generic.Dog;

/**
 * Created by wangfei on 2018/5/10.
 */

public class PassByActivity  extends Activity {
    private String ps = "privatr str";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passby);

       int i = 10;
        String str = "aa";
        StringBuilder sb = new StringBuilder("ssss");
        Dog dog = new Dog();
        dog.name = "cat";
        Log.e("pass","初始值：i="+i+"  str="+str+"   StringBuilder:"+sb.toString()+"   privateString:"+ps+"   dog name:"+dog.name);
        Log.e("pass","初始值hash：" + "str="+str.hashCode()+"   StringBuilder:"+sb.hashCode()+"   privateString:"+ps.hashCode()+"   Dog="+dog.hashCode()+"   name:"+dog.name.hashCode());

        change(str,i,sb,ps,dog);
        Log.e("pass","改变后：i="+i+"  str="+str+"   StringBuilder:"+sb.toString()+"   privateString:"+ps+"   dog name:"+dog.name);
    }
    private void change(String s,int i,StringBuilder stringBuilder,String ps,Dog dog){
        s = "bb";
        i = 20;
        stringBuilder.append("append");
        ps = ps + " +++";
        Log.e("pass","传入值 hash：" + "str="+s.hashCode()+"   StringBuilder:"+stringBuilder.hashCode()+"   privateString:"+ps.hashCode()+"   Dog="+dog.hashCode()+"   name:"+dog.name.hashCode());
        dog.name = "bee";
    }
}
