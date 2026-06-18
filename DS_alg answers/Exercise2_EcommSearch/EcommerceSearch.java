/**
 * Exercise 2: E-commerce Platform Search Function
 *
 * Big O Notation:
 *   Big O describes the upper bound of an algorithm's running time as the
 *   input size (n) grows. It lets us compare algorithms independent of
 *   hardware. Common complexities:
 *     O(1)      - constant   : HashMap lookup
 *     O(log n)  - logarithmic: binary search
 *     O(n)      - linear     : linear search
 *     O(n log n)- quasilinear: merge sort
 *     O(n²)     - quadratic  : bubble sort
 *
 * Search scenarios:
 *   Linear Search:
 *     Best    O(1)  – first element matches
 *     Average O(n/2) ≈ O(n)
 *     Worst   O(n)  – last element or not found
 *
 *   Binary Search (sorted array required):
 *     Best    O(1)  – middle element matches
 *     Average O(log n)
 *     Worst   O(log n)
 *
 * Conclusion:
 *   For a large, sorted product catalogue, binary search is strongly
 *   preferred. For small or unsorted lists, linear search is simpler.
 */
public class EcommerceSearch {

    // ---------------------------------------------------------------- model
    static class Product {
        int productId;
        String productName;
        String category;

        Product(int id, String name, String category) {
            this.productId   = id;
            this.productName = name;
            this.category    = category;
        }

        @Override public String toString() {
            return String.format("Product[id=%d, name=%s, category=%s]",
                    productId, productName, category);
        }
    }

    // ---------------------------------------------------- linear search O(n)
    public static int linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productId == targetId) return i;
        }
        return -1;
    }

    // --------------------------------------------------- binary search O(log n)
    // Precondition: array is sorted by productId
    public static int binarySearch(Product[] products, int targetId) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (products[mid].productId == targetId)  return mid;
            else if (products[mid].productId < targetId) low  = mid + 1;
            else                                         high = mid - 1;
        }
        return -1;
    }

    // ----------------------------------------------------------------- main
    public static void main(String[] args) {
        // Sorted by productId for binary search
        Product[] products = {
            new Product(101, "Laptop",     "Electronics"),
            new Product(102, "Mouse",      "Electronics"),
            new Product(103, "Notebook",   "Stationery"),
            new Product(104, "Pen Drive",  "Electronics"),
            new Product(105, "Backpack",   "Accessories"),
        };

        int searchId = 103;

        // Linear search
        long t1 = System.nanoTime();
        int linIdx = linearSearch(products, searchId);
        long t2 = System.nanoTime();
        System.out.println("=== Linear Search ===");
        System.out.println(linIdx >= 0 ? "Found: " + products[linIdx] : "Not found");
        System.out.println("Time: " + (t2 - t1) + " ns");

        // Binary search
        long t3 = System.nanoTime();
        int binIdx = binarySearch(products, searchId);
        long t4 = System.nanoTime();
        System.out.println("\n=== Binary Search ===");
        System.out.println(binIdx >= 0 ? "Found: " + products[binIdx] : "Not found");
        System.out.println("Time: " + (t4 - t3) + " ns");

        System.out.println("\nComparison:");
        System.out.println("Linear  - O(n)      suitable for small/unsorted data.");
        System.out.println("Binary  - O(log n)  preferred for large sorted catalogues.");
    }
}
