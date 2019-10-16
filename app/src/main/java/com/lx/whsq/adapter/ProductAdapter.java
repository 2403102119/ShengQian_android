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
 * Created by Administrator on 2019/9/30 0030.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyHolder>  {
    private Context context;
    private List<Map<String, Object>> list;

    public ProductAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public ProductAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.MyHolder holder, final int position) {
    }

    @Override
    public int getItemCount() {
//        if (list == null){
//            return 0;
//        }else {
//            return list.size();
//        }
        return 20;
    }


    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tv_original_price;
        public MyHolder(View itemView) {
            super(itemView);

        }
    }
    private ProductAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(ProductAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClickListener(int firstPosition);


    }
}
