import java.util.HashMap;
import java.util.Map;

/**
 * Exercise 7: Financial Forecasting (Recursive Algorithm)
 *
 * Recursion:
 *   A method that calls itself with a smaller sub-problem until it reaches
 *   a base case. Many mathematical sequences are naturally recursive:
 *     FV(n) = FV(n-1) * (1 + rate)
 *
 * Plain recursion drawback:
 *   Each call recomputes the same sub-problem. For compound growth this is
 *   linear O(n), but patterns like Fibonacci without memoization are O(2^n).
 *
 * Memoization optimisation:
 *   Cache each computed result the first time; subsequent calls return the
 *   cached value in O(1). This converts repeated exponential work to O(n).
 *
 * Model used here:
 *   futureValue(presentValue, growthRate, n)
 *     = presentValue                                   if n == 0  (base case)
 *     = futureValue(presentValue, growthRate, n-1) * (1 + growthRate)  otherwise
 *
 * Time complexity:
 *   Plain recursive: O(n)        (each level does O(1) work)
 *   With memoization: O(n) first call, then O(1) for repeated n values.
 *
 * Space complexity: O(n) call stack depth (risk of StackOverflowError for
 * large n; an iterative loop avoids this).
 */
public class FinancialForecasting {

    // --------------------------------------- plain recursion O(n) call depth
    public static double futureValueRecursive(double presentValue,
                                              double growthRate,
                                              int n) {
        if (n == 0) return presentValue;                         // base case
        return futureValueRecursive(presentValue, growthRate, n - 1)
               * (1 + growthRate);
    }

    // ---------------------------------------- memoized recursion
    private static final Map<Integer, Double> memo = new HashMap<>();

    public static double futureValueMemo(double presentValue,
                                         double growthRate,
                                         int n) {
        if (n == 0) return presentValue;
        if (memo.containsKey(n)) return memo.get(n);
        double result = futureValueMemo(presentValue, growthRate, n - 1)
                        * (1 + growthRate);
        memo.put(n, result);
        return result;
    }

    // --------------------------------------- iterative (most practical)
    /**
     * Equivalent iterative solution – avoids stack overflow for large n.
     * O(n) time, O(1) space.
     */
    public static double futureValueIterative(double presentValue,
                                              double growthRate,
                                              int n) {
        double value = presentValue;
        for (int i = 0; i < n; i++) value *= (1 + growthRate);
        return value;
    }

    // ----------------------------------------------------------------- main
    public static void main(String[] args) {
        double presentValue = 10_000.00; // $10,000
        double growthRate   = 0.08;      // 8% annual growth
        int    years        = 10;

        System.out.printf("Present Value : $%.2f%n", presentValue);
        System.out.printf("Annual Growth : %.0f%%%n", growthRate * 100);
        System.out.printf("Years         : %d%n%n", years);

        double rv = futureValueRecursive(presentValue, growthRate, years);
        System.out.printf("Recursive  result : $%.2f%n", rv);

        double mv = futureValueMemo(presentValue, growthRate, years);
        System.out.printf("Memoized   result : $%.2f%n", mv);

        double iv = futureValueIterative(presentValue, growthRate, years);
        System.out.printf("Iterative  result : $%.2f%n", iv);

        System.out.println();
        System.out.println("Year-by-year projection (recursive):");
        System.out.printf("%-6s %s%n", "Year", "Future Value");
        for (int y = 0; y <= years; y++) {
            double fv = futureValueIterative(presentValue, growthRate, y);
            System.out.printf("%-6d $%.2f%n", y, fv);
        }

        System.out.println();
        System.out.println("Complexity note:");
        System.out.println("  Plain recursive : O(n) – simple but may stack overflow for very large n.");
        System.out.println("  Memoized        : O(n) first call, O(1) repeated – best for reuse.");
        System.out.println("  Iterative       : O(n) time, O(1) space – safest for production use.");
    }
}
