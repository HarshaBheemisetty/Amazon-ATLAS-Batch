// ✅ Class: Holds book data only
class Book {
    private String title;
    private String author;
    private double price;

    public Book (String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Getters only (no setters unless needed)
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
}
// Class: Responsible for formatting book details only
public class Day20_SRP1 {
    public String formatTitle(Book book) {
        return "Title: " + book.getTitle().toUpperCase();
    }

    public String formatAuthor(Book book) {
        return "Author: " + book.getAuthor();
    }

    public String formatDetails(Book book) {
        return formatTitle(book) + "\n" + formatAuthor(book) + "\nPrice: ₹" + book.getPrice();
    }
}
// Class: Responsible for price calculation only
class PriceCalculator {
    public double calculateDiscountedPrice(Book book, double discountPercentage) {
        return book.getPrice() * (1 - discountPercentage);
    }
}
class Book1
{
    public static void main(String[] args) {
        Book book = new Book("Clean Code", "Robert C. Martin", 500);

        Day20_SRP1 formatter = new Day20_SRP1();
        PriceCalculator calculator = new PriceCalculator();

        System.out.println(formatter.formatDetails(book));

        double discountedPrice = calculator.calculateDiscountedPrice(book, 0.10); // 10% discount
        System.out.println("Discounted Price: ₹" + discountedPrice);
    }
}

