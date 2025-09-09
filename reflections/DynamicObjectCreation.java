public class DynamicObjectCreation {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Student");
        Object obj = clazz.getDeclaredConstructor().newInstance();

        System.out.println("Object created: " + obj);
    }
}

class Student {
    String name = "John Doe";
    public String toString() {
        return "Student{name='" + name + "'}";
    }
}
