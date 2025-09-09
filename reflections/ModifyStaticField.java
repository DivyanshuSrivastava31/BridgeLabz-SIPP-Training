import java.lang.reflect.*;

class Configuration {
    private static String API_KEY = "12345";
}

public class ModifyStaticField {
    public static void main(String[] args) throws Exception {
        Field field = Configuration.class.getDeclaredField("API_KEY");
        field.setAccessible(true);

        System.out.println("Original API_KEY: " + field.get(null));
        field.set(null, "NEW_API_KEY_98765");
        System.out.println("Modified API_KEY: " + field.get(null));
    }
}
