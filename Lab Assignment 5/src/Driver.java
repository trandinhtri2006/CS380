import java.util.*;

public class Driver {

    public static void main(String[] args) {
        Random random = new Random();

        // --- Create Books ---
        List<Books> books = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            books.add(new Books("Book " + i, "Author " + i, i, 10 + i, 50 + i));
        }

        // --- Create DVDs ---
        List<DVDs> dvds = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            dvds.add(new DVDs("DVD " + i, i, 12 + i));
        }

        // --- Create Student ---
        int numCustomers = 5; // between 1 and 10
        List<Student> customers = new ArrayList<>();
        for (int i = 1; i <= numCustomers; i++) {
            customers.add(new Student("Tony", i)); // same name, unique ID
        }

        System.out.println("Total student today: " + numCustomers);
        System.out.println();

        // --- Simulate for 3 days ---
        for (int day = 1; day <= 3; day++) {
            System.out.println("----- Day " + day + " -----");

            for (Student customer : customers) {
                int actions = random.nextInt(3) + 1; // each customer does 1–3 actions per day

                for (int a = 0; a < actions; a++) {
                    boolean addAction = random.nextBoolean(); // true = add, false = remove
                    boolean chooseBook = random.nextBoolean(); // true = book, false = DVD

                    /* Chose Book */
                    if (chooseBook) {
                        Books selectedBook = books.get(random.nextInt(books.size()));

                        if (addAction) {
                            if (customer.hasBook(selectedBook)) {
                                System.out.println(customer.getName() + " (ID " + customer.getId() + ") already has " + selectedBook.getTitle());
                            } else {
                                customer.addBook(selectedBook);
                                System.out.println(customer.getName() + " (ID " + customer.getId() + ") added " + selectedBook.getTitle());
                            }
                        } else {
                            if (customer.hasBook(selectedBook)) {
                                customer.removeBook(selectedBook);
                                System.out.println(customer.getName() + " (ID " + customer.getId() + ") removed " + selectedBook.getTitle());
                            }
                        }

                    } else { /* Chose DVD */
                        DVDs selectedDVD = dvds.get(random.nextInt(dvds.size()));

                        if (addAction) {
                            if (customer.hasDVD(selectedDVD)) {
                                System.out.println(customer.getName() + " (ID " + customer.getId() + ") already has " + selectedDVD.getTitle());
                            } else {
                                customer.addDVD(selectedDVD);
                                System.out.println(customer.getName() + " (ID " + customer.getId() + ") added " + selectedDVD.getTitle());
                            }
                        } else {
                            if (customer.hasDVD(selectedDVD)) {
                                customer.removeDVD(selectedDVD);
                                System.out.println(customer.getName() + " (ID " + customer.getId() + ") removed " + selectedDVD.getTitle());
                            }
                        }
                    }
                }
            }

            System.out.println("\nSummary for Day " + day + ":");
            for (Student customer : customers) {
                System.out.println(customer);
            }
            System.out.println();
        }
    }
}
