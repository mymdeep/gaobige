package deep.com.myapplication.sort;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/5/31.
 */

public class SortActivity extends Activity{
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        int a = 1;
        Log.e("sort",a++ + "");
        Log.e("sort",a+"");
        Log.e("sort",++a+"");
        findViewById(R.id.sort_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final int[] origin = {5,4,3,7,2,1};
                insertSort(origin);
            }
        });
        findViewById(R.id.sort_btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final int[] origin = {5,4,3,7,2,1};
                shellSort(origin);
            }
        });
        findViewById(R.id.sort_btn3).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final int[] origin = {5,4,3,7,2,1};
                selectSort(origin);
            }
        });
        findViewById(R.id.sort_btn4).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final int[] origin = {5,4,3,7,2,1};
                heapSort(origin);
            }
        });
        findViewById(R.id.sort_btn5).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final int[] origin = {5,4,3,7,2,1};
                Log.e("sort","初始数组"+arrayToStr(origin));
                quickSort(origin,0,origin.length-1);
                StringBuilder sb = new StringBuilder("快速排序结果：");
                for (int i = 0; i < origin.length; i++) {
                    sb.append(origin[i]).append("  ");
                }
                Log.e("sort", sb.toString());
            }
        });
        findViewById(R.id.sort_btn6).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final int[] origin = {5,4,3,7,2,1};
                bubbleSort(origin);
            }
        });
    }
    public void insertSort(int [] a){
        Log.e("sort","初始数组"+arrayToStr(a));
        for (int i = 1; i<a.length;i++){
            int s = i;
            for (int j = s-1;j>=0;j-- ){
                if (a[j]>a[s]){
                    int temp = a[j];
                    a[j] = a[s];
                    a[s] = temp;
                    s = j;
                }
            }
            Log.e("sort","插入排序——第"+i+"圈："+arrayToStr(a));
        }
        StringBuilder sb = new StringBuilder("插入排序结果：");
        for (int i = 0;i<a.length;i++){
            sb.append(a[i]).append("  ");
        }
        Log.e("sort",sb.toString());
    }
    public void shellSort(int [] a){
        Log.e("sort","初始数组"+arrayToStr(a));
         for (int margin = a.length/2;margin>0;margin=margin/2){
             for (int i = margin;i<a.length;i++){
                 int j = i;
                 while (j-margin>=0&&a[j]<a[j-margin]){
                     int temp = a[j];
                     a[j] = a[j-margin];
                     a[j-margin] = temp;
                     j = j-margin;
                 }
             }
             Log.e("sort","希尔排序——步长"+margin+"时："+arrayToStr(a));
         }
        StringBuilder sb = new StringBuilder("希尔排序结果：");
        for (int i = 0;i<a.length;i++){
            sb.append(a[i]).append("  ");
        }
        Log.e("sort",sb.toString());
    }
    public void selectSort(int [] a){
       for (int i= 0; i<a.length; i++){
            int position = i;
           int min = a[i];
            for (int j = i+1;j< a.length;j++){
                if (a[j]<min){
                    min = a[j];
                    position = j;
                }
            }
            a[position] = a[i];
           a[i] = min;
           Log.e("sort","简单排序——第"+i+"圈："+arrayToStr(a));
       }
        StringBuilder sb = new StringBuilder("简单排序结果：");
        for (int i = 0;i<a.length;i++){
            sb.append(a[i]).append("  ");
        }
        Log.e("sort",sb.toString());
    }
    public void heapSort(int [] a) {
        int i;
        // 构建一个大顶堆
        for (i = a.length / 2 - 1; i >= 0; i--) {
            adjustHeap(a, i, a.length - 1);
            Log.e("sort","堆排序——以父节点"+i+"构建堆"+arrayToStr(a));
        }

        for (i = a.length - 1; i >= 0; i--) {// 将堆顶记录和当前未经排序子序列的最后一个记录交换
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            adjustHeap(a, 0, i - 1);// 将a中前i-1个记录重新调整为大顶堆
            Log.e("sort","堆排序——移除最大值后构建堆"+arrayToStr(a));
        }
        StringBuilder sb = new StringBuilder("堆排序结果：");
        for (int ij = 0; ij < a.length; ij++) {
            sb.append(a[ij]).append("  ");
        }
        Log.e("sort", sb.toString());

    }
    public void bubbleSort(int [] a) {
        Log.e("sort","初始数组"+arrayToStr(a));
        for (int i= 0 ; i <a.length;i++){
           for (int j=0;j<a.length-1-i;j++){
               if (a[j]>a[j+1]){
                   int temp = a[j];
                   a[j] = a[j+1];
                   a[j+1] = temp;
               }
           }
           Log.e("sort","冒泡排序——第"+i+"圈："+arrayToStr(a));

       }
        StringBuilder sb = new StringBuilder("冒泡排序结果：");
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]).append("  ");
        }
        Log.e("sort", sb.toString());

    }
    public void quickSort(int[]a,int start,int end) {

        if(start<end){
            int base=a[start];//这是基准值
            int temp; //中间值
            int i=start;
            int j=end;
            while (i<=j){
                while(a[i]<base&&i<end){
                    i++;
                }
                while(a[j]>base&&j>start){
                    j--;
                }
                if (i<=j){
                    temp = a[i];
                    a[i]= a[j];
                    a[j] = temp;
                    Log.e("sort","快速排序——范围【"+start+","+end+"】:"+arrayToStr(a));
                    i++;
                    j--;
                }
            }
            if (start<j){
                quickSort(a,start,j);
            }
            if (end>i){
                quickSort(a,i,end);
            }

        }

    }

    private void adjustHeap(int[] a, int parent, int len) {
        int temp, j;
        temp = a[parent];
        for (j = 2 * parent; j < len; j *= 2) {// 沿关键字较大的孩子结点向下筛选
            if (j < len && a[j] < a[j + 1])
                ++j; // j为关键字中较大记录的下标
            if (temp >= a[j])
                break;
            a[parent] = a[j];
            parent = j;
        }
        a[parent] = temp;

    }
    public void heapAdjust(int[] a, int parent, int length) {
        int temp = a[parent]; // temp保存当前父节点
        int child = 2 * parent + 1; // 先获得左孩子
        while (child < length) {
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (child + 1 < length && a[child] < a[child + 1]) {
                child++;
            }
            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= a[child])
                break;
            // 把孩子结点的值赋给父结点
            a[parent] = a[child];
            // 选取孩子结点的左孩子结点,继续向下筛选
            parent = child;
            child = 2 * child + 1;
        }
        a[parent] = temp;
        Log.e("sort","堆排序——构建堆"+arrayToStr(a));
    }

    private String arrayToStr(int[] a){
        StringBuilder sb = new StringBuilder();
        for (int i:a){
            sb.append(i).append("   ");
        }
        return sb.toString();
    }
}
