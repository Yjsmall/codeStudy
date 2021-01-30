package com.small.date;

import java.util.Objects;

/**
 * @author small
 */
public class Date {
    private final int month;
    private final int day;
    private final int year;

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Date{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Date date = (Date) o;
        return month == date.month &&
                day == date.day &&
                year == date.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, day, year);
    }

    public static void main(String[] args) {
        Date date1 = new Date(12, 21, 1999);
        Date date2 = new Date(1, 1, 2011);
        System.out.println(date1.year + "year" + date1.month + "month" + date1.day +"day");
        System.out.println(date2.year + "year" + date2.month + "month" + date2.day +"day");
        date1 = date2;
        if (date1.equals(date2)){
            System.out.println("两者相等");
        }
    }
}

