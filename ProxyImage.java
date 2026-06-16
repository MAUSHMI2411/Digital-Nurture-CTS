/**
 * Adaptee #2: another third-party gateway, with a different signature
 * (amount in cents instead of dollars).
 */
public class StripeGateway {
    public void charge(long amountInCents) {
        System.out.println("Stripe: charged " + amountInCents + " cents");
    }
}
