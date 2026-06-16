# Exercise 1: Singleton Pattern

**Scenario:** A logging utility class must have only one instance throughout
the application lifecycle to ensure consistent logging.

## How it works
- `Logger` has a private static field holding its own single instance.
- The constructor is private, so no other class can do `new Logger()`.
- `getInstance()` is the only way to obtain the object; it creates it the
  first time it's called and returns the same object every time after.

## Run
```bash
cd src
javac *.java
java SingletonTest
```

## Expected output
The "Logger instance created." message prints only once, and
`logger1 == logger2` prints `true`, proving both references point to the
same object.
