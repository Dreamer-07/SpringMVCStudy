package pers.dreamer07.pojo;

/**
 * @author shkstart
 * @create 2020-09-02 10:18
 */
public class Book {
    private String name;
    private String author;
    private Address address;

    public Book() {
    }

    public Book(String name, String author, Address address) {
        this.name = name;
        this.author = author;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("通过set方法设置");
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        System.out.println("通过set方法设置");
        this.author = author;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", address=" + address +
                '}';
    }
}
