package deep.com.myapplication.produce;

/**
 * Created by wangfei on 2018/6/9.
 */

public class ProduceThread extends Thread {

    private Resource resource;

    public ProduceThread(Resource resource) {
        this.resource = resource;
        //setName("生产者");
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((long)(1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.add(new Object());
        }
    }

}
