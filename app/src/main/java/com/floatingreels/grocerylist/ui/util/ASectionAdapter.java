package com.floatingreels.grocerylist.ui.util;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.floatingreels.grocerylist.R;
import com.floatingreels.grocerylist.model.Product;

import java.util.List;

public class ASectionAdapter extends RecyclerView.Adapter<ASectionAdapter.ASectionHolder> {

    private Application mApplication;
    private List<Product> items;

    @NonNull
    @Override
    public ASectionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_product, parent, false);
        return new ASectionHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull ASectionHolder holder, int position) {
        Product currentProduct = items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    class ASectionHolder extends RecyclerView.ViewHolder {
        public ASectionHolder(@NonNull View itemView) {
            super(itemView);
            TextView nameTV = itemView.findViewById(R.id.tv_product_name);
            TextView qtyTV = itemView.findViewById(R.id.tv_product_qty);
        }
    }
}
