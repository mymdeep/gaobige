package deep.com.myapplication.uml.clz;

/**
 * Created by wangfei on 2018/7/13.
 */

public abstract class Person {
    private String age="12";
    public  String name;
    public Phone phone;
    public Head head;
    public Glass glass;
    public abstract void work();
    public Person(){
        head = new Head();

    }
    public void setAge(String age) {
        this.age = age;
    }
    protected void run(Shoes shoes){

    }
    private void jump(){

    }
}
