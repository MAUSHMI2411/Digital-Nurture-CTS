# Exercise 3: Builder Pattern

**Scenario:** Build complex `Computer` objects with multiple optional parts
without a constructor that takes a dozen parameters.

## How it works
- `Computer` has a private constructor that only accepts a `Builder`.
- The static nested `Builder` class exposes fluent setter methods
  (`cpu()`, `ram()`, `storage()`, etc.), each returning `this`.
- `build()` validates required fields and returns the final `Computer`.

## Run
```bash
cd src
javac *.java
java BuilderTest
```
