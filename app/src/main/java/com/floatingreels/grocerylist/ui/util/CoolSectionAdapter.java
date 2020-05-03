package com.floatingreels.grocerylist.ui.util;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.floatingreels.grocerylist.R;
import com.floatingreels.grocerylist.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CoolSectionAdapter extends RecyclerView.Adapter<CoolSectionAdapter.CoolSectionHolder> {

    private Application mApplication;
    private List<Product> itemsFromSectionCool;
    private List<CardView>cardViewList = new ArrayList<>();

    public CoolSectionAdapter(Application application) {
        this.mApplication = application;
        itemsFromSectionCool = new ArrayList<>();
    }

    @NonNull
    @Override
    public CoolSectionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_product, parent, false);
        return new CoolSectionHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull final CoolSectionHolder holder, int position) {
        Product currentProduct = itemsFromSectionCool.get(position);
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
        return itemsFromSectionCool.size();
    }

    public void setProducts(List<Product> products) {
        itemsFromSectionCool.clear();
        itemsFromSectionCool.addAll(products);
        notifyDataSetChanged();
    }

    public Product getProductAtPosition(int position){
        return itemsFromSectionCool.get(position);
    }

    class CoolSectionHolder extends RecyclerView.ViewHolder {

        private TextView nameTV, qtyTV;
        CardView cardView;

        public CoolSectionHolder(@NonNull View itemView) {

            super(itemView);
            nameTV = itemView.findViewById(R.id.tv_card_name);
            qtyTV = itemView.findViewById(R.id.tv_card_qty);
            cardView = itemView.findViewById(R.id.cv_product);
        }
    }
}
