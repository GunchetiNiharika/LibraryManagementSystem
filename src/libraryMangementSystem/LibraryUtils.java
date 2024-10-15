package libraryMangementSystem;

import java.util.List;

public class LibraryUtils {
	public static void displayBooks(List<Book> books) {
		if(books.isEmpty()) {
			System.out.println("No Books found");
			return ;
		}
		
	
	for(Book book :books) {
		System.out.println(book.getDetails());
	}

}
}
