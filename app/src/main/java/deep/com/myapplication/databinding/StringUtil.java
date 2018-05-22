package deep.com.myapplication.databinding;

/**
 * Created by wangfei on 2018/5/18.
 */

public class StringUtil {
    public static String cut( String word) {
        if (word.length()>4){
            word = word.substring(0,4);

        }
        return word;
    }
}
