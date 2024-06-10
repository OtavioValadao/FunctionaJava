package utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Utils {


    public static Object getFieldValue(Object obj, String key) {
        try {
            Class<?> clazz = obj.getClass();
            var field = clazz.getDeclaredField(key);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /***
     * Needs the empty constructor
     */
    public static <T> T createNewInstance(Class<T> clazz, Map<String, Object> propertyValues) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();
            for (Field field : getAllFields(clazz)) {
                field.setAccessible(true);
                Object value = propertyValues.get(field.getName());
                if (value != null) {
                    field.set(instance, value);
                }
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static Field[] getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        Class<?> currentClass = clazz;

        while (currentClass != null) {
            fields.addAll(Arrays.asList(currentClass.getDeclaredFields()));
            currentClass = currentClass.getSuperclass();
        }
        return fields.toArray(new Field[0]);
    }

}
