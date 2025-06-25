// Define a class to check if the string is palindrome or not
public class PalindromeChecker
{
	// Initialize a variable to store the text
	private String text;
	private boolean result;
	// Define a constructor to retrieve value of attributes
	public PalindromeChecker(String text)
	{
		this.text=text;
	}
	// Method to check if the string is palindrome or not
	public void checkPalindrome()
	{
		StringBuilder sb = new StringBuilder(this.text);
		StringBuilder rev=new StringBuilder(this.text.reverse());
		if(rev.equals(sb))
		{
			this.result=true;
		}
		else
		{
			this.result=false;
		}
	}
	public void deisplayResult();
	{
		if(this.result)
		System.out.println("Yes, the text is palindrome");
		else
		System.out.println("No, the text is not a palindrome");
	}
}