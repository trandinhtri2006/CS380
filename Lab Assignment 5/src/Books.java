public class Books {
    private String title;
    private String author;
    private int publicYrs;
    private int ISBN;
    private int callNum;


    public Books(String title, String author, int publicYrs, int ISBN, int callNum) {
        this.title = title;
        this.author = author;
        this.publicYrs = publicYrs;
        this.ISBN = ISBN;
        this.callNum = callNum;
    }

    public Books(int ISBN) {
        this.title = "N/A";
        this.author = "N/A";
        this.publicYrs = -1;
        this.ISBN = ISBN;
        this.callNum = -1;
    }

    /* ===== Getter ===== */
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicYrs() {
        return publicYrs;
    }

    public int getISBN() {
        return ISBN;
    }

    public int getCallNum() {
        return callNum;
    }

    /* ===== Setter ===== */
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicYrs(int publicYrs) {
        this.publicYrs = publicYrs;
    }

    public void setCallNum(int callNum) {
        this.callNum = callNum;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
}
