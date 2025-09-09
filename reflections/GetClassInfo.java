import java.lang.reflect.*;

public class GetClassInfo {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.util.ArrayList"); // Example, can be replaced with input

        System.out.println("Class: " + clazz.getName());

        System.out.println("\nFields:");
        for (Field f : clazz.getDeclaredFields()) {
            System.out.println(" - " + f);
        }

        System.out.println("\nMethods:");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println(" - " + m);
        }

        System.out.println("\nConstructors:");
        for (Constructor<?> c : clazz.getDeclaredConstructors()) {
            System.out.println(" - " + c);
        }
    }
}
