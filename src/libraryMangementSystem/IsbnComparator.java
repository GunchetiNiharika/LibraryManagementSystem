package libraryMangementSystem;

import java.util.Comparator;

public class IsbnComparator implements Comparator<Book> { 
	@Override
	public int compare(Book b1,Book b2) {
		return b1.getIsbn().compareToIgnoreCase(b2.getIsbn());
	}

}
