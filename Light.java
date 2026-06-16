/**
 * Exercise 4: Implementing the Adapter Pattern
 *
 * Target interface that the client code expects to use, regardless of
 * which payment gateway is plugged in behind the scenes.
 */
public interface PaymentProcessor {
    void processPayment(double amount);
}
