package com.example.jsonmapper;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Date;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ObjectToJsonMapper {

    public static String toJson(Object obj) throws IllegalAccessException {
        if (obj == null) return "null";
        Class<?> objClass = obj.getClass();
        if (isWrapperType(objClass)) {
            return obj.toString();
        }
        if (objClass == String.class || objClass == Character.class || isDate(obj)) {
            return "\"" + obj + "\"";
        }
        if (obj instanceof Collection collection) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (Object o : collection) {
                sb.append(toJson(o)).append(", ");
            }
            if (!collection.isEmpty()) {
                sb.deleteCharAt(sb.lastIndexOf(","));
            }
            return sb.append("]").toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        Field[] declaredFields = objClass.getDeclaredFields();
        // will not work with superclass fields (possible to implement it if needed)
        for (Field field : declaredFields) {
            field.setAccessible(true);
            sb.append("\"").append(field.getName()).append("\": ").append(toJson(field.get(obj))).append(", ");
        }
        if (declaredFields.length > 0) {
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        return sb.append("}").toString();
    }

    private static boolean isWrapperType(Class<?> clazz) {
        return clazz == Boolean.class || clazz == Byte.class ||
            clazz == Double.class || clazz == Float.class || clazz == Integer.class ||
            clazz == Long.class || clazz == Short.class;
    }

    public static boolean isDate(Object obj) {
        return obj instanceof Date || obj instanceof LocalDate ||
            obj instanceof LocalDateTime || obj instanceof ZonedDateTime;
    }
}
