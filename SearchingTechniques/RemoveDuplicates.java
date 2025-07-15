import java.util.HashSet;
import java.util.Scanner;
// Remove duplicates from a string
public class RemoveDuplicates
{
	public static void main(String... args)
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder("");
		HashSet<Character> set = new HashSet<>();
		for(int i = 0 ; i<str.length();i++)
		{
			char ch=str.charAt(i);
			if(set.size()==0)
			{
				set.add(ch);
				sb.append(Character.toString(ch));
			}
			else if(set.contains(ch))
			{
				continue;
			}
			else
			{
				set.add(ch);
				sb.append(Character.toString(ch));
			}
		}
		System.out.println(sb);
	}
}