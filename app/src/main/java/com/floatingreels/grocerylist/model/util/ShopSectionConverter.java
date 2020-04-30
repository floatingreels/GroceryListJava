package com.floatingreels.grocerylist.model.util;

import androidx.room.TypeConverter;

public class ShopSectionConverter {
    @TypeConverter
    public static ShopSection stringToMuralType(String typeAsString) {
        ShopSection typeAsEnum = ShopSection.valueOf(typeAsString);
        return typeAsEnum;
    }
    @TypeConverter
    public static String muralTypeToString(ShopSection typeAsEnum) {
        String typeAsString = typeAsEnum.name();
        return typeAsString;
    }
}
