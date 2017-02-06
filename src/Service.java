import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Service {
	
	static int id = 0;

	Map<Integer, Book> bookStore = new HashMap<>();
	
	public void selection(){
		System.out.println("Add Book:\t[1]\n"
				+ "Remove Book:\t[2]");
		Scanner sc = new Scanner(System.in);

		try{
			int select = sc.nextInt();
			switch(select){
			case 1:
				addBook();
				break;
			case 2:
				if (bookStore.isEmpty()){
					System.out.println("\nThe Book Store is currently empty, cannot remove books.\n");
					selection();
				}
				else removeBook();
				break;
			default:
				System.out.println("\nSorry, command not recognised.\n");
				selection();
				break;
			}
		}
		
		catch (Exception e){
			System.out.println("\nSorry, command not recognised.\n");
			selection();
		}
		
		sc.close();

		}
	
	public void addBook(){
		Scanner sc = new Scanner(System.in);
		Integer bId = id + 1;
		System.out.println("\nTitle: ");
		String title = sc.nextLine();
		System.out.println("\nAuthor: ");
		String author = sc.nextLine();
		Book book = new Book(bId, title, author);
		bookStore.put(bId, book);
		System.out.println("\nBook Added:: Title: " + title 
				+ ", Author: " + author + ", Id: " + bId + "\n");
		selection();
		sc.close();
	}
	
	public void removeBook(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Id: ");
		int bId = sc.nextInt();
		bookStore.remove(bId);
		selection();
		sc.close();
	}
	
	public void updateBook(){
		
	}
	
}
