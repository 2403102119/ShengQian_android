package com.lx.whsq.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lx.whsq.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/9/30 0030.
 */

public class MultiAdapter extends RecyclerView.Adapter<MultiAdapter.MyHolder> {
    private Context context;
    private List<Map<String, Object>> list;

    public MultiAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public MultiAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_three, parent, false);
        return new MultiAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MultiAdapter.MyHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
//        if (list == null){
//            return 0;
//        }else {
//            return list.size();
//        }
        return 16;
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        public MyHolder(View itemView) {
            super(itemView);

        }
    }
    private MultiAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(MultiAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClickListener(int firstPosition);


    }
}
