/**
 * Adapts StripeGateway's charge() (cents, long) to the PaymentProcessor
 * interface (dollars, double).
 */
public class StripeAdapter implements PaymentProcessor {

    private final StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        long amountInCents = Math.round(amount * 100);
        stripeGateway.charge(amountInCents);
    }
}
