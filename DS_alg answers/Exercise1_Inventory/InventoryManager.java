import java.util.HashMap;
import java.util.Map;

/**
 * Exercise 1: Inventory Management System
 *
 * Why data structures & algorithms matter:
 *   Large inventories can contain millions of products. Without efficient
 *   data structures, simple operations like lookup or update would require
 *   scanning every record (O(n)). A HashMap provides O(1) average-case for
 *   add, update, and delete by hashing the productId to a bucket index.
 *
 * Chosen data structure: HashMap<Integer, Product>
 *   - Key   : productId (unique identifier)
 *   - Value : Product object
 *
 * Time complexity analysis:
 *   - add    : O(1) average, O(n) worst (hash collision)
 *   - update : O(1) average
 *   - delete : O(1) average
 *   - search : O(1) average
 *
 * Optimisation notes:
 *   - Provide an initial capacity to avoid costly rehashing when the
 *     inventory grows beyond the load-factor threshold (default 0.75).
 *   - For range queries (e.g., products with price < $50) a TreeMap gives
 *     O(log n) navigation; HashMap is faster for point lookups.
 */
public class InventoryManager {

    private final Map<Integer, Product> inventory = new HashMap<>();

    // ------------------------------------------------------------------ add
    /** O(1) average */
    public void addProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            System.out.println("Product with id " + product.getProductId() + " already exists.");
            return;
        }
        inventory.put(product.getProductId(), product);
        System.out.println("Added: " + product);
    }

    // --------------------------------------------------------------- update
    /** O(1) average */
    public void updateProduct(int productId, int newQuantity, double newPrice) {
        Product p = inventory.get(productId);
        if (p == null) {
            System.out.println("Product " + productId + " not found.");
            return;
        }
        p.setQuantity(newQuantity);
        p.setPrice(newPrice);
        System.out.println("Updated: " + p);
    }

    // --------------------------------------------------------------- delete
    /** O(1) average */
    public void deleteProduct(int productId) {
        Product removed = inventory.remove(productId);
        if (removed == null) {
            System.out.println("Product " + productId + " not found.");
        } else {
            System.out.println("Deleted: " + removed);
        }
    }

    // --------------------------------------------------------------- display
    public void displayAll() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("--- Current Inventory ---");
        inventory.values().forEach(System.out::println);
    }

    // ----------------------------------------------------------------- main
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // Add products
        manager.addProduct(new Product(101, "Laptop",    50,  999.99));
        manager.addProduct(new Product(102, "Mouse",    200,   25.49));
        manager.addProduct(new Product(103, "Keyboard", 150,   45.00));
        manager.addProduct(new Product(101, "Duplicate", 10,    1.00)); // duplicate

        System.out.println();
        manager.displayAll();

        System.out.println();
        // Update product
        manager.updateProduct(102, 180, 22.99);

        System.out.println();
        // Delete product
        manager.deleteProduct(103);
        manager.deleteProduct(999); // non-existent

        System.out.println();
        manager.displayAll();
    }
}
