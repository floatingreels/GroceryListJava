package com.floatingreels.grocerylist.ui.util;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.floatingreels.grocerylist.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    private TextView nameTV;
    private TextView qtyTV;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTV = itemView.findViewById(R.id.tv_product_name);
        qtyTV = itemView.findViewById(R.id.tv_product_qty);
    }
}
