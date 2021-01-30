package com.small.vo;

/**
 * @author small
 */
public class Book {
    private String bookno;
    private String bookname;
    private float bookprice;
    private int booknumber;

    public Book(){

    }

    public String getBookno() {
        return bookno;
    }

    public void setBookno(String bookno) {
        this.bookno = bookno;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public float getBookprice() {
        return bookprice;
    }

    public void setBookprice(float bookprice) {
        this.bookprice = bookprice;
    }

    public int getBooknumber() {
        return booknumber;
    }

    public void setBooknumber(int booknumber) {
        this.booknumber = booknumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookno='" + bookno + '\'' +
                ", bookname='" + bookname + '\'' +
                ", bookprice=" + bookprice +
                ", booknumber=" + booknumber +
                '}';
    }
}
