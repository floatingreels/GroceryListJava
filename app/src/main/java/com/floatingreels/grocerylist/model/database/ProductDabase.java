package com.floatingreels.grocerylist.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.floatingreels.grocerylist.model.Product;
import com.floatingreels.grocerylist.model.util.ShopSectionConverter;

@Database(entities = Product.class, version = 1, exportSchema = false)
@TypeConverters(ShopSectionConverter.class)
public abstract class ProductDabase extends RoomDatabase {
    private static ProductDabase instance;

    public abstract ProductDAO productDAO();

    //synchronized because only one thread can access method at a time
    //avoids creating multiple instances of database if two different threads are trying to access it
    public static synchronized ProductDabase getInstance(Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ProductDabase.class,
                    "product_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
