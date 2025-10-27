public class People {
    private int studentID;
    private String name;
    private int item;

    public People(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.item = 0;
    }

    public People(int studentID) {
        this.studentID = studentID;
        this.name = "N/A";
        this.item = 0;
    }

    /* ===== Getter ===== */
    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getItem() {
        return item;
    }

    /* ===== Setter ===== */
    public void setName(String name) {
        this.name = name;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public void addItem(String item) {

    }
}
