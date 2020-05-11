package com.floatingreels.grocerylist.model.util;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.floatingreels.grocerylist.model.ProductViewModel;

public class ProductViewModelFactory implements ViewModelProvider.Factory {

    private final Application application;

    public ProductViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ProductViewModel.class)) {
            return (T) new ProductViewModel(application);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
