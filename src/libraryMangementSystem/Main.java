package libraryMangementSystem;
import java.util.Scanner;
 public class Main {
    public static void main(String[] args) throws BookNotFoundException {
        Library library = new Library();
Scanner scanner = new Scanner(System.in);
 
        // Sample Data
        library.addBook(new Book("1984", "George Orwell", "123456789"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "987654321"));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "543216789"));
 
        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Find Book by ISBN");
            System.out.println("3. Remove Book");
            System.out.println("4. List All Books");
            System.out.println("5. Sort Books by Title");
            System.out.println("6. Sort Books by Author");
            System.out.println("7. Sort Books by ISBN");
            System.out.println("8. Search Books by Title/Author");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
 
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
 
            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    try {
                        library.addBook(new Book(title, author, isbn));
                        System.out.println("Book added.");
                    } catch (BookAlreadyExistsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter ISBN to find: ");
                    String findIsbn = scanner.nextLine();
				//Book foundBook = library.findBookByIsbn(findIsbn).get();
				try {
					Book foundBook =  library.findBookByIsbn(findIsbn);
					System.out.println("Found: " + foundBook.getDetails());
				}catch(BookNotFoundException e){
					System.out.println(e.getMessage());
					
				}
				        //.orElseThrow(() -> new BookNotFoundException("Book not found."));
				//System.out.println("Found: " + foundBook.getDetails());
                    break;
                case 3:
                    System.out.print("Enter ISBN to remove: ");
                    String removeIsbn = scanner.nextLine();
                    try {
				library.removeBook(removeIsbn);
				System.out.println("Book removed.");
                    }
                    catch(BookNotFoundException e) {
                    	System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("All Books:");
                    LibraryUtils.displayBooks(library.getAllBooks());
                    break;
                case 5:
                    System.out.println("Books sorted by title:");
                    LibraryUtils.displayBooks(library.sortBooksByTitle());
                    break;
                case 6:
                    System.out.println("Books sorted by author:");
                    LibraryUtils.displayBooks(library.sortBooksByAuthor());
                    break;
                case 7:
                    System.out.println("Books sorted by ISBN:");
                    LibraryUtils.displayBooks(library.sortBooksByIsbn());
                    break;
                case 8:
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.nextLine();
                    System.out.println("Search Results:");
                    LibraryUtils.displayBooks(library.searchBooks(keyword));
                    break;
                case 9:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
