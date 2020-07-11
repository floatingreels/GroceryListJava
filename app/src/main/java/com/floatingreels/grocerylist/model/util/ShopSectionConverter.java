package com.floatingreels.grocerylist.model.util;

import androidx.room.TypeConverter;

public class ShopSectionConverter {
    @TypeConverter
    public static ShopSection stringToShopSection(String sectionAsString) {
        return ShopSection.valueOf(sectionAsString);

    }
    @TypeConverter
    public static String shopSectionTypeToString(ShopSection sectionAsEnum) {
         return sectionAsEnum.name();
    }
}
