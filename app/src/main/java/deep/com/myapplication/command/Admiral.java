package deep.com.myapplication.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangfei on 2018/6/22.
 */

public class Admiral {
    private List<Command> commandList = new ArrayList<Command>();
    public void giveCommand(Command command){
        commandList.add(command);
    }
    public void beginExec(){
        for (Command command:commandList){
            command.execute();
        }
        commandList.clear();
    }
}
