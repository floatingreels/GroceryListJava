package com.floatingreels.grocerylist.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.floatingreels.grocerylist.model.util.ShopSection;
@Entity (tableName = "product_table")
public class Product {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int quantity;
    private ShopSection section;
    private boolean ticked;

    @Ignore
    public Product(String name, int quantity, ShopSection section) {
        this.name = name;
        this.quantity = quantity;
        this.section = section;
        ticked = false;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public ShopSection getSection() {
        return section;
    }

    public boolean isTicked() {
        return ticked;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSection(ShopSection section) {
        this.section = section;
    }

    public void setTicked(boolean ticked) {
        this.ticked = ticked;
    }
}
