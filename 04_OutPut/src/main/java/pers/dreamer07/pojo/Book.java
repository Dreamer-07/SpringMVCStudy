package pers.dreamer07.pojo;

/**
 * @author shkstart
 * @create 2020-09-02 16:42
 */
public class Book {
    private Integer id;
    private String bookName;
    private String author;
    private Double price;

    public Book() {
    }

    public Book(Integer id, String bookName, String author, Double price) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
