public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(103, "Book", "Education"),
            new Product(104, "Phone", "Electronics"),
            new Product(105, "T-shirt", "Fashion")
        };

        String searchName = "Phone";

        System.out.println("Linear Search:");
        Search.linearSearch(products, searchName);

        System.out.println("\nBinary Search:");
        Search.binarySearch(products, searchName);
    }
}