import java.util.ArrayList;
import java.util.*;

public class Library {
    private List<Books> books;
    private List<DVDs> dvds;

    public Library() {
        books = new ArrayList<>();
        dvds = new ArrayList<>();
    }

    public void addBook(Books book) {
        books.add(book);
    }

    public void addDVD(DVDs dvd) {
        dvds.add(dvd);
    }

    public String getBookLocationByTitle(String title) {
        for (Books book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book.getLocation();
            }
        }
        return "Book not found.";
    }

    public String getBookLocationByAuthor(String author) {
        for (Books book : books) {
            if (book.getAuthors().contains(author)) {
                return book.getLocation();
            }
        }
        return "Book by this author not found.";
    }

    public String getDVDLocationByTitle(String title) {
        for (DVDs dvd : dvds) {
            if (dvd.getTitle().equalsIgnoreCase(title)) {
                return dvd.getLocation();
            }
        }
        return "DVD not found.";
    }


}
