package deep.com.myapplication.uml.time;

/**
 * Created by wangfei on 2018/7/18.
 */

public class A {
    private B b;
    public void init(){
           b = new B();

    }
    public void exec(){
       int num =  b.getNum();
       b.exec();
       new Thread(new Runnable() {
           @Override
           public void run() {
               b.getNum();
           }
       });
       if (num>0){
           for (int i = 0;i<10;i++){
               b.exec();
           }
       }

    }
}
