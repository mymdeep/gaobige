package deep.com.myapplication.generic;

/**
 * Created by wangfei on 2018/3/31.
 */

public abstract class Response<T> {
    private String result;
    public T bean;
    public Response(String result){
        this.result = result;
        parseResult();
    }
    public abstract void parseResult();

}
