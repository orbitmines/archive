package me.O_o_Fadi_o_O.Survival;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
 
import org.bukkit.Bukkit;
 
public class ReflectionUtil {
    public static Object getClass(String name, Object... args) throws Exception {
        Class<?> c = Class.forName(ReflectionUtil.getPackageName() + "." + name);
        int params = 0;
        if (args != null) {
            params = args.length;
        }
        for (Constructor<?> co : c.getConstructors()) {
            if (co.getParameterTypes().length == params) {
                return co.newInstance(args);
            }
        }
        return null;
    }
 
    public static Method getMethod(String name, Class<?> c, int params) {
        for (Method m : c.getMethods()) {
            if (m.getName().equals(name) && m.getParameterTypes().length == params) {
                return m;
            }
        }
        return null;
    }
 
    public static void setValue(Object instance, String fieldName, Object value) throws Exception {
        Field field = instance.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(instance, value);
    }
 
    public static String getPackageName() {
        return "net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
    }
}