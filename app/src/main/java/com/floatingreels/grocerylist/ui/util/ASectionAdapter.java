package com.floatingreels.grocerylist.ui.util;

import android.app.Application;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.floatingreels.grocerylist.R;
import com.floatingreels.grocerylist.model.Product;
import com.floatingreels.grocerylist.model.ProductViewModel;

import java.util.ArrayList;
import java.util.List;

public class ASectionAdapter extends RecyclerView.Adapter<ASectionAdapter.ASectionHolder> {

    private static final String TAG = "Checked state is :";

    private Application mApplication;
    private ArrayList<Product> itemsFromSectionA;
    private List<CardView>cardViewList = new ArrayList<>();
    private ProductViewModel productViewModel = new ProductViewModel(mApplication);

    public ASectionAdapter(Application application) {
        this.mApplication = application;
        itemsFromSectionA = new ArrayList<>();
    }

    @NonNull
    @Override
    public ASectionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_product, parent, false);
        return new ASectionHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ASectionHolder holder, int position) {

        int CARD_TEXT_COLOUR_UNCHECKED = mApplication.getResources().getColor(R.color.primaryTextColor);
        int CARD_TEXT_COLOUR_CHECKED = mApplication.getResources().getColor(R.color.primaryColor);
        final Product currentProduct = itemsFromSectionA.get(position);
        CardView currentCardView = holder.cardView;
        cardViewList.add(currentCardView);

        holder.nameTV.setText(currentProduct.getName());
        holder.qtyTV.setText("( x" +currentProduct.getQuantity() + ")" );

        if (currentProduct.isTicked()) {
            holder.nameTV.setTextColor(CARD_TEXT_COLOUR_CHECKED);
            holder.qtyTV.setTextColor(CARD_TEXT_COLOUR_CHECKED);
            holder.addToCartIV.setImageResource(R.drawable.ic_check_box_primary_color);
            holder.addToCartIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentProduct.setTicked(false);
                    productViewModel.update(currentProduct);
                    Log.d(TAG, String.valueOf(currentProduct.isTicked()).toUpperCase());

                }
            });
        } else {
            holder.nameTV.setTextColor(CARD_TEXT_COLOUR_UNCHECKED);
            holder.qtyTV.setTextColor(CARD_TEXT_COLOUR_UNCHECKED);
            holder.addToCartIV.setImageResource(R.drawable.ic_check_box_outline_blank);
            holder.addToCartIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentProduct.setTicked(true);
                    productViewModel.update(currentProduct);
                    Log.d(TAG, String.valueOf(currentProduct.isTicked()).toUpperCase());

                }
            });
        }

        currentCardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(v.getContext())
                        .setTitle(R.string.product_remove_item)
                        .setMessage(R.string.confirm_delete)
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                productViewModel.delete(currentProduct);
                                Toast.makeText(mApplication, R.string.product_removed, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create()
                        .show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsFromSectionA.size();
    }

    public void setProducts(List<Product> products) {
        itemsFromSectionA.clear();
        itemsFromSectionA.addAll(products);
        notifyDataSetChanged();
    }

    class ASectionHolder extends RecyclerView.ViewHolder {

        final TextView nameTV, qtyTV;
        final ImageView addToCartIV;
        CardView cardView;

        public ASectionHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.tv_card_name);
            qtyTV = itemView.findViewById(R.id.tv_card_qty);
            cardView = itemView.findViewById(R.id.cv_product);
            addToCartIV = itemView.findViewById(R.id.iv_card_add_to_cart);
        }
    }
}
