package deep.com.myapplication;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import deep.com.myapplication.annotation.AnnotationActivity;
import deep.com.myapplication.callable.CallableActivity;
import deep.com.myapplication.classloader.ClassLoaderActivity;
import deep.com.myapplication.command.CommandActivity;
import deep.com.myapplication.customview.CustomViewActivity;
import deep.com.myapplication.databinding.DataActivity;
import deep.com.myapplication.design.DesignActivity;
import deep.com.myapplication.factory.FactoryActivity;
import deep.com.myapplication.generic.GenericActivity;
import deep.com.myapplication.handler.HandlerActivity;
import deep.com.myapplication.hook.HookActivity;
import deep.com.myapplication.kill.KillActivity;
import deep.com.myapplication.lifecyc.LifeCycActivity;
import deep.com.myapplication.listnode.ListNodeActivity;
import deep.com.myapplication.lists.LActivity;
import deep.com.myapplication.passby.PassByActivity;
import deep.com.myapplication.proxy.ProxyActivity;
import deep.com.myapplication.queues.QueueActivity;
import deep.com.myapplication.reflects.ReflectActivity;
import deep.com.myapplication.services.ServiceActivity;
import deep.com.myapplication.sort.SortActivity;
import deep.com.myapplication.testactivity.TestActivity;
import deep.com.myapplication.timer.TimerActivity;
import deep.com.myapplication.touch.TouchActivity;

/**
 * Created by wangfei on 2018/5/18.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyHolder>{

    List<String> list;
    Context context;
    public HomeAdapter(Context context,List<String> list) {
        super();
        this.list = list;
        this.context =context;
    }



    public interface OnItemClickListener {
        void OnItemClick(View view, int position);

        void OnItemLongClick(View view, int position);
    }
    public HomeAdapter.OnItemClickListener mOnItemClickListener;

    public void SetOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.button_item,
            parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {

        String a = list.get(position);
        String[] ss = a.split("#");
        if(ss.length==2){
            holder.title.setText(ss[0]);
            holder.intro.setText(ss[1]);
        }else {
            holder.title.setText("error");

        }

        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Class<?> c ;
               switch (position){
                   case 0:
                       c = CallableActivity.class;
                       break;
                   case 1:
                       c = AnnotationActivity.class;
                       break;
                   case 2:
                       c = PassByActivity.class;
                       break;
                   case 3:
                       c = HookActivity.class;
                       break;
                   case 4:
                       c = LActivity.class;
                       break;
                   case 5:
                       c = QueueActivity.class;
                       break;
                   case 6:
                       c = TimerActivity.class;
                       break;
                   case 7:
                       c = TestActivity.class;
                       break;
                   case 8:
                       c = GenericActivity.class;
                       break;
                   case 9:
                       c = ReflectActivity.class;
                       break;
                   case 10:
                       c = ProxyActivity.class;
                       break;
                   case 11:
                       c = DataActivity.class;
                       break;
                   case 12:
                       c = KillActivity.class;
                       break;
                   case 13:
                       c = DesignActivity.class;
                       break;
                   case 14:
                       c = LifeCycActivity.class;
                       break;
                   case 15:
                       c = HandlerActivity.class;
                       break;
                   case 16:
                       c = CustomViewActivity.class;
                       break;
                   case 17:
                       c = SortActivity.class;
                       break;
                   case 18:
                       c = ClassLoaderActivity.class;
                       break;
                   case 19:
                       c = TouchActivity.class;
                       break;
                   case 20:
                       c = ServiceActivity.class;
                       break;
                   case 21:
                       c = FactoryActivity.class;
                   case 22:
                       c = CommandActivity.class;
                       break;
                   case 23:
                       c = ListNodeActivity.class;
                       break;
                       default:
                           c = CallableActivity.class;
                           break;
               }

                Intent intent = new Intent(context, c);
               context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView intro;

        public MyHolder(View View) {
            super(View);
            title = (TextView) View.findViewById(R.id.title);
            intro = (TextView) View.findViewById(R.id.intro);

        }
    }
}
