/**
 * Demonstrates using different payment gateways through a common
 * PaymentProcessor interface via adapters.
 */
public class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor payPal = new PayPalAdapter(new PayPalGateway());
        payPal.processPayment(49.99);

        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        stripe.processPayment(49.99);
    }
}
