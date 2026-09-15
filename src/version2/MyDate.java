package version2;

import java.util.Arrays;

public class MyDate {
    private int day;
    private int month;
    private int year;

    private final String[] mon = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public MyDate() {
        this(1, 1, 2000);
    }

    public MyDate(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day>=1 && day<=31){
            this.day = day;
        } else {
            this.day = 1;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month>=1 && month<=12){
            this.month = month;
        } else {
            this.month = 1;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void displayDate(){
        System.out.println(day + mon[month-1] + year);
    }

    @Override
    public String toString() {
        return day + mon[month-1] + year;
    }
}
