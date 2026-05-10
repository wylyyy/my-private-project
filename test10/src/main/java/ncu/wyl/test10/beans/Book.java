package ncu.wyl.test10.beans;

public class Book {
    private String bookid;
    private String bookname;
    private double bookprice;

    public Book(){} // 提供无参构造函数(JavaBean 标准约定)

    public void setBookid(String bookid) {
        this.bookid = bookid;

    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setBookprice(double bookprice) {
        this.bookprice = bookprice;
    }

    public String getBookid()   {
        return this.bookid;
    }

    public String getBookname() {
        return this.bookname;
    }

    public double getBookprice() {
        return this.bookprice;
    }
}
