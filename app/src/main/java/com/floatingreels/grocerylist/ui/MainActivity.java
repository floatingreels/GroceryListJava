package com.floatingreels.grocerylist.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.floatingreels.grocerylist.R;
import com.floatingreels.grocerylist.model.Product;
import com.floatingreels.grocerylist.model.ProductViewModel;
import com.floatingreels.grocerylist.model.util.ProductViewModelFactory;
import com.floatingreels.grocerylist.ui.dialogs.AddProductDialog;
import com.floatingreels.grocerylist.ui.util.TabPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton addProductDialogFAB;
    private ProductViewModel productViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

        ProductViewModelFactory factory = new ProductViewModelFactory(getApplication());
        productViewModel = new ViewModelProvider(this, factory).get(ProductViewModel.class);
    }

    private void openDialog() {
        AddProductDialog addProductDialog = new AddProductDialog();
        addProductDialog.show(getSupportFragmentManager(), "Add Product");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_delete_all:
                productViewModel.deleteAll();
                Toast.makeText(this, R.string.product_removed_all, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
