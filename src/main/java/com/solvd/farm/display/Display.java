package com.solvd.farm.display;

import com.solvd.farm.menu.AllActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Display {
    public static final Logger LOGGER = LogManager.getLogger(Display.class);

    public static boolean isDisplayable(Class<?> clazz) {
        return clazz.isAnnotationPresent(Displayable.class);

    }

    public static void display(Object object, DisplayType displayType) {
        Class<?> clazz = object.getClass();
        if (isDisplayable(clazz)) {
            Arrays.stream(clazz.getDeclaredMethods())
                    .filter(method -> method.isAnnotationPresent(DisplayMethod.class))
                    .filter(method -> method.getAnnotation(DisplayMethod.class).displayType().equals(displayType))
                    .forEach(method -> {
                        try {
                            method.invoke(object);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        } catch (InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } else {
            LOGGER.warn("class " + clazz + " it's not displayable");
        }
    }

    public static void display(Object object) {
        display(object, DisplayType.DEFAULT);
    }
}
