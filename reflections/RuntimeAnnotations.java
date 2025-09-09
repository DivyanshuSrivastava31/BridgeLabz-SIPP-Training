import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

@Author(name="Divyanshu Srivastava")
class Book {}

public class RuntimeAnnotations {
    public static void main(String[] args) {
        Class<Book> clazz = Book.class;

        if (clazz.isAnnotationPresent(Author.class)) {
            Author author = clazz.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        }
    }
}
