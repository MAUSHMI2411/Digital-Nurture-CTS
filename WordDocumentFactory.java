/**
 * Demonstrates selecting and using different payment strategies at
 * runtime.
 */
public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext(new CreditCardPayment("1234567812345678"));
        paymentContext.executePayment(150.00);

        System.out.println("Switching payment strategy...");
        paymentContext.setPaymentStrategy(new PayPalPayment("buyer@example.com"));
        paymentContext.executePayment(75.50);
    }
}
