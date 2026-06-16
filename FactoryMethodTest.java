# Exercise 9: Command Pattern

**Scenario:** A home automation system issues commands to turn devices on
or off.

## How it works
- `Command` is the command interface with `execute()`.
- `LightOnCommand` and `LightOffCommand` are concrete commands that
  delegate to the receiver.
- `Light` is the receiver that knows how to actually turn on/off.
- `RemoteControl` is the invoker; it holds a `Command` and triggers it via
  `pressButton()`, without knowing what the command does.

## Run
```bash
cd src
javac *.java
java CommandTest
```
