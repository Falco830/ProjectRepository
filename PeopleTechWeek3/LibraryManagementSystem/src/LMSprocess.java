import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

public class LMSprocess {
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static int currentID = 105;
	private static boolean isStudent = true;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		con = DatabaseConnection.getConnection();
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//homePage();
		loginScreen();
		
	}
	
	
	public static void loginScreen() {
		
		System.out.println("Login(l) or Register(r)");
		Scanner keyboard = new Scanner(System.in);
		String command = keyboard.nextLine();
	
		if(command.equals("l")) {
			//go to login
			login();
		}else if(command.equals("r")) {
			//go to register
			registerUser();
		}
		
	}
	
	public static void login() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Type in  : ");
		
		System.out.println("Type in Username: ");
		//Scanner keyboard = new Scanner(System.in);
		String username = keyboard.nextLine();
		System.out.println("Type in Password: ");
		String password = keyboard.nextLine();
		//keyboard.close();
		
		try {
			rs = stmt.executeQuery("Select * From Login_Table_For_Student WHERE username = '" + username + "' AND LoginPassword = '" + password +"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Bad execution ");
			e.printStackTrace();
		}
		try {
			//System.out.println(rs.next());
			while(rs.next()) {
				if(rs.getString(2).equals(username) && rs.getString(3).equals(password)) {
					System.out.println("Successfull login... Welcome " + username); 
					
					homePage();
					return;
					//global variable = username
				}
			}		
			
			System.out.println("Incorrect login ");
			login();

		}catch(SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}
	
	public static void homePage() {
		System.out.println("__________HOME PAGE__________");
		System.out.println("Add Event (1) "
				+ "\n Register Book (2)"
				+ "\n Search Book (3)"
				+ "\n Issue Book (4)"
				+ "\n Return Book (5)"
				+ "\n Logout (Q)");
		Scanner keyboard = new Scanner(System.in);
		String selection = keyboard.nextLine();
		switch(selection) {
		case "1":
			addEvent();
			break;
		case "2":
			registerBook();
			break;
		case "3":
			searchBook();
			break;
		case "4":
			issueBook();
			break;
		case "5":
			returnBook();
			break;
		case "Q":
			//quit
			break;
		default:
			homePage();		
		}	
	}
	
	public static void registerUser() {
		Scanner keyboard = new Scanner(System.in);
		
		
		System.out.println("Student or Teacher (S,T)");
		String studOrTeacher = keyboard.nextLine();
		
		//System.out.println("Create Libid: ");
		//String libid = keyboard.nextLine();
		System.out.println("Create Regno: ");
		int regno = keyboard.nextInt();
		keyboard.reset();
		String space = keyboard.nextLine();
		System.out.println("Create Branch: ");
		String branch = keyboard.nextLine();
		System.out.println("Create Section: ");
		String section = keyboard.nextLine();
		System.out.println("Create Semester: ");
		String semester = keyboard.nextLine();
		
		System.out.println("Create Username: ");
		String Username = keyboard.nextLine();
		
		System.out.println("Create Password: ");
		String Password = keyboard.nextLine();	
		try {
			int a = stmt.executeUpdate(String.format(
			        "INSERT INTO student (libid, regno, branch, section, semester) VALUES\r\n" + 
			        "(%s, %s, '%s', '%s', '%s')",
			        "auto_increment.nextVal", regno, branch, section, semester));
			System.out.println("Executed: " );
			
			rs = stmt.executeQuery("Select * From Student ORDER BY libid Desc ");
			int libid = 0;
			if(rs.next()) {
				 libid = rs.getInt(1);
			}
			System.out.println(rs.next());
			while(rs.next()) {				
				System.out.println(rs.getInt(1) + " | " + rs.getInt(2) + " | "  + rs.getString(3) + " | " + rs.getString(4) + " | " + rs.getString(5)); 
				//global variable = username
			}
				stmt.executeUpdate(String.format(
			        "INSERT INTO Login_Table_For_Student (logid, Username, LoginPassword, numbooks) VALUES\r\n" + 
			        "( %s, '%s', '%s', %s)",
			        libid, Username, Password, 0));	
	
				rs = stmt.executeQuery("Select * From Login_Table_For_Student ORDER BY logid Desc ");
			while(rs.next()) {				
					System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getInt(4)); 
			}
			loginScreen();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		keyboard.close();
	}
	
	public static void registerBook() {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Please enter Book Name: ");
		String bookName = keyboard.nextLine();
		
		System.out.println("Please enter Author: ");
		String author = keyboard.nextLine();
		
		System.out.println("Please enter Publication: ");
		String publication = keyboard.nextLine();
		
		System.out.println("Please enter Subject: ");
		String subject = keyboard.nextLine();
		
		System.out.println("Please enter NumberOfCopies:");
		int numberOfCopies = keyboard.nextInt();
				
		 try {
			stmt.executeUpdate(String.format(
			        "INSERT INTO Book (Code, bookname, Author, Publication, Subject, no_of_copies) VALUES\r\n" + 
			        "(%s, '%s', '%s', '%s', '%s', %s)",
			        "auto_increment2.nextVal", bookName, author, publication, subject, numberOfCopies));
			rs = stmt.executeQuery("Select * From Book ORDER BY Code Desc ");
			while(rs.next()) {				
					System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getString(4) + " | " + rs.getString(5)+ " | " + rs.getInt(6)); 
			}
			homePage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		keyboard.close();
	}
	
	public static void searchBook() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter Search Type: ");		
		System.out.println("Search by:"
				+ "Bookname (1)"
				+ "Author (2)"
				+ "Publication (3)"
				+ "Subject (4)"
				+ "ID (5)"
				+ "No_of_Copies (6)");
		String searchQuery = keyboard.nextLine();
		String searchColumn = "bookname";	
		switch(searchQuery) {		
		case "1":
			searchColumn = "bookname";
			System.out.println("Please search by BookName: ");	
			 searchQuery = keyboard.nextLine();
			 try {
				 rs = stmt.executeQuery("Select * From Book WHERE " + searchColumn + " = '" + searchQuery + "' ORDER BY Code Desc ");
		
				while(rs.next()) {				
					System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getString(4) + " | " + rs.getString(5)+ " | " + rs.getInt(6)); 
					}
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			homePage();
			break;
		case "2":
			searchColumn = "Author";
			System.out.println("Please search by BookName: ");	
			 searchQuery = keyboard.nextLine();
			break;
		case "3":
			searchColumn = "Publication";
			break;
		case "4":
			searchColumn = "Subject";
			break;
		case "5":
			searchColumn = "Code";
			break;
		case "6":
			searchColumn = "no_of_copies";
			break;	
		default: 
			searchColumn = "bookname";
		}
		keyboard.close();
	}
	
	public static void issueBook() {
		
		System.out.println("Please enter book id that you want to checkout: ");
		Scanner keyboard = new Scanner(System.in);
		String checkoutBook = keyboard.nextLine();
		int specialID = 0;
		int inventorySize = 0;
		 try {
			rs = stmt.executeQuery("Select * From Book WHERE " + "Code = " + String.valueOf(checkoutBook) + " ORDER BY Code Desc ");
	
			System.out.println(rs.getFetchSize());
			if(rs.getFetchSize() != 0) { //if book exists
				if(rs.next()) {
					specialID = rs.getInt(1);
					inventorySize = rs.getInt(6);
				}
				System.out.println("book exists! ");			//then book exists
				
				 
			}else {
				System.out.println("book does not exist! ");	//else book does not exist
				keyboard.close();
				issueBook();
			}
		
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			// while book exists
		
		System.out.println("Check out? (y,n) ");
		String checkout = keyboard.nextLine();
		if(checkout.equals("y")) {
			
			String issueReceipt = "";
			ZoneId zonedId = ZoneId.of( "America/Montreal" );
			LocalDate today = LocalDate.now( zonedId );
			LocalDate dueDate = today.plusDays(7);
			//LocalDate setDate = LocalDate.
			today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			dueDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			//if student 			 
			try {				
				stmt.executeUpdate(String.format(
				        "INSERT INTO Issue_Table (Bookid, studid, issuedate, returndate) VALUES\r\n" + 
				        "(%s, %s, %s, %s)",
				        specialID, currentID, "TO_DATE('" + today + "', 'yyyy-MM-dd')", "TO_DATE('" + dueDate + "', 'yyyy-MM-dd')"));
				rs = stmt.executeQuery("Select * From Issue_Table WHERE Bookid = '" + specialID + "' ");
					
				while(rs.next()) {				
					System.out.println(rs.getInt(1) + " | " + rs.getInt(2) + " | " + rs.getDate(3) + " | " + rs.getDate(4)); 
	
				}								
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//else if teacher
			/*try {				
				stmt.executeUpdate(String.format(
				        "INSERT INTO Issue_Table (Bookid, studid, issuedate, returndate) VALUES\r\n" + 
				        "(%s, %s, %s, %s)",
				        specialID, currentID, "TO_DATE('" + today + "', 'yyyy-MM-dd')", "TO_DATE('" + dueDate + "', 'yyyy-MM-dd')"));
				rs = stmt.executeQuery("Select * From Issue_Table WHERE Bookid = '" + specialID + "' ");
					
				while(rs.next()) {				
					System.out.println(rs.getInt(1) + " | " + rs.getInt(2) + " | " + rs.getDate(3) + " | " + rs.getDate(4)); 
	
				}								
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
			
			
			System.out.println("Book has been checked out: ");
			inventorySize = inventorySize -1;
			try {
				stmt.executeUpdate(String.format(
				        "UPDATE Book SET no_of_copies = %s WHERE Code = %s",
				        inventorySize, specialID));
				
				rs = stmt.executeQuery("Select * From Book WHERE " + "Code = " + String.valueOf(checkoutBook) + " ORDER BY Code Desc ");
				while(rs.next()) {
					System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getString(4) + " | " + rs.getString(5) + " | " + rs.getInt(6));
				}
				homePage();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Return Date Information 
			//Decrement book number of copies
			  
		}else if(checkout.equals("n")) {
			//cancel
			keyboard.close(); 
			homePage();
		}
		keyboard.close();
		
	}
	
	public static void returnBook() {
		System.out.println("Please Enter the bookID to return ");
		Scanner keyboard = new Scanner(System.in);
		int returnBook = keyboard.nextInt();
		try {
			rs = stmt.executeQuery("Select * From Book WHERE " + "Code = " + returnBook + " ORDER BY Code Desc ");
			
			int specialID = 0;
			int inventorySize = 0;
			System.out.println(rs.getFetchSize());
			if(rs.getFetchSize() != 0) { //if book exists
				if(rs.next()) {
					specialID = rs.getInt(1);
					inventorySize = rs.getInt(6);
				}
				System.out.println("Book exists! ");			//then book exists
				System.out.println("Book will be returned... ");
				inventorySize = inventorySize +1;
				stmt.executeUpdate(String.format(
				        "UPDATE Book SET no_of_copies = %s WHERE Code = %s",
				        inventorySize, specialID));
					
				rs = stmt.executeQuery("Select * From Book WHERE " + "Code = " + returnBook + " ORDER BY Code Desc ");
				while(rs.next()) {
					System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getString(4) + " | " + rs.getString(5) + " | " + rs.getInt(6));
				}
				 homePage();
			}else {
				System.out.println("book does not exist! ");	//else book does not exist
				keyboard.close();
				issueBook();
			}
			keyboard.close();
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addEvent() {
		//Not in this method, but in other method for home page,
		//add a view that displays the entire table of each event
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the event information to add event: ");
		System.out.println("Please enter the name: ");
		String name = keyboard.nextLine();
		System.out.println("Please enter the Date: ");
		String date = keyboard.nextLine();
		System.out.println("Please enter the Time: ");
		String time = keyboard.nextLine();
		System.out.println("Please enter the Mname: ");
		String mname = keyboard.nextLine();
		System.out.println("Please enter the Contactno: ");
		int contactno = keyboard.nextInt();
		String extrascanner = keyboard.nextLine();
		System.out.println("Please enter the Email: ");
		
		String email = keyboard.nextLine();
		System.out.println("Please enter the Venue: ");
		String venue = keyboard.nextLine();
		
		 try {
			stmt.executeUpdate(String.format(
			        "INSERT INTO Event_Table (eventid, eventName, eventDate, eventTime, Mname, Contactno,Email,Venue) VALUES\r\n" + 
			        "(%s, '%s', %s, '%s', '%s', %s,'%s', '%s')",
			        "auto_increment2.nextVal", name, "TO_DATE('" + date + "', 'yyyy-MM-dd')", time, mname, contactno,email,venue));
			rs = stmt.executeQuery("Select * From Event_Table ORDER BY eventid Desc ");
			while(rs.next()) {				
					System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getDate(3) + " | " + rs.getString(4) + " | " + rs.getString(5)+ " | " + rs.getInt(6)+ " | " + rs.getString(7)+ " | " + rs.getString(8)); 
			}
			homePage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
