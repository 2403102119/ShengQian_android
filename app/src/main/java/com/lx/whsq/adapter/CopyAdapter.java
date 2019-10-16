package com.lx.whsq.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lx.whsq.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/10/10 0010.
 */

public class CopyAdapter extends  RecyclerView.Adapter<CopyAdapter.MyHolder> {
    private Context context;
    private List<Map<String, Object>> list;
    private List<String> item_list = new ArrayList<>();
    StaggeredGridLayoutManager layoutManager;
    Copy_itemAdapter copy_itemAdapter;

    public CopyAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;

    }
    @Override
    public CopyAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_copy, parent, false);
        return new CopyAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(CopyAdapter.MyHolder holder, int position) {
        layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        holder.item_recycle.setLayoutManager(layoutManager);
        copy_itemAdapter=new Copy_itemAdapter(context,item_list);
        holder.item_recycle.setAdapter(copy_itemAdapter);

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
        LinearLayout ll_copy;
        RecyclerView item_recycle;
        public MyHolder(View itemView) {
            super(itemView);
            ll_copy = itemView.findViewById(R.id.ll_copy);
            item_recycle = itemView.findViewById(R.id.item_recycle);


        }
    }
    private CopyAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(CopyAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClickListener(int firstPosition);

    }
}
