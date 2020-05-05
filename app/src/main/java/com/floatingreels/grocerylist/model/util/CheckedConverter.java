package com.floatingreels.grocerylist.model.util;

import androidx.room.TypeConverter;

public class CheckedConverter {
    @TypeConverter
    public static boolean stringToBoolean(String isCheckedAsString) {
        return isCheckedAsString.equals("true");
    }
    @TypeConverter
    public static String booleanToString(boolean isCheckedAsBoolean) {
        return String.valueOf(isCheckedAsBoolean);
    }
}
