// Define a class to clone person's attribute
public class Person 
{
    // Initialize a variable to store data
    String name;
    int age;
    String address;

    // Parameterized constructor
    Person(String name, int age, String address)
    {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Copy constructor
    Person(Person p)
    {
        this.name = p.name;
        this.age = p.age;
        this.address = p.address;
    }

    // Display method
    void display()
    {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }

    // Main method to test
    public static void main(String... args)
    {
        Person person1 = new Person("John", 24, "Mumbai");
        Person person2 = new Person(person1); // Using the copy constructor

        System.out.println("Original Person:");
        person1.display();

        System.out.println("\nCopied Person:");
        person2.display();
    }
}