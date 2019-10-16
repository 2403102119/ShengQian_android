package com.lx.whsq.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lx.whsq.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/10/12 0012.
 */

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.MyHolder> {
    private Context context;
    private List<Map<String, Object>> list;

    private List<Map<String, Object>> item_list = new ArrayList<>();
    LinearLayoutManager layoutManager;
    ShopcarAdapter shopcarAdapter;

    public ShoppingAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public ShoppingAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_shopping, parent, false);
        return new ShoppingAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(ShoppingAdapter.MyHolder holder, int position) {
        layoutManager = new LinearLayoutManager(context);
        holder.re_two.setLayoutManager(layoutManager);
        shopcarAdapter=new ShopcarAdapter(context,item_list);
        holder.re_two.setAdapter(shopcarAdapter);

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
        RecyclerView re_two;
        public MyHolder(View itemView) {
            super(itemView);
            re_two = itemView.findViewById(R.id.re_two);
        }
    }
    private ShoppingAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(ShoppingAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClickListener(int firstPosition);

    }
}
