package com.lx.whsq.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.lx.whsq.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/10/10 0010.
 */

public class SelectAdapter extends  RecyclerView.Adapter<SelectAdapter.MyHolder> {
    private Context context;
    private List<Map<String, Object>> list;
    private boolean ischeck = false;
    public SelectAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;

    }
    @Override
    public SelectAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_select, parent, false);
        return new SelectAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(final SelectAdapter.MyHolder holder, final int position) {
         holder.cb_selec.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                onItemClickListener.onCheck(position,ischeck);
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
        LinearLayout ll_store,ll_commodity;
        CheckBox cb_selec;
        public MyHolder(View itemView) {
            super(itemView);
            ll_store = itemView.findViewById(R.id.ll_store);
            ll_commodity = itemView.findViewById(R.id.ll_commodity);
            cb_selec = itemView.findViewById(R.id.cb_selec);

        }
    }
    private SelectAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(SelectAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClickListener(int firstPosition);
        void onCheck(int position, boolean ischeck);

    }
}
