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
 * Created by Administrator on 2019/6/26.
 */

public class ParticularsAdapter extends  RecyclerView.Adapter<ParticularsAdapter.MyHolder> {
    private Context context;
    private List<Map<String, Object>> list;
    public ParticularsAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;

    }
    @Override
    public ParticularsAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.particulars, parent, false);
        return new ParticularsAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(ParticularsAdapter.MyHolder holder, int position) {

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
    private ParticularsAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(ParticularsAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClickListener(int firstPosition);

    }
}
