package libraryMangementSystem;

import java.util.List;
import java.util.Optional;

public interface Searchable {
		Book findBookByIsbn(String isbn);
		List<Book> findBooksByAauthor(String Author);

}
