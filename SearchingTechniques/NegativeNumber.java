import java.util.Scanner;
// Search for a negative number using linear Search
public class NegativeNumber
{
	public static void main(String... args)
	{
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		int count=0;
		for(int i = 0 ; i < 10 ; i++)
		{
			arr[i]=sc.nextInt();
			if(arr[i]<0)
			{
				System.out.println(arr[i]);
				count++;
			}
		}
		if(count==0)
			System.out.println("No negative number present in the array");
	}
}