import java.util.*;

 class Driver {
    static void main() {
        Library library = new Library();

        // Create books
        List<String> authors1 = new ArrayList<>();
        authors1.add("George Orwell");
        Books book1 = new Books("1984", authors1, 1949, "123-456-789", "B001", "Shelf A3");

        List<String> authors2 = new ArrayList<>();
        authors2.add("J.K. Rowling");
        Books book2 = new Books("Harry Potter", authors2, 1997, "987-654-321", "B002", "Shelf B1");

        // Create DVDs
        DVDs dvd1 = new DVDs("Inception", 2010, "D001", "Rack D2");

        // Add items to Library
        library.addBook(book1);
        library.addBook(book2);
        library.addDVD(dvd1);

        // Create a Student
        Student student = new Student("Alice", "S123");

        // Search requests
        student.requestBookAuthor(library, "1984");
        student.requestDVD(library, "Inception");
        student.requestBookTitle(library, "Book");
    }
}