// Define classes to display animal hierarchy
class Animal
{
	String name;
	int age;
	void makeSound()
	{
		System.out.println("Animals make sound");
	}
}

// Define sub classes dog , cat ,bird
class Dog extends Animal
{
	void makeSound()
	{
		System.out.println("Dog makes sound");
	}
}
class Cat extends Animal
{
	void makeSound()
	{
		System.out.println("Cat makes Sound");
	}
}
class Bird extends Animal
{
	void makeSound()
	{
		System.out.println("Birds make Sound");
	}
}

// Defining main class
public class AnimalHierarchy
{
	public static void main(String... args)
	{
		Cat cat = new Cat();
		cat.makeSound();
		Dog dog = new Animal();
		dog.makeSound();
	}
}