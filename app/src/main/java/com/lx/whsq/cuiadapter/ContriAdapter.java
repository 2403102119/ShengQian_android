package com.lx.whsq.cuiadapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.lx.whsq.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2019/9/29 0029.
 */

public class ContriAdapter extends RecyclerView.Adapter<ContriAdapter.MyHolder> {
    private Context context;
    private List<Map<String, Object>> list;
    private List<Boolean> ischeck;//控件是否被点击


    public ContriAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;
        ischeck = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ischeck.add(false);
        }

    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contrii_layout, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {

//        ischeck.set(0,true);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.OnItemClickListener(position);
                for(int i = 0; i <ischeck.size();i++){
                    ischeck.set(i,false);
                }
                ischeck.set(position,true);
                notifyDataSetChanged();

            }
        });
        //记录要更改属性的控件
        holder.itemView.setTag(holder.ve_slider);
        //判断改变属性
        if(ischeck.get(position)){
            holder.ve_slider.setBackgroundColor(Color.parseColor("#ffffff"));
        }else{
            holder.ve_slider.setBackgroundColor(Color.parseColor("#ff0000"));
        }

    }

    @Override
    public int getItemCount() {
//        if (list == null){
//            return 0;
//        }else {
//            return list.size();
//        }
        return 10;
    }


    public class MyHolder extends RecyclerView.ViewHolder {
        TextView ve_slider;
        public MyHolder(View itemView) {
            super(itemView);
            ve_slider = itemView.findViewById(R.id.ve_slider);
        }
    }
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClickListener(int firstPosition);


    }
}
