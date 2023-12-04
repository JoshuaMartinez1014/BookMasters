package rasmussen.bookmasters;

import java.util.Scanner;
import java.util.logging.Level;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to BookMaster's Collection's System!");
		
		// create books instance for functions
        Books books = new Books();
		Scanner kb = new Scanner (System.in);
		char sel = 'q';
			
		// take user input and provide function
		do {
			System.out.println("==========================");
			System.out.println("Enter a to See All Books");
			System.out.println("Enter s to Search For a Book");
			System.out.println("Enter c to Search By Category");
			System.out.println("Enter + to Add a Book");
			System.out.println("Enter - to Remove a Book");
			System.out.println("Enter u to Update a Book");
			System.out.println("Enter q to Exit System");
			System.out.println("==========================");
			
			String userInput = kb.next();
			while (userInput.length() != 1) {
				System.out.println("*********************");
				System.out.println("Please type a single character! ");
				System.out.println("*********************");
				userInput = kb.next();
			}
			
			sel = Character.toLowerCase(userInput.charAt(0));
	
			switch (sel) {
			case 'a':
				LoggerUtility.log(Level.INFO, "getAllBooks method called");
				System.out.println("All Books: ");
				System.out.println("---------------");
				 books.getAllBooks();	
				break;
			case 's':
				System.out.println("Type in Book to Search: ");
				System.out.println("---------------");
				kb.nextLine();
				String bookSearch = kb.nextLine();
				books.searchForBook(bookSearch);
				System.out.println("---------------");
				break;
			case 'c':
				System.out.println("Type in Category to Search: ");
				break;
			case '+':
				System.out.println("Type in Book to Add: ");
				break;
			case '-':
				System.out.println("Type in Book to Remove: ");
				break;
			case 'u':
				System.out.println("Type in Book to Update: ");
				break;
			case 'q':
				System.out.println("System Quit! ");
				break;
			default: 
				System.out.println("Unknown Command.");
			} 	
			
		}while (sel != 'q'); 
			
			
			kb.close();
	}
	
	

}
