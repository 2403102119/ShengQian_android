package com.lx.whsq.cuiadapter;

import android.content.Context;
import android.graphics.Paint;
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
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        View view = LayoutInflater.from(context).inflate(R.layout.item_twoshop, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.tv6.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
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
        TextView tv6;
        public MyHolder(View itemView) {
            super(itemView);
            tv6 =itemView.findViewById(R.id.tv6);

        }
    }
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClickListener(int firstPosition);


    }
}
