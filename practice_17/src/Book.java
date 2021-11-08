public class Book {
    private String name;
    private String type;
    private double price;
    private String author;
    private int year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }

    public Book(){}

    public Book(String name, String type, double price, String author, int year) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.author = author;
        this.year = year;
    }

}
