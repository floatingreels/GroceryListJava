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

public class BSectionAdapter extends RecyclerView.Adapter<BSectionAdapter.BSectionHolder> {
    private List<Product> items;
    private Application mApplication;

    @NonNull
    @Override
    public BSectionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_product, parent, false);
        return new BSectionAdapter.BSectionHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull BSectionHolder holder, int position) {
        Product currentProduct = items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class BSectionHolder extends RecyclerView.ViewHolder {
        public BSectionHolder(@NonNull View itemView) {
            super(itemView);
            TextView nameTV = itemView.findViewById(R.id.tv_card_name);
            TextView qtyTV = itemView.findViewById(R.id.tv_card_qty);
        }
    }
}
