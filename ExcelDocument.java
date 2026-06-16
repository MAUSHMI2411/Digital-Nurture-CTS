/**
 * Exercise 8: Implementing the Strategy Pattern
 *
 * Strategy interface for interchangeable payment algorithms.
 */
public interface PaymentStrategy {
    void pay(double amount);
}
