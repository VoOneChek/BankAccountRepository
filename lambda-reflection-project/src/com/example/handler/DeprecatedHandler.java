package com.example.handler;

import com.example.annotation.DeprecatedEx;
import java.lang.reflect.Method;

public class DeprecatedHandler {

    public static void check(Class<?> clazz) {

        if (clazz.isAnnotationPresent(DeprecatedEx.class)) {
            DeprecatedEx ann = clazz.getAnnotation(DeprecatedEx.class);
            System.out.println("! класс '" + clazz.getSimpleName() + "' устарел - альтернатива: " + ann.message());
        }

        for (Method m : clazz.getDeclaredMethods()) {
            if (m.isAnnotationPresent(DeprecatedEx.class)) {
                DeprecatedEx ann = m.getAnnotation(DeprecatedEx.class);
                System.out.println("! метод '" + m.getName() + "' устарел - альтернатива: " + ann.message());
            }
        }
    }
}