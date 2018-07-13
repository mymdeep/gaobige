package deep.com.myapplication.produce;

/**
 * Created by wangfei on 2018/6/9.
 */

public class ConsumeThread extends Thread {

    private Resource resource3;

    public ConsumeThread(Resource resource) {
        this.resource3 = resource;
        //setName("消费者");
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((long)(1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource3.remove();
        }
    }

}
