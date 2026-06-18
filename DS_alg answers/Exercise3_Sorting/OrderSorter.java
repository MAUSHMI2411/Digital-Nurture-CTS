import java.util.Arrays;

/**
 * Exercise 3: Sorting Customer Orders
 *
 * Sorting algorithm overview:
 *   Bubble Sort   – repeatedly swaps adjacent elements; O(n²) avg & worst.
 *   Insertion Sort– builds sorted portion one element at a time; O(n²) avg.
 *   Quick Sort    – divide-and-conquer around a pivot; O(n log n) avg, O(n²) worst.
 *   Merge Sort    – divide-and-conquer then merge; O(n log n) always.
 *
 * Why Quick Sort beats Bubble Sort in practice:
 *   1. Average time complexity: O(n log n) vs O(n²).
 *   2. In-place (no extra array needed like Merge Sort).
 *   3. Cache-friendly sequential access patterns.
 *   For n = 10,000 orders: Quick Sort ≈ 133k ops vs Bubble Sort ≈ 100M ops.
 */
public class OrderSorter {

    // ---------------------------------------------------------------- model
    static class Order {
        int    orderId;
        String customerName;
        double totalPrice;

        Order(int id, String name, double price) {
            this.orderId      = id;
            this.customerName = name;
            this.totalPrice   = price;
        }

        @Override public String toString() {
            return String.format("Order[id=%d, customer=%s, total=%.2f]",
                    orderId, customerName, totalPrice);
        }
    }

    // ------------------------------------------------------- Bubble Sort O(n²)
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order tmp      = orders[j];
                    orders[j]      = orders[j + 1];
                    orders[j + 1]  = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break; // early exit if already sorted
        }
    }

    // --------------------------------------------------- Quick Sort O(n log n)
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low,  pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order tmp   = orders[i];
                orders[i]   = orders[j];
                orders[j]   = tmp;
            }
        }
        Order tmp       = orders[i + 1];
        orders[i + 1]   = orders[high];
        orders[high]    = tmp;
        return i + 1;
    }

    // -------------------------------------------------------------- helpers
    private static void printOrders(Order[] orders, String label) {
        System.out.println("--- " + label + " ---");
        for (Order o : orders) System.out.println(o);
        System.out.println();
    }

    // ----------------------------------------------------------------- main
    public static void main(String[] args) {
        Order[] original = {
            new Order(1, "Alice",   250.00),
            new Order(2, "Bob",    1200.50),
            new Order(3, "Carol",   89.99),
            new Order(4, "Dave",   450.00),
            new Order(5, "Eve",    320.75),
        };

        // Bubble Sort
        Order[] bubbleArr = Arrays.copyOf(original, original.length);
        bubbleSort(bubbleArr);
        printOrders(bubbleArr, "Bubble Sort (ascending by totalPrice) — O(n²)");

        // Quick Sort
        Order[] quickArr = Arrays.copyOf(original, original.length);
        quickSort(quickArr, 0, quickArr.length - 1);
        printOrders(quickArr, "Quick Sort (ascending by totalPrice) — O(n log n)");

        System.out.println("Conclusion: Quick Sort is preferred for large order sets");
        System.out.println("because its average complexity O(n log n) vastly outperforms");
        System.out.println("Bubble Sort's O(n²) as the number of orders grows.");
    }
}
