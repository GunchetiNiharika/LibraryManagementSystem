package libraryMangementSystem;

import java.util.Objects;

public class Book implements Comparable<Book>{
	private String title;
	private String author;
	private String isbn;
	public Book(String title,String author,String isbn) {
		this.title=title;
		this.author=author;
		this.isbn=isbn;
		
	}
	public String getIsbn() {
		return isbn;
	}

    public String getTitle() {
    	return title;
    }
    public String getAuthor() {
    	return author;
    }
    public String getDetails() {
    	return title +" by "+ author + "( ISBN :"+ isbn +")";
    }
    @Override
    public int compareTo(Book other) {
    	return this.title.compareTo(other.title);
    }
    @Override
    public boolean equals(Object o) {
    	if(this == o) {
    		return true;
    	}
    	if(!(o instanceof Book)) {
    		return false;
    		
    	}
    	Book book=(Book) o;
    	return Objects.equals(isbn, book.isbn);
    }
    @Override
    public int hashCode() {
    	return Objects.hash(isbn);
    }
	
}
