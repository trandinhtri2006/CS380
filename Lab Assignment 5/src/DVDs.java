public class DVDs {
    private String title;
    private int year;
    private int callNum;

    public DVDs(String title, int year, int callNum) {
        this.title = title;
        this.year = year;
        this.callNum = callNum;

    }

    public DVDs (int callNum) {
        this.title = "N/A";
        this.year = -1;
        this.callNum = callNum;

    }

    /* ===== Getter ===== */
    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getCallNum() {
        return callNum;
    }

    /* ===== Setter ===== */
    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCallNum(int callNum) {
        this.callNum = callNum;
    }
}
