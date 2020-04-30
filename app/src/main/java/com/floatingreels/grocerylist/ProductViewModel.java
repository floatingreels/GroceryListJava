package com.floatingreels.grocerylist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.floatingreels.grocerylist.model.Product;
import com.floatingreels.grocerylist.model.ProductRepository;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {

    ProductRepository repository;
    private LiveData<List<Product>> allProducts;

    public ProductViewModel(@NonNull Application application) {
        super(application);
        repository = new ProductRepository(application);
        allProducts = repository.getAllProducts();
    }

    public void insert(Product product){
        repository.insert(product);
    }

    public void delete(Product product){
        repository.delete(product);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public LiveData<List<Product>> getAllProducts(){
        return allProducts;
    }
}
