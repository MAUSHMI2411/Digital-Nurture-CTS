# Exercise 6: Proxy Pattern

**Scenario:** An image viewer loads images from a remote server. Loading
is expensive, so the application should defer it until needed and cache
the result.

## How it works
- `Image` is the subject interface implemented by both real and proxy
  objects.
- `RealImage` simulates an expensive load from a remote server in its
  constructor.
- `ProxyImage` implements `Image`, holds a reference to a `RealImage`, and
  only creates it the first time `display()` is called (lazy
  initialization). Subsequent calls reuse the cached instance.

## Run
```bash
cd src
javac *.java
java ProxyTest
```
