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

import java.util.ArrayList;
import java.util.List;

public class BSectionAdapter extends RecyclerView.Adapter<BSectionAdapter.BSectionHolder> {
    private List<Product> itemsFromSectionB;
    private Application mApplication;

    public BSectionAdapter(Application application) {
        this.mApplication = application;
        itemsFromSectionB = new ArrayList<>();
    }


    @NonNull
    @Override
    public BSectionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_product, parent, false);
        return new BSectionAdapter.BSectionHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull BSectionHolder holder, int position) {
        Product currentProduct = itemsFromSectionB.get(position);

        holder.nameTV.setText(currentProduct.getName());
        holder.qtyTV.setText("( x" +currentProduct.getQuantity() + ")" );
    }

    @Override
    public int getItemCount() {
        return itemsFromSectionB.size();
    }

    public void setProducts(List<Product> products) {
        itemsFromSectionB.clear();
        itemsFromSectionB.addAll(products);
        notifyDataSetChanged();
    }

    class BSectionHolder extends RecyclerView.ViewHolder {

        final TextView nameTV, qtyTV;

        public BSectionHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.tv_card_name);
            qtyTV = itemView.findViewById(R.id.tv_card_qty);
        }
    }
}
