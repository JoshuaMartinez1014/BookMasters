package rasmussen.bookmasters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;


public class Books {
	
	private Connection conn = null;
	private Statement st = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public void getAllBooks() { 
		try {
			// connection line to MySql
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bookmasterscollection","root","Josh1234");
			st = conn.createStatement();
			rs = st.executeQuery("select * from books");
			
			// loop through data received
			while (rs.next()) {
				
                int bookId = rs.getInt("book_id");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                
                // Print the data to the console
                System.out.println("Book ID: " + bookId);
                System.out.println("Name: " + name);
                System.out.println("Quantity: " + quantity);
                System.out.println("Price: " + price);
                System.out.println("Category: " + category);
                System.out.println("---------------");
              
			}
			
		} catch (SQLException e) {	
			System.out.println("error grabbing data");
			e.printStackTrace();
		}finally {
            // Close resources in a finally block to ensure they are always closed
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
            	System.out.println("error closing recourses");
                e.printStackTrace();
            }
        }
	}
	
	
	
	public void searchForBook(String bookTitle) {
		LoggerUtility.log(Level.INFO, "searchForBook method called for booktitle: " + bookTitle);
		try {
			// connection line to MySql
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bookmasterscollection","root","Josh1234");
			st = conn.createStatement();
			rs = st.executeQuery("select * from books where name like '%" + bookTitle + "%'");
			
			// check if book was found
			boolean found = false; 
			
			// loop through data received
			while (rs.next()) {
				found = true;
                int bookId = rs.getInt("book_id");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                
                // Print the data to the console
                System.out.println("Book ID: " + bookId);
                System.out.println("Name: " + name);
                System.out.println("Quantity: " + quantity);
                System.out.println("Price: " + price);
                System.out.println("Category: " + category);
                System.out.println();
			}
			
			// If book isnt found
			if (!found) {
				System.out.println("*********************");
				 System.out.println("no results found");
				 System.out.println("*********************");
			}
			
		} catch (SQLException e) {	
			System.out.println("error grabbing data");
			LoggerUtility.log(Level.SEVERE, "error grabbing data: " + e.getMessage());
			e.printStackTrace();
		}finally {
            // Close resources in a finally block to ensure they are always closed
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
            	System.out.println("error closing recourses");
                e.printStackTrace();
            }
        }
	}
	
	
	
	// future functions
	public void searchForCategory() {}
	public void addBook() {}
	public void removeBook() {}
	public void updateBook() {}
	

}
