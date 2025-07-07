// Node class
class MovieNode
{
	String movieTitle;
	String director;
	int yearOfRelease;
	double rating;
	MovieNode next,prev;
	public MovieNode(String movieTitle, String director, int yearOfRelease, double rating)
	{
		this.movieTitle=movieTitle;
		this.director=director;
		this.yearOfRelease=yearOfRelease;
		this.rating=rating;
		this.next=null;
		this.prev=null;
	}
}
// Linked list
public class MovieManagementSystem
{
	MovieNode head,tail;
	int getCount()
	{
		int count=0;
		MovieNode current = head;
		while(current!=null)
		{
			count++;
			current=current.next;
		}
		return count;
	}
	void addNodeInTheBeginning(String movieTitle, String director, int yearOfRelease, double rating)
	{
		MovieNode movie = new MovieNode(movieTitle,director,yearOfRelease,rating);
		if(head==null)
		{
			head=tail=movie;
		}
		else
		{
			movie.next=head;
			head.prev=movie;
			head=movie;
		}
	}
	void addNodeInTheEnd(String movieTitle, String director, int yearOfRelease, double rating)
	{
		MovieNode movie = new MovieNode(movieTitle,director,yearOfRelease,rating);
		if(head==null)
		{
			head=tail=movie;
		}
		else
		{
			tail.next=movie;
			movie.prev=tail;
			tail=movie;
		}
	}
	void addNodeInTheMiddle(String movieTitle, String director, int yearOfRelease, double rating,int position)
	{
		MovieNode movie = new MovieNode(movieTitle,director,yearOfRelease,rating);
		MovieNode current=head;
		if(getCount()>position)
		{
			while(position!=0)
			{
				current=current.next;
				position=position-1;
			}
			MovieNode node=current.next;
			current.next=movie;
			movie.prev=current;
			movie.next=node;
			node.prev=movie;
		}
		else
		{
			System.out.println("Invalid position entered");
		}
	}
	void deleteMovie(String movieTitle)
	{
		MovieNode current=head;
		while(current!=null)
		{
			if(current.movieTitle.equalsIgnoreCase(movieTitle))
			{
				if(current==head)
				{
					head=current.next;
					head.prev=null;
				}
				else if(current==tail)
				{
					tail=current.prev;
					tail.next=null;
				}
				else
				{
					current.prev.next=current.next;
					current.next.prev=current.prev;
				}
				return;
			}
			current=current.next;
		}
		System.out.println("No movie with such name is present in the list");
	}
	void searchMovie(String director,double rating)
	{
		MovieNode current=head;
		while(current!=null)
		{
			if(current.director.equalsIgnoreCase(director)||current.rating==rating)
			{
				System.out.println("Movie details : ");
				System.out.println("Movie Name : "+current.movieTitle);
				System.out.println("Movie's Director : "+current.director);
				System.out.println("Movie's Year of release : "+current.yearOfRelease);
				System.out.println("Movie's rating : "+current.rating);
			}
			current=current.next;
		}
	}
	void displayMoviesForward()
	{
		int count=0;
		MovieNode current=head;
		while(current!=null)
		{
			++count;
			System.out.println(count+". Movie details : ");
			System.out.println("Movie Name : "+current.movieTitle);
			System.out.println("Movie's Director : "+current.director);
			System.out.println("Movie's Year of release : "+current.yearOfRelease);
			System.out.println("Movie's rating : "+current.rating);
			current=current.next;
		}
	}
	void displayMoviesReverse()
	{
		int count=0;
		MovieNode current=tail;
		while(current!=null)
		{
			++count;
			System.out.println(count+". Movie details : ");
			System.out.println("Movie Name : "+current.movieTitle);
			System.out.println("Movie's Director : "+current.director);
			System.out.println("Movie's Year of release : "+current.yearOfRelease);
			System.out.println("Movie's rating : "+current.rating);
			current=current.prev;
		}
	}
	void updateMovieDetails(String movieTitle, double rating)
	{
		MovieNode current=head;
		while(current!=null)
		{
			if(current.movieTitle.equalsIgnoreCase(movieTitle))
			{	
				current.rating=rating;
				return;
			}
			current=current.next;
		}
	}
	public static void main(String... args)
	{
		MovieManagementSystem movieManage = new MovieManagementSystem();
		movieManage.addNodeInTheBeginning("Inception", "Christopher Nolan", 2010, 8.8);
		movieManage.addNodeInTheBeginning("The Matrix", "Lana Wachowski", 1999, 8.7);
		movieManage.addNodeInTheEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
		movieManage.addNodeInTheEnd("The Godfather", "Francis Ford Coppola", 1972, 9.2);
		movieManage.addNodeInTheMiddle("Parasite", "Bong Joon-ho", 2019, 8.6, 2);
		
		// Display initial list
		movieManage.displayMoviesForward();
		System.out.println();
		movieManage.displayMoviesReverse();
		System.out.println();
		
		// Delete a movie from the list
		movieManage.deleteMovie("Parasite");
		
		// Update movie ratings
		movieManage.updateMovieDetails("Interstellar",9.0);

		// Search movie details
		movieManage.searchMovie("Christopher Nolan",8.6);
		System.out.println();

		// Display final list
		movieManage.displayMoviesForward();
		System.out.println();
		movieManage.displayMoviesReverse();
		System.out.println();
	}
}