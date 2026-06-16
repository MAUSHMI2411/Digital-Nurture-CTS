/**
 * Adaptee #1: a third-party gateway with its own incompatible method names.
 */
public class PayPalGateway {
    public void sendPayment(double usdAmount) {
        System.out.println("PayPal: sent payment of $" + usdAmount);
    }
}
