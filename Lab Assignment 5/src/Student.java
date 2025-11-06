public class Student {
    private String name;
    private String id;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void requestBookTitle(Library library, String title) {
        System.out.println(name + " requested the book: " + title);
        System.out.println("Location: " + library.getBookLocationByTitle(title));
    }

    public void requestBookAuthor(Library library, String author) {
        System.out.println(name + " requested the book: " + author);
        System.out.println("Location: " + library.getBookLocationByAuthor(author));
    }

    public void requestDVD(Library library, String title) {
        System.out.println(name + " requested the DVD: " + title);
        System.out.println("Location: " + library.getDVDLocationByTitle(title));
    }
}