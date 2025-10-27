import java.util.*;

public class Student {
    private String name;
    private int id;
    private List<Books> ownedBooks;
    private List<DVDs> ownedDVDs;

    /* ===== Constructor ===== */
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.ownedBooks = new ArrayList<>();
        this.ownedDVDs = new ArrayList<>();
    }


    /* ===== Getter ===== */
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }


    /* ===== Setter ===== */
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }


    // --- Book Operations ---
    /**
     * add a book into student inventory
     * @param b book ID
     */
    public void addBook(Books b) {
        if (!hasBook(b)) {
            ownedBooks.add(b);
        }
    }

    /**
     * remove a book from student inventory
     * @param b book ID
     */
    public void removeBook(Books b) {
        ownedBooks.remove(b);
    }

    /**
     * Check if the student already has the book in the inventory
     * @param b book ID
     * @return true = has, false = hasn't
     */
    public boolean hasBook(Books b) {
        return ownedBooks.contains(b);
    }


    // --- DVD Operations ---
    /**
     * add a DVD into student inventory
     * @param d DVD callNum
     */
    public void addDVD(DVDs d) {
        if (!hasDVD(d)) {
            ownedDVDs.add(d);
        }
    }

    /**
     * remove a dvd from student inventory
     * @param d dvd callNum
     */
    public void removeDVD(DVDs d) {
        ownedDVDs.remove(d);
    }

    /**
     * Check if the student already has the dvd in the inventory
     * @param d dvd callNum
     * @return true = has, false = hasn't
     */
    public boolean hasDVD(DVDs d) {
        return ownedDVDs.contains(d);
    }

    /**
     * Show the student inventory
     * @return A String that display how many books or dvds the student has
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer ID ").append(id).append(" - ").append(name).append("\n");
        sb.append("  Books owned: ");
        if (ownedBooks.isEmpty()) sb.append("None");
        else {
            for (Books b : ownedBooks) {
                sb.append(b.getTitle()).append(", ");
            }
        }
        sb.append("\n  DVDs owned: ");
        if (ownedDVDs.isEmpty()) sb.append("None");
        else {
            for (DVDs d : ownedDVDs) {
                sb.append(d.getTitle()).append(", ");
            }
        }
        sb.append("\n");
        return sb.toString();
    }
}
