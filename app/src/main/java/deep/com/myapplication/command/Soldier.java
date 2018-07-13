package deep.com.myapplication.command;

import android.util.Log;

/**
 * Created by wangfei on 2018/6/22.
 */

public class Soldier {
    private String name;
    public Soldier(String name){
        this.name = name;
    }
    public void attack(){
        Log.e("command",name+"开始进攻");
    }
    public void retreat(){
        Log.e("command",name+"开始撤退");
    }
}
