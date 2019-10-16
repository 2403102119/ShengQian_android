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
 * Created by Administrator on 2019/10/11 0011.
 */

public class NotonAdapter extends  RecyclerView.Adapter<NotonAdapter.MyHolder>  {
    private Context context;
    private List<Map<String, Object>> list;
    public NotonAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;

    }
    @Override
    public NotonAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_noton, parent, false);
        return new NotonAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(NotonAdapter.MyHolder holder, final int position) {

        holder.tv_redact.setOnClickListener(new View.OnClickListener() {
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
        TextView tv_redact;
        public MyHolder(View itemView) {
            super(itemView);
            tv_redact = itemView.findViewById(R.id.tv_redact);
        }
    }
    private NotonAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(NotonAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClickListener(int firstPosition);


    }
}
