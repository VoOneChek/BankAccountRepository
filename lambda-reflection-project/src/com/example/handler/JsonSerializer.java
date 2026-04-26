package com.example.handler;

import com.example.annotation.JsonField;
import java.lang.reflect.Field;

public class JsonSerializer {

    public static String toJson(Object obj) {

        StringBuilder json = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();

        boolean first = true;

        for (Field field : fields) {

            if (field.isAnnotationPresent(JsonField.class)) {

                field.setAccessible(true);

                try {
                    Object value = field.get(obj);
                    String name = field.getAnnotation(JsonField.class).name();

                    if (!first) json.append(", ");

                    json.append("\"").append(name).append("\": ");

                    if (value instanceof Number) {
                        json.append(value);
                    } else {
                        json.append("\"").append(value).append("\"");
                    }

                    first = false;

                } 
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        json.append("}");
        return json.toString();
    }
}