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
 * Created by Administrator on 2019/10/10 0010.
 */

public class ShippingAdapter extends  RecyclerView.Adapter<ShippingAdapter.MyHolder>  {
    private Context context;
    private List<Map<String, Object>> list;
    public ShippingAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;

    }
    @Override
    public ShippingAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_shipping, parent, false);
        return new ShippingAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(ShippingAdapter.MyHolder holder, int position) {

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
    private ShippingAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(ShippingAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClickListener(int firstPosition);

    }
}
