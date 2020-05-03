package com.floatingreels.grocerylist.ui.util;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.floatingreels.grocerylist.R;
import com.floatingreels.grocerylist.model.Product;

import java.util.ArrayList;
import java.util.List;

public class BSectionAdapter extends RecyclerView.Adapter<BSectionAdapter.BSectionHolder> {

    private List<Product> itemsFromSectionB;
    private List<CardView>cardViewList = new ArrayList<>();
    private Application mApplication;

    public BSectionAdapter(Application application) {
        this.mApplication = application;
        itemsFromSectionB = new ArrayList<>();
    }

    @NonNull
    @Override
    public BSectionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_product, parent, false);
        return new BSectionAdapter.BSectionHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull final BSectionHolder holder, int position) {
        Product currentProduct = itemsFromSectionB.get(position);
        cardViewList.add(holder.cardView);

        holder.nameTV.setText(currentProduct.getName());
        holder.qtyTV.setText("( x" +currentProduct.getQuantity() + ")" );
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int CARD_TEXT_COLOUR_DEFAULT = mApplication.getResources().getColor(R.color.primaryTextColor);
                int CARD_TEXT_COLOUR_CHECKED = mApplication.getResources().getColor(R.color.primaryColor);

                if (holder.nameTV.getCurrentTextColor() == CARD_TEXT_COLOUR_DEFAULT) {
                    holder.nameTV.setTextColor(CARD_TEXT_COLOUR_CHECKED);
                    holder.qtyTV.setTextColor(CARD_TEXT_COLOUR_CHECKED);
                } else {
                    holder.nameTV.setTextColor(CARD_TEXT_COLOUR_DEFAULT);
                    holder.qtyTV.setTextColor(CARD_TEXT_COLOUR_DEFAULT);
                }
                return false;
            }
        });
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

    public Product getProductAtPosition(int position){
        return itemsFromSectionB.get(position);
    }


    class BSectionHolder extends RecyclerView.ViewHolder {

        final TextView nameTV, qtyTV;
        CardView cardView;

        public BSectionHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.tv_card_name);
            qtyTV = itemView.findViewById(R.id.tv_card_qty);
            cardView = itemView.findViewById(R.id.cv_product);
        }
    }
}
