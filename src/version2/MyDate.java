package version2;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate() {
        this(0, 0, 0);
    }

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
}
