package com.floatingreels.grocerylist.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDAO {
    @Insert
    void insert(Product product);

    @Delete
    void delete(Product product);

    @Query("DELETE FROM product_table")
    void deleteAll();

    @Query("SELECT * FROM product_table")
    LiveData<List<Product>> getAllProducts();

    @Query("SELECT * FROM product_table WHERE section = 'SECTION_A'")
    LiveData<List<Product>> showProductsFromSectionA();

    @Query("SELECT * FROM product_table WHERE section = 'SECTION_B'")
    LiveData<List<Product>> showProductsFromSectionB();

    @Query("SELECT * FROM product_table WHERE section = 'SECTION_COOL'")
    LiveData<List<Product>> showProductsFromSectionCool();
}
