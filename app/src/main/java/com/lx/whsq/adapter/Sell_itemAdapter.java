package com.lx.whsq.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lx.whsq.R;

import java.util.List;

/**
 * Created by Administrator on 2019/10/10 0010.
 */

public class Sell_itemAdapter extends  RecyclerView.Adapter<Sell_itemAdapter.MyHolder> {
    private Context context;
    private List<String> list;

    public Sell_itemAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;

    }
    @Override
    public Sell_itemAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_shop_order, parent, false);
        return new Sell_itemAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(Sell_itemAdapter.MyHolder holder, final int position) {
           holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   onItemClickListener.OnItemClickListener(position);
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
        return 1;
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        public MyHolder(View itemView) {
            super(itemView);

        }
    }
    private Sell_itemAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(Sell_itemAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClickListener(int firstPosition);

    }
}
