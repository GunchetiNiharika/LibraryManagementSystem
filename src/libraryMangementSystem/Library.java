package libraryMangementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
 
public class Library {
    private List<Book> books;
 
    public Library() {
        this.books = new ArrayList<>();
    }
 
    public void addBook(Book book) {
        if (books.contains(book)) {
            throw new BookAlreadyExistsException("Book with ISBN " + book.getIsbn() + " already exists.");
        }
        books.add(book);
    }
 
    public void removeBook(String isbn) throws BookNotFoundException {
    	Book book = findBookByIsbn(isbn);
    	//Book book=
               //optbook .orElseThrow(() -> new BookNotFoundException("Book with ISBN " + isbn + " not found."));
        books.remove(book);
    }
 
    public Book findBookByIsbn (String isbn) throws BookNotFoundException {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst().orElseThrow(()->new BookNotFoundException("Book with ISBN"+ isbn +"not found."));
    }
 
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }
 
    public List<Book> getAllBooks() {
        return books;
    }
 
    public List<Book> sortBooksByTitle() {
        Collections.sort(books); // Uses Comparable
        return books;
    }
 
    public List<Book> sortBooksByAuthor() {
        Collections.sort(books, new AuthorComparator()); // Uses Comparator
        return books;
    }
 
    public List<Book> sortBooksByIsbn() {
        Collections.sort(books, new IsbnComparator()); // Uses Comparator
        return books;
    }
 
    public List<Book> searchBooks(String keyword) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                                book.getAuthor().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}