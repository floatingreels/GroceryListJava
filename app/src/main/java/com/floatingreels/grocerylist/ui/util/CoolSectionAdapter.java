package com.floatingreels.grocerylist.ui.util;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.floatingreels.grocerylist.R;
import com.floatingreels.grocerylist.model.Product;

import java.util.List;

public class CoolSectionAdapter extends RecyclerView.Adapter<CoolSectionAdapter.CoolSectionHolder> {

    private Application application;
    private List<Product> items;

    @NonNull
    @Override
    public CoolSectionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_product, parent, false);
        return new CoolSectionHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull CoolSectionHolder holder, int position) {
        Product currentProduct = items.get(position);
        holder.nameTV.setText(currentProduct.getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class CoolSectionHolder extends RecyclerView.ViewHolder {
        private TextView nameTV, qtyTV;
        private Button incrementBtn, decrementBtn;

        public CoolSectionHolder(@NonNull View itemView) {
            super(itemView);
            TextView nameTV = itemView.findViewById(R.id.tv_card_name);
            TextView qtyTV = itemView.findViewById(R.id.tv_card_qty);
        }
    }
}
