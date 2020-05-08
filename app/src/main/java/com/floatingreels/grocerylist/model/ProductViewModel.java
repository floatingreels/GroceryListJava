package com.floatingreels.grocerylist.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import java.util.List;

public class ProductViewModel extends AndroidViewModel {

    private ProductRepository repository;
    private LiveData<List<Product>> productsFromSectionA, productsFromSectionB, productsFromSectionCool;

    public ProductViewModel(@NonNull Application application) {
        super(application);
        repository = new ProductRepository(application);
        productsFromSectionA = repository.showProductsFromSectionA();
        productsFromSectionB = repository.showProductsFromSectionB();
        productsFromSectionCool = repository.showProductsFromSectionCool();
    }

    public void insert(Product product){
        repository.insert(product);
    }

    public void update(Product product) {repository.update(product);}

    public void delete(Product product){
        repository.delete(product);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public LiveData<List<Product>> showProductsFromSectionA(){
        return productsFromSectionA;
    }

    public LiveData<List<Product>> showProductsFromSectionB(){
        return productsFromSectionB;
    }

    public LiveData<List<Product>> showProductsFromSectionCool(){
        return productsFromSectionCool;
    }
}
