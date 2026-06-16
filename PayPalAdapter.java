# Exercise 5: Decorator Pattern

**Scenario:** A notification system can send notifications via multiple
channels (Email, SMS, Slack), and channels need to be added dynamically
without modifying existing classes.

## How it works
- `Notifier` is the component interface with `send()`.
- `EmailNotifier` is the concrete base component.
- `NotifierDecorator` is an abstract decorator holding a wrapped `Notifier`
  and delegating to it.
- `SMSNotifierDecorator` and `SlackNotifierDecorator` extend the decorator
  and add their own behavior, then call `super.send()` to keep the chain
  going.

## Run
```bash
cd src
javac *.java
java DecoratorTest
```
