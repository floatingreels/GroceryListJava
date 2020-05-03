package com.floatingreels.grocerylist.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.floatingreels.grocerylist.R;
import com.floatingreels.grocerylist.model.Product;
import com.floatingreels.grocerylist.model.ProductViewModel;
import com.floatingreels.grocerylist.ui.util.BSectionAdapter;
import com.floatingreels.grocerylist.ui.util.CoolSectionAdapter;

import java.util.List;

public class CoolSectionFragment extends Fragment {

    private CoolSectionAdapter coolSectionAdapter;
    private ProductViewModel productViewModel;
    private AppCompatActivity mContext;

    public CoolSectionFragment() {
    }

    //factory
    public static CoolSectionFragment newInstance(){
        return new CoolSectionFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = (AppCompatActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_section_cool, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.rv_section_cool);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setHasFixedSize(true);

        coolSectionAdapter = new CoolSectionAdapter(mContext.getApplication());
        recyclerView.setAdapter(coolSectionAdapter);

        productViewModel = new ViewModelProvider(mContext).get(ProductViewModel.class);
        productViewModel.showProductsFromSectionCool().observe(mContext, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                coolSectionAdapter.setProducts(products);
            }
        });
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                productViewModel.delete(coolSectionAdapter.getProductAtPosition(viewHolder.getAdapterPosition()));
                Toast.makeText(mContext, R.string.product_removed, Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);
        return rootView;
    }
}
