import java.util.Arrays;
import java.util.Comparator;

/**
 * Exercise 6: Library Management System
 *
 * Linear Search:
 *   Scans each element from the start.
 *   Time: O(n) – works on unsorted data.
 *   Use when: data is unsorted or dataset is small.
 *
 * Binary Search:
 *   Repeatedly halves the search space.
 *   Precondition: data must be sorted.
 *   Time: O(log n) – far faster for large sorted collections.
 *   Use when: dataset is large and kept sorted (e.g., by title alphabetically).
 *
 * Decision guide:
 *   n < 100            → linear search (simplicity wins)
 *   n >= 100, sorted   → binary search
 *   n >= 100, unsorted → sort first (O(n log n)), then binary search if repeated queries
 */
public class LibrarySearch {

    // ---------------------------------------------------------------- model
    static class Book {
        int    bookId;
        String title;
        String author;

        Book(int id, String title, String author) {
            this.bookId = id;
            this.title  = title;
            this.author = author;
        }

        @Override public String toString() {
            return String.format("Book[id=%d, title=%s, author=%s]",
                    bookId, title, author);
        }
    }

    // ---------------------------------------------------- linear search O(n)
    public static Book linearSearchByTitle(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) return b;
        }
        return null;
    }

    // --------------------------------------------------- binary search O(log n)
    // Assumes books[] is sorted by title (alphabetically, case-insensitive)
    public static Book binarySearchByTitle(Book[] books, String title) {
        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0)       return books[mid];
            else if (cmp < 0)   low  = mid + 1;
            else                high = mid - 1;
        }
        return null;
    }

    // ----------------------------------------------------------------- main
    public static void main(String[] args) {
        Book[] books = {
            new Book(5, "Moby Dick",               "Herman Melville"),
            new Book(1, "Clean Code",              "Robert C. Martin"),
            new Book(3, "Design Patterns",         "Gang of Four"),
            new Book(2, "The Pragmatic Programmer","Hunt & Thomas"),
            new Book(4, "Introduction to Algorithms","CLRS"),
        };

        String query = "Design Patterns";

        // Linear search on unsorted array
        System.out.println("=== Linear Search (unsorted) ===");
        Book result = linearSearchByTitle(books, query);
        System.out.println(result != null ? "Found: " + result : "Not found");

        // Sort alphabetically by title for binary search
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));

        System.out.println("\n=== Sorted Library ===");
        for (Book b : books) System.out.println(b);

        System.out.println("\n=== Binary Search (sorted) ===");
        Book binResult = binarySearchByTitle(books, query);
        System.out.println(binResult != null ? "Found: " + binResult : "Not found");

        System.out.println("\nComplexity comparison:");
        System.out.println("Linear  O(n)     – good for small/unsorted libraries.");
        System.out.println("Binary  O(log n) – preferred when collection is sorted and large.");
    }
}
