package com.lx.whsq.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
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
 * Created by Administrator on 2019/10/10 0010.
 */

public class SellAdapter extends  RecyclerView.Adapter<SellAdapter.MyHolder> {
    private Context context;
    private List<Map<String, Object>> list;
    private List<String> item_list = new ArrayList<>();
    LinearLayoutManager layoutManager;
    Sell_itemAdapter copy_itemAdapter;
    public SellAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;

    }
    @Override
    public SellAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sell, parent, false);
        return new SellAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(SellAdapter.MyHolder holder, final int position) {
        layoutManager = new LinearLayoutManager(context);
        holder.item_recycle.setLayoutManager(layoutManager);
        copy_itemAdapter=new Sell_itemAdapter(context,item_list);
        holder.item_recycle.setAdapter(copy_itemAdapter);
        copy_itemAdapter.setOnItemClickListener(new Sell_itemAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {
                onItemClickListener.OnItemClickListener(position);
            }
        });
        holder.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              onItemClickListener.onDeliver(position);
            }
        });

    }

    @Override
    public int getItemCount() {
//
//        if (list == null) {
//            return 0;
//        } else {
//            return list.size();
//        }
        return 5;
    }


    public class MyHolder extends RecyclerView.ViewHolder {
        RecyclerView item_recycle;
        TextView button2;
        public MyHolder(View itemView) {
            super(itemView);
            item_recycle = itemView.findViewById(R.id.item_recycle);
            button2 = itemView.findViewById(R.id.button2);
        }
    }
    private SellAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(SellAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClickListener(int firstPosition);
        void onDeliver(int position);

    }
}
