package com.floatingreels.grocerylist.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.floatingreels.grocerylist.ProductViewModel;
import com.floatingreels.grocerylist.R;
import com.floatingreels.grocerylist.model.Product;
import com.floatingreels.grocerylist.ui.util.ASectionAdapter;

import java.util.List;

public class ASectionFragment extends Fragment {
    private ProductViewModel productViewModel;
    private ASectionAdapter aSectionAdapter;
    private AppCompatActivity mContext;

    public ASectionFragment() {
    }

    //factory
    public static ASectionFragment newInstance(){
        return new ASectionFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = (AppCompatActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_section_a, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.rv_section_a);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setHasFixedSize(true);

        aSectionAdapter = new ASectionAdapter(mContext.getApplication());
        recyclerView.setAdapter(aSectionAdapter);

        productViewModel = new ViewModelProvider(mContext).get(ProductViewModel.class);
        productViewModel.getAllProducts().observe(mContext, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                aSectionAdapter.setProducts(products);
            }
        });
        return rootView;
    }
}
