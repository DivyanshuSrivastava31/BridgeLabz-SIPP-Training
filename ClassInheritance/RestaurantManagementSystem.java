// Importing scanner class from util package
import java.util.Scanner;

// Define an interface worker to store model
interface Worker
{
	void performDuties();
}

// Define a class to store details of a person
class Person
{
	String name;
	int id;
}

// Define a class for waiter and chef
class Waiter implements Worker extends Person
{
	int tablesAssigned;
	public Waiter(String name,int id,int tablesAssigned)
	{
		this.name=name;
		this.id=id;
		this.tablesAssigned=tablesAssigned;
	}
	void performDuties()
	{
		System.out.println("Person's Name : "+name);
		System.out.println("Person's Id : "+id);
		System.out.println("Person's Job : Waiter");
		System.out.println("Tables Assigned to the person : "+tablesAssigned);
	}
}

class Chef implements Worker extends Person
{
	int dishesAssigned;
	public Chef(String name,int id,int dishesAssigned)
	{
		this.name=name;
		this.id=id;
		this.dishesAssigned=dishesAssigned;
	}
	void performDuties()
	{
		System.out.println("Person's Name : "+name);
		System.out.println("Person's Id : "+id);
		System.out.println("Person's Job : Chef");
		System.out.println("Dishes Assigned to the person : "+dishesAssigned);
	}
}

// Define a main class
public class RestaurantManagementSystem
{
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		// Input person details from the user
		System.out.println("Enter name and id of the person : ");
		String name=sc.nextLine();
		int id=sc.nextInt();
		System.out.println("Enter if the person is appointed at some tables else 0 : ");
		int tables=sc.nextInt();
		System.out.println("Enter if the person is appointed at some dishes else 0 : ");
		int dishes=sc.nextInt();
		if(tables==0)
		{
			Chef chef = new Chef(name,id,dishes);
			chef.performDuties();
		}
		if(dishes==0)
		{
			Waiter waiter = new Waiter(name,id,tables);
			waiter.performDuties();
		}
	}
}