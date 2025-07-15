import java.util.Scanner;
// Concatenate all the strings in a string array
public class ConcatenateStrings
{
	public static void main(String... args)
	{
		Scanner sc = new Scanner(System.in);
		String[] str = new String[5];
		StringBuffer sb = new StringBuffer("");
		for(int i = 0 ; i < 5 ; i++)
		{
			str[i]=sc.nextLine();
			sb.append(str[i]+" ");
		}
		System.out.println(sb);
		
	}
}