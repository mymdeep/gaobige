package deep.com.myapplication.reflects;

import android.util.Log;

/**
 * Created by wangfei on 2018/4/26.
 */

public class DeepReflect extends DeepFather implements DeepInterface {
    private String id ;
    private String name;

    public String b = "bbb";
    public static String c = "ccc";
    public DeepReflect( ){
        Log.e("reflect","无参数构造函数");
    }

    public DeepReflect( String id ){
        Log.e("reflect","单参数构造函数");

        this.id = id ;
    }
    public DeepReflect( String id ,String name){
        Log.e("reflect","多参数构造函数");
        this.id = id ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public static void update(){
        Log.e("reflect","静态方法执行");
    }

    @Override
    public void Deep() {

    }
}
