package com.lx.whsq.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lx.whsq.R;
import com.lx.whsq.cuiadapter.MultiAdapter;
import com.lx.whsq.cuiadapter.ProductAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Home1FragmentTab3 extends Fragment {

    @BindView(R.id.top)
    RecyclerView top;
    @BindView(R.id.bottom)
    RecyclerView bottom;
    Unbinder unbinder;

    MultiAdapter multiAdapter;
    ProductAdapter productAdapter;
    List<Map<String, Object>> list2 = new ArrayList<>();
    List<Map<String, Object>> list3 = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(container.getContext(), R.layout.index3allfragment, null);
        unbinder = ButterKnife.bind(this, view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 5);
        top.setLayoutManager(gridLayoutManager);
        multiAdapter = new MultiAdapter(getContext(), list2);
        top.setAdapter(multiAdapter);
        multiAdapter.setOnItemClickListener(new MultiAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {


            }


        });

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        bottom.setLayoutManager(staggeredGridLayoutManager);
        productAdapter = new ProductAdapter(getContext(), list3);
        bottom.setAdapter(productAdapter);
        productAdapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int firstPosition) {


            }

        });


        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
