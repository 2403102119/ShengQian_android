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
 * Created by Administrator on 2019/10/11 0011.
 */

public class AllorderAdapter extends  RecyclerView.Adapter<AllorderAdapter.MyHolder>  {
    private Context context;
    private List<Map<String, Object>> list;
    public AllorderAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;

    }
    @Override
    public AllorderAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_allorder, parent, false);
        return new AllorderAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(AllorderAdapter.MyHolder holder, final int position) {
      holder.ll_voucher_details.setOnClickListener(new View.OnClickListener() {
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
        LinearLayout ll_voucher_details;
        public MyHolder(View itemView) {
            super(itemView);
            ll_voucher_details = itemView.findViewById(R.id.ll_voucher_details);
        }
    }
    private AllorderAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(AllorderAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClickListener(int firstPosition);


    }
}
