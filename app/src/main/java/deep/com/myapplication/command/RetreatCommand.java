package deep.com.myapplication.command;

/**
 * Created by wangfei on 2018/6/22.
 */

public class RetreatCommand implements Command{
    private Soldier soldier;
    public RetreatCommand(Soldier soldier){
        this.soldier = soldier;
    }
    @Override
    public void execute() {
       soldier.retreat();
    }
}
