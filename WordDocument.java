/**
 * Context class that holds a reference to the currently selected
 * PaymentStrategy and delegates the payment to it. The strategy can be
 * swapped at runtime via setPaymentStrategy().
 */
public class PaymentContext {

    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("No payment strategy set");
        }
        paymentStrategy.pay(amount);
    }
}
