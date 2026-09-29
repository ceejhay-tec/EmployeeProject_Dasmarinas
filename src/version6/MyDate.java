package version6;

public final class MyDate implements Cloneable {
    private static final String[] MONTH_NAMES = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    private int day;
    private int month;
    private int year;

    public MyDate() {
        this(1, 1, 2000);
    }

    public MyDate(int day, int month, int year) {
        validateDate(day, month, year);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    private static void validateDate(int day, int month, int year) {
        if (year <= 1900 || month < 1 || month > 12
                || day < 1 || day > daysInMonth(month, year)) {
            throw new IllegalArgumentException("Invalid calendar date");
        }
    }

    private static int daysInMonth(int month, int year) {
        switch (month) {
            case 2:
                return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    public final int getDay() { return day; }

    public final void setDay(int day) {
        validateDate(day, month, year);
        this.day = day;
    }

    public final int getMonth() { return month; }

    public final void setMonth(int month) {
        validateDate(day, month, year);
        this.month = month;
    }

    public final int getYear() { return year; }

    public final void setYear(int year) {
        validateDate(day, month, year);
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%02d %s %04d", day, MONTH_NAMES[month - 1], year);
    }

    @Override
    public MyDate clone() {
        try {
            return (MyDate) super.clone();
        } catch (CloneNotSupportedException exception) {
            throw new AssertionError(exception);
        }
    }
}
