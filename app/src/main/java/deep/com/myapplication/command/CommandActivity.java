package deep.com.myapplication.command;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/6/21.
 */

public class CommandActivity extends Activity {
    private Admiral admiral;
    private Soldier soldier1,soldier2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command);
        admiral = new Admiral();
        soldier1 = new Soldier("士兵一号");
        soldier2 = new Soldier("士兵二号");
        findViewById(R.id.command_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                AttackCommand attackCommand = new AttackCommand(soldier1);
                RetreatCommand retreatCommand = new RetreatCommand(soldier2);
                admiral.giveCommand(attackCommand);
                admiral.giveCommand(retreatCommand);
                admiral.beginExec();
            }
        });
        findViewById(R.id.command_btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                RetreatCommand retreatCommand1 = new RetreatCommand(soldier1);
                RetreatCommand retreatCommand2 = new RetreatCommand(soldier2);
                admiral.giveCommand(retreatCommand1);
                admiral.giveCommand(retreatCommand2);
                admiral.beginExec();

            }
        });
    }
}
