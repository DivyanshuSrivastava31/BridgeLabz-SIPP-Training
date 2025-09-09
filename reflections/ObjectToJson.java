import java.lang.reflect.*;

class Employee {
    String name = "John";
    int salary = 5000;
}

public class ObjectToJson {
    public static String toJson(Object obj) throws Exception {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            json.append("\"").append(fields[i].getName()).append("\": \"").append(fields[i].get(obj)).append("\"");
            if (i < fields.length - 1) json.append(", ");
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws Exception {
        Employee emp = new Employee();
        System.out.println(toJson(emp));
    }
}
