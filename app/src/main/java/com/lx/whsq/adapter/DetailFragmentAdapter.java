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
 * Created by Administrator on 2019/10/14 0014.
 */

public class DetailFragmentAdapter extends  RecyclerView.Adapter<DetailFragmentAdapter.MyHolder> {
    private Context context;
    private List<Map<String, Object>> list;
    public DetailFragmentAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;

    }
    @Override
    public DetailFragmentAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_detail_fragment, parent, false);
        return new DetailFragmentAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailFragmentAdapter.MyHolder holder, final int position) {
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
        return 5;
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        public MyHolder(View itemView) {
            super(itemView);

        }
    }
    private DetailFragmentAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(DetailFragmentAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClickListener(int firstPosition);
        void onDeliver(int position);

    }
}
