package deep.com.myapplication.databinding;

import java.util.ArrayList;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;
import deep.com.myapplication.databinding.detail.PersonReal;
/**
 * Created by wangfei on 2018/5/18.
 */

public class DataActivity  extends AppCompatActivity {
    ArrayList<String> list = new ArrayList<>();
    Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list.add("cccccc");
        final ActivityDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data);
         person =  new Person("deep","5");
        final PersonReal realperson =  new  PersonReal("real_deep","5");
        Animal animal = new Animal("cat","5");
        binding.setPerson(person);
        binding.setAnimal(animal);
        person.setSex("male");
        animal.setSex("female");
        realperson.setSex("male");
        binding.setRealperson(realperson);

        binding.setChange(new OnClickListener() {
            @Override
            public void onClick(View v) {
                person.setName("deep 改变");
                binding.setPerson(person);
                realperson.setName("real_deep 改变");
            }
        });
        binding.setList(list);
        binding.setListKey(0);

        //  setContentView(R.layout.activity_main);
    }
}