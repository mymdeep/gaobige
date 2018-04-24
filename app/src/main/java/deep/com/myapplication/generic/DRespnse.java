package deep.com.myapplication.generic;

/**
 * Created by wangfei on 2018/3/31.
 */

public class DRespnse extends Response<Dog> {
    public DRespnse(String result) {
        super(result);
    }

    @Override
    public void parseResult() {
        Dog dog = new Dog();
        dog.name = "ww";
        dog.eat = "meat";
        bean = dog;
    }
}
