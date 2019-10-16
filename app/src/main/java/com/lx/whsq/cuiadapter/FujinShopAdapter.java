package com.lx.whsq.cuiadapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lx.whsq.R;

public class FujinShopAdapter extends RecyclerView.Adapter<FujinShopAdapter.ViewHOlder> {

    @NonNull
    @Override
    public ViewHOlder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHOlder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_shop_youhuiquan,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHOlder viewHOlder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHOlder extends RecyclerView.ViewHolder {

        public ViewHOlder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
