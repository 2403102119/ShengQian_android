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

public class Copy_itemAdapter extends  RecyclerView.Adapter<Copy_itemAdapter.MyHolder> {
    private Context context;
    private List<String> list;

    public Copy_itemAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;

    }
    @Override
    public Copy_itemAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_item_copy, parent, false);
        return new Copy_itemAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(Copy_itemAdapter.MyHolder holder, int position) {

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
    private Copy_itemAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(Copy_itemAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClickListener(int firstPosition);

    }
}
