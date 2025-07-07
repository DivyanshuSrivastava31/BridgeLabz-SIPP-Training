// Node class
class TaskNode
{
	int taskId;
	String taskName;
	int priority;
	String dueDate;
	TaskNode next;
	public TaskNode(int taskId, String taskName, int priority, String dueDate)
	{
		this.taskId=taskId;
		this.taskName=taskName;
		this.priority=priority;
		this.dueDate=dueDate;
		this.next=null;
	}
}
// Circular Linked list for managing tasks
public class TaskScheduler
{
	TaskNode head,tail;
	int getSize()
	{
		int count=0;
		TaskNode current=head;
		while(current.next!=head)
		{
			++count;
			current=current.next;
		}
		return count+1;
	}

	void addInTheEnd(int taskId, String taskName, int priority, String dueDate)
	{
		TaskNode task = new TaskNode(taskId,taskName,priority,dueDate);
		if(head==null)
		{
			head=tail=task;
			tail.next=head;
			return;
		}
		tail.next=task;
		task.next=head;
		tail=task;
		
		
	}
	void addInTheBeginning(int taskId, String taskName, int priority, String dueDate)
	{
		TaskNode task = new TaskNode(taskId,taskName,priority,dueDate);
		if(head==null)
		{
			head=tail=task;
			tail.next=head;
			return;
		}
		tail.next=task;
		task.next=head;
		head=task;
	}
	void addInTheMiddle(int taskId, String taskName, int priority, String dueDate, int position)
	{
		TaskNode task = new TaskNode(taskId,taskName,priority,dueDate);
		if(getSize()>position)
		{
			TaskNode current=head;
			while(position!=0)
			{
				current=current.next;
				position=position-1;
			}
			TaskNode node=current.next;
			current.next=task;
			task.next=node;
			
		}
		else
			System.out.println("Invalid position");
	}
	void deleteTask(int taskId)
	{
		if (head == null)
		{
			System.out.println("List is empty");
			return;
		}
	
		TaskNode current = head;
		TaskNode prev = tail;
	
		do
		{
			if (current.taskId == taskId)
			{
				if (current == head)
				{
					if (head == tail) // Only one node
					{
						head = tail = null;
					}
					else
					{
						head = head.next;
						tail.next = head;
					}
				}
				else if (current == tail)
				{
					tail = prev;
					tail.next = head;
				}
				else
				{
					prev.next = current.next;
				}
				return;
			}
			prev = current;
			current = current.next;
		} while (current != head);

		System.out.println("No such task id present in the list");
	}

	void displayTask()
	{
		TaskNode current=head;
		do
		{
			System.out.println("Task Details : ");
			System.out.println("Task Id : "+current.taskId);
			System.out.println("Task Name : "+current.taskName);
			System.out.println("Task priority : "+current.priority);
			System.out.println("Task Due Date : "+current.dueDate);
			current=current.next;
		}while(current!=head);
	}
	void searchTask(int priority)
	{
		TaskNode current=head;
		do
		{
			if(current.priority==priority)
			{
				System.out.println("Task Details : ");
				System.out.println("Task Id : "+current.taskId);
				System.out.println("Task Name : "+current.taskName);
				System.out.println("Task priority : "+current.priority);
				System.out.println("Task Due Date : "+current.dueDate);
				
			}
			current=current.next;
		}while(current!=head);
	}
	public static void main(String... args)
	{
		TaskScheduler schedule = new TaskScheduler();
		schedule.addInTheBeginning(1, "Finish project report", 1, "2025-07-06");
		schedule.addInTheBeginning(2, "Buy groceries", 3, "2025-07-05");
		schedule.addInTheEnd(3, "Schedule dentist appointment", 2, "2025-07-10");
		schedule.addInTheEnd(4, "Prepare for presentation", 1, "2025-07-07");
		schedule.addInTheMiddle(5, "Call bank for statement", 2, "2025-07-08",2);
		// Initial list
		schedule.displayTask();
		System.out.println();
	
		// Delete a task
		 schedule.deleteTask(4);

		// Search a task
		 schedule.searchTask(1);
		 System.out.println();
	
		// Final list
		 schedule.displayTask();
		 System.out.println();
	}
}	