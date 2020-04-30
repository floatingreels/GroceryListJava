package com.floatingreels.grocerylist.model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductRepository {
    private ProductDAO productDAO;
    private LiveData<List<Product>> allProducts;

    public ProductRepository (Application application){
        ProductDabase database = ProductDabase.getInstance(application);
        productDAO = database.productDAO();
        allProducts = productDAO.getAllProducts();
    }

    public void insert(Product product){
        new InsertNoteAsyncTask(productDAO).execute(product);
    }

    public void delete(Product product){
        new DeleteNoteAsyncTask(productDAO).execute(product);
    }

    public void deleteAll(){
        new DeleteAllNotesAsyncTask(productDAO).execute();
    }

    public LiveData<List<Product>> getAllProducts(){
        return allProducts;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Product, Void, Void> {

        private ProductDAO productDAO;

        private InsertNoteAsyncTask(ProductDAO productDAO){
            this.productDAO = productDAO;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDAO.insert(products[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Product, Void, Void> {

        private ProductDAO productDAO;

        private DeleteNoteAsyncTask(ProductDAO productDAO){
            this.productDAO = productDAO;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDAO.delete(products[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void, Void, Void> {

        private ProductDAO productDAO;

        private DeleteAllNotesAsyncTask(ProductDAO productDAO){
            this.productDAO = productDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            productDAO.deleteAll();
            return null;
        }
    }
}
