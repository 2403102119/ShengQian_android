package com.lx.whsq.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lx.whsq.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/10/10 0010.
 */

public class SaleAdapter extends  RecyclerView.Adapter<SaleAdapter.MyHolder> {
    private Context context;
    private List<Map<String, Object>> list;
    public SaleAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;

    }
    @Override
    public SaleAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sale, parent, false);
        return new SaleAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(SaleAdapter.MyHolder holder, final int position) {
         holder.ll_item.setOnClickListener(new View.OnClickListener() {
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
        return 5;
    }


    public class MyHolder extends RecyclerView.ViewHolder {
        LinearLayout ll_item;
        public MyHolder(View itemView) {
            super(itemView);
            ll_item = itemView.findViewById(R.id.ll_item);
        }
    }
    private SaleAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(SaleAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClickListener(int firstPosition);

    }
}
