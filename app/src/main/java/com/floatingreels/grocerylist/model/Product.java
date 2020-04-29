package com.floatingreels.grocerylist.model;

import com.floatingreels.grocerylist.model.util.ShopSection;

public class Product {
    private String name;
    private ShopSection section;

    public Product(String name, ShopSection section) {
        this.name = name;
        this.section = section;
    }

    public Product(String name) {
        this.name = name;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public ShopSection getSection() {
        return section;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSection(ShopSection section) {
        this.section = section;
    }


}
