public class LibraryItem {
    private String title;
    private int year;
    private String callNumber;
    private String location;

    public LibraryItem(String title, int year, String callNumber, String location) {
        this.title = title;
        this.year = year;
        this.callNumber = callNumber;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }
}
