# Exercise 8: Strategy Pattern

**Scenario:** A payment system must let users select between different
payment methods (Credit Card, PayPal) at runtime.

## How it works
- `PaymentStrategy` is the strategy interface with `pay()`.
- `CreditCardPayment` and `PayPalPayment` are concrete strategies.
- `PaymentContext` holds a reference to the current `PaymentStrategy` and
  delegates to it in `executePayment()`. The strategy can be swapped via
  `setPaymentStrategy()` without changing the context's code.

## Run
```bash
cd src
javac *.java
java StrategyTest
```
