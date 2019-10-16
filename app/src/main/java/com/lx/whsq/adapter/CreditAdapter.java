package com.lx.whsq.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lx.whsq.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/10/12 0012.
 */

public class CreditAdapter extends RecyclerView.Adapter<CreditAdapter.MyHolder>{
    private Context context;
    private List<Map<String, Object>> list;
    public CreditAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;

    }
    @Override
    public CreditAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_credit, parent, false);
        return new CreditAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(CreditAdapter.MyHolder holder, final int position) {
            holder.tv_apply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.OnApply(position);
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
        TextView tv_apply;
        public MyHolder(View itemView) {
            super(itemView);
            tv_apply = itemView.findViewById(R.id.tv_apply);
        }
    }
    private CreditAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(CreditAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClickListener(int firstPosition);
        void OnApply(int position);

    }
}
