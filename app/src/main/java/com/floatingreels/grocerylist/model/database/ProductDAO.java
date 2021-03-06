package com.floatingreels.grocerylist.model.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.floatingreels.grocerylist.model.Product;

import java.util.List;

@Dao
public interface ProductDAO {
    @Insert
    void insert(Product product);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);

    @Query("DELETE FROM product_table")
    void deleteAll();

    @Query("SELECT * FROM product_table WHERE section = 'SECTION_A' ORDER BY ticked ASC")
    LiveData<List<Product>> showProductsFromSectionA();

    @Query("SELECT * FROM product_table WHERE section = 'SECTION_B' ORDER BY ticked ASC")
    LiveData<List<Product>> showProductsFromSectionB();

    @Query("SELECT * FROM product_table WHERE section = 'SECTION_COOL' ORDER BY ticked ASC")
    LiveData<List<Product>> showProductsFromSectionCool();
}
