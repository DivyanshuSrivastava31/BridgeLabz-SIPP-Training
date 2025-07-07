// Node class
class StudentNode
{
	int rollNumber;
	String name;
	int age;
	String grade;
	StudentNode next;
	public StudentNode(int rollNumber, String name, int age, String grade)
	{
		this.rollNumber=rollNumber;
		this.name=name;
		this.age=age;
		this.grade=grade;
		this.next=null;
	}
}
// Linked list 
public class StudentRecordManagement
{
	StudentNode head,tail;
	// To find the Length of Linked List
	public int getSize()
	{
		int count=0;
		StudentNode current=head;
		while(current.next!=null)
		{
			count++;
			current=current.next;
		}
		return count;
	}
	// Add a node in the end
	public void addNodeInTheEnd(int rollNumber, String name, int age, String grade)
	{
		StudentNode student = new StudentNode(rollNumber,name,age,grade);
		if(head==null)
		{
			head=tail=student;
			return;
		}
		tail.next = student;
                tail = student;
	}
	// Add a node at the beginning
	public void addNodeInTheBeginning(int rollNumber, String name, int age, String grade)
	{
		StudentNode student = new StudentNode(rollNumber,name,age,grade);
                if(head==null)
		{
			head=tail=student;
			return;
		}
		student.next=head;
		head=student;
	}
	// Add a node in the middle
	public void addNodeInTheMiddle(int rollNumber, String name, int age, String grade, int position)
	{
		StudentNode student = new StudentNode(rollNumber,name,age,grade);
		if(head==null)
		{
			head=student;
			return;
		}
		else if(getSize()>position)
		{
			StudentNode current=head;
			while(position!=0)
			{
				position--;
				current=current.next;
			}
			StudentNode newNode=current.next;
			current.next=student;
			student.next=newNode;
		}
		else
		{
			System.out.println("Invalid Position");
		}
	}
	// Delete a record
	public void deleteRecord(int rollNumber)
	{
		StudentNode current=head;
		while(current.next!=null)
		{
			if(current.rollNumber==rollNumber)
			{
				current.next=current.next.next;
				break;
			}
			current=current.next;
		}
	}
	// Search a student's record
	public void searchRecord(int rollNumber)
	{
		StudentNode current=head;
		while(current.next!=null)
		{
			if(current.rollNumber==rollNumber)
			{
				System.out.println("Student Record : ");
				System.out.println("Student's roll number : "+ current.rollNumber);
				System.out.println("Student's Name : "+current.name);
				System.out.println("Student's Age : "+current.age);
				System.out.println("Student's Grade : "+current.grade);
				return;
			}
			current=current.next;
		}
		System.out.println("No such student present in the record with such roll number");
	}
	// Display all the record
	public void displayRecords()
	{
		int count=0;
		StudentNode current=head;
		while(current.next!=null)
		{
			++count;
			System.out.println(count+". Student's record : ");
			System.out.println("Student's roll number : "+ current.rollNumber);
			System.out.println("Student's Name : "+current.name);
			System.out.println("Student's Age : "+current.age);
			System.out.println("Student's Grade : "+current.grade);
			current=current.next;
		}
		++count;
		System.out.println(count+". Student's record : ");
		System.out.println("Student's roll number : "+ current.rollNumber);
		System.out.println("Student's Name : "+current.name);
		System.out.println("Student's Age : "+current.age);
		System.out.println("Student's Grade : "+current.grade);

	}
	// Update grade in a record
	public void updateGrade(String grade,int rollNumber)
	{
		StudentNode current=head;
		while(current.next!=null)
		{
			if(current.rollNumber==rollNumber)
			{
				current.grade=grade;
				return;
			}
			current=current.next;
		}
		System.out.println("No such student present in the record with such roll number");
	}
	// Main method
	public static void main(String... args)
	{
		StudentRecordManagement student = new StudentRecordManagement();
		
		// Adding a record
		student.addNodeInTheBeginning(13,"Amritanshu Gupta",21,"A");
		student.addNodeInTheEnd(1,"Aditya Singh",20,"B+");
		student.addNodeInTheEnd(3,"Aman Gupta",21,"A");
		student.addNodeInTheBeginning(4,"Aman Pandey",21,"B");
		student.addNodeInTheMiddle(2,"Aditya Sinha",21,"A",2);
		
		// Displaying all the records
		student.displayRecords();	
	
		// Deleting a record
		student.deleteRecord(1);
		
		// Searching a record
		student.searchRecord(13);

		// Updating grade of a record
		student.updateGrade("A+",13);

		// Displaying final records
		student.displayRecords();
	}
}