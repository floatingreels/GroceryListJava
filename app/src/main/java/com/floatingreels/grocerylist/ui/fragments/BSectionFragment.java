package com.floatingreels.grocerylist.ui.fragments;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.floatingreels.grocerylist.R;
import com.floatingreels.grocerylist.model.Product;
import com.floatingreels.grocerylist.model.ProductViewModel;
import com.floatingreels.grocerylist.ui.util.ASectionAdapter;
import com.floatingreels.grocerylist.ui.util.BSectionAdapter;

import java.util.List;

public class BSectionFragment extends Fragment {

    private BSectionAdapter bSectionAdapter;
    private ProductViewModel productViewModel;
    private AppCompatActivity mContext;

    public BSectionFragment() {
    }

    //factory
    public static BSectionFragment newInstance(){
        return new BSectionFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = (AppCompatActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_section_b, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.rv_section_b);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setHasFixedSize(true);

        bSectionAdapter = new BSectionAdapter(mContext.getApplication());
        recyclerView.setAdapter(bSectionAdapter);

        productViewModel = new ViewModelProvider(mContext).get(ProductViewModel.class);
        productViewModel.showProductsFromSectionB().observe(mContext, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                bSectionAdapter.setProducts(products);
            }
        });
        return rootView;
    }
}
