package com.lx.whsq.home2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lx.whsq.R;

public class FujinShopFragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(container.getContext(), R.layout.fujinshopfragment_layout, null);
        final TextView guize = view.findViewById(R.id.guize);
        view.findViewById(R.id.View1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guize.setVisibility(View.VISIBLE);
            }
        });

        return view;

    }
}
