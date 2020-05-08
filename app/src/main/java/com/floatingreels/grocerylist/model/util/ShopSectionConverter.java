package com.floatingreels.grocerylist.model.util;

import androidx.room.TypeConverter;

public class ShopSectionConverter {
    @TypeConverter
    public static ShopSection stringToShopSection(String sectionAsString) {
        ShopSection sectionAsEnum = ShopSection.valueOf(sectionAsString);
        return sectionAsEnum;
    }
    @TypeConverter
    public static String shopSectionTypeToString(ShopSection sectionAsEnum) {
        String sectionAsString = sectionAsEnum.name();
        return sectionAsString;
    }
}
