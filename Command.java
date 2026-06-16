# Exercise 4: Adapter Pattern

**Scenario:** A payment processing system must integrate with multiple
third-party gateways that each expose different method names/signatures.

## How it works
- `PaymentProcessor` is the target interface the client code relies on.
- `PayPalGateway` and `StripeGateway` are adaptees with incompatible APIs.
- `PayPalAdapter` and `StripeAdapter` implement `PaymentProcessor` and
  translate calls into the gateway-specific methods.

## Run
```bash
cd src
javac *.java
java AdapterTest
```
