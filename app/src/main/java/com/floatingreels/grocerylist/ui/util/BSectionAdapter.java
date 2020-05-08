package com.floatingreels.grocerylist.ui.util;

import android.app.Application;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

public class BSectionAdapter extends RecyclerView.Adapter<BSectionAdapter.BSectionHolder> {

    private List<Product> itemsFromSectionB;
    private List<CardView>cardViewList = new ArrayList<>();
    private Application mApplication;
    private ProductViewModel productViewModel = new ProductViewModel(mApplication);

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
        final Product currentProduct = itemsFromSectionB.get(position);
        CardView currentCardView = holder.cardView;
        cardViewList.add(currentCardView);

        holder.nameTV.setText(currentProduct.getName());
        holder.qtyTV.setText("( x" +currentProduct.getQuantity() + ")" );
        holder.isCheckedCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isTicked) {
                int CARD_TEXT_COLOUR_UNCHECKED = mApplication.getResources().getColor(R.color.primaryTextColor);
                int CARD_TEXT_COLOUR_CHECKED = mApplication.getResources().getColor(R.color.primaryColor);

                if (isTicked) {
                    currentProduct.setChecked(true);
                    holder.nameTV.setTextColor(CARD_TEXT_COLOUR_CHECKED);
                    holder.qtyTV.setTextColor(CARD_TEXT_COLOUR_CHECKED);
                } else {
                    currentProduct.setChecked(false);
                    holder.nameTV.setTextColor(CARD_TEXT_COLOUR_UNCHECKED);
                    holder.qtyTV.setTextColor(CARD_TEXT_COLOUR_UNCHECKED);
                }
            }
        });

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
        return itemsFromSectionB.size();
    }

    public void setProducts(List<Product> products) {
        itemsFromSectionB.clear();
        itemsFromSectionB.addAll(products);
        notifyDataSetChanged();
    }

    class BSectionHolder extends RecyclerView.ViewHolder {

        final TextView nameTV, qtyTV;
        CardView cardView;
        final CheckBox isCheckedCB;
        private final View.OnLongClickListener removeDialogListener = new View.OnLongClickListener() {
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
                                int position = getAdapterPosition();
                                ProductViewModel productViewModel = new ProductViewModel(mApplication);
                                productViewModel.delete(itemsFromSectionB.get(position));
                                Toast.makeText(mApplication, R.string.product_removed, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create()
                        .show();

                return false;
            }
        };

        public BSectionHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.tv_card_name);
            qtyTV = itemView.findViewById(R.id.tv_card_qty);
            isCheckedCB = itemView.findViewById(R.id.chk_card_item);
            cardView = itemView.findViewById(R.id.cv_product);
            cardView.setOnLongClickListener(removeDialogListener);
        }
    }
}
