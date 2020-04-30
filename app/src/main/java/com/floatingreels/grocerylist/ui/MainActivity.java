package com.floatingreels.grocerylist.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.floatingreels.grocerylist.R;
import com.floatingreels.grocerylist.model.Product;
import com.floatingreels.grocerylist.ui.dialogs.AddProductDialog;
import com.floatingreels.grocerylist.ui.util.TabPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton addProductDialogFAB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.fragment_container);

        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        addProductDialogFAB = findViewById(R.id.fab_add_product_dialog);
        addProductDialogFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });


    }

    private void openDialog(){
        AddProductDialog addProductDialog = new AddProductDialog();
        addProductDialog.show(getSupportFragmentManager(), "Add Product");
    }

}
