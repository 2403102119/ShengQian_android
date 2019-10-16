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
 * Created by Administrator on 2019/10/12 0012.
 */

public class Recharge_recordAdapter extends RecyclerView.Adapter<Recharge_recordAdapter.MyHolder> {
    private Context context;
    private List<Map<String, Object>> list;
    public Recharge_recordAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;

    }
    @Override
    public Recharge_recordAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recharge_record, parent, false);
        return new Recharge_recordAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(Recharge_recordAdapter.MyHolder holder, int position) {

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
    private Recharge_recordAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(Recharge_recordAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClickListener(int firstPosition);

    }
}
