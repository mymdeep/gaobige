package deep.com.myapplication.listnode;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/6/26.
 */

public class ListNodeActivity  extends Activity {
    class ListNode{
        public int value;
        public ListNode next;
    }
    private ListNode header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listnode);
        initListNode();
        print(header);
        findViewById(R.id.listnode_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                header = reverse1(header);
                print(header);
                header = reverse2(header);
                print(header);

            }
        });
        findViewById(R.id.listnode_btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                header = reverse1(header);
                print(header);
                header = reverse2(header);
                print(header);

            }
        });
    }
    private ListNode reverse1(ListNode node){
        if (node == null || node.next==null){
            return node;
        }
        ListNode h = reverse1(node.next);
        node.next.next = node;
        node.next = null;
        return h;
    }
    private ListNode reverse2(ListNode node){
        if (node == null ){
            return node;
        }
        ListNode pre = node;
        ListNode cur = node.next;
        ListNode tmp;
        while (cur!=null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        node.next = null;
        return pre;
    }
    private void initListNode(){
       header = new ListNode();
       header.value = 0;
       ListNode p = header;
        for (int  i = 1;i<10;i++){
            ListNode l = new ListNode();
            l.value = i;
            p.next = l;
            p = l;
        }
    }

    /**打印链表
     * @param l
     */
    private void print(ListNode l){
        Log.e("listnode","链表内容");
        while (l!=null){
            Log.e("listnode",l.value+"");
            l = l.next;
        }
        Log.e("listnode","*******************");
    }
}
