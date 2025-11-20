import java.util.*;

public class Books extends LibraryItem{
    private List<String> authors;
    private String isbn;

    public Books(String title, List<String> authors, int year, String isbn, String callNumber, String location) {
        super(title, year, callNumber, location);
        this.authors = authors;
        this.isbn = isbn;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getISBN() {
        return isbn;
    }
}