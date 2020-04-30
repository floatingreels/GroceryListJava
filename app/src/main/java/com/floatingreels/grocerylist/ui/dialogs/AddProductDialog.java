package com.floatingreels.grocerylist.ui.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.floatingreels.grocerylist.R;

public class AddProductDialog extends AppCompatDialogFragment {

    private TextView counterTV;
    private Button incrementCounterBtn, decrementCounterBtn;
    private EditText nameET;
    private int quantity = 1;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_product, null,false);
        builder.setView(dialogView)
                .setTitle(R.string.product_add_title)
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton(R.string.product_add_btn, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (nameET.getText().toString().trim().length() == 0 || quantity < 1){
                            return;
                        }
                        String productName = nameET.getText().toString();
                        Toast.makeText(getActivity(), "New product", Toast.LENGTH_SHORT).show();
                    }
                });

        nameET = dialogView.findViewById(R.id.et_product_name);
        decrementCounterBtn = dialogView.findViewById(R.id.btn_product_decrement);
        incrementCounterBtn = dialogView.findViewById(R.id.btn_product_increment);
        counterTV = dialogView.findViewById(R.id.tv_product_counter);

        decrementCounterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    decrementCounter();
            }
        });
        incrementCounterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementCounter();
            }
        });

        return builder.create();
    }

    private void decrementCounter(){
        if (quantity > 1) quantity--;
        counterTV.setText(String.valueOf(quantity));
    }

    private void incrementCounter(){
        quantity++;
        counterTV.setText(String.valueOf(quantity));
    }

}

