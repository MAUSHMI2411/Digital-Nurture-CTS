# Design Patterns and Principles — Hands-On Solutions

Digital Nurture 5.0 — Java FSE Deep Skilling — Module 1: Design Patterns
and Principles. Solutions for all 11 hands-on exercises.

Each exercise lives in its own folder, mirrors a standalone Java project,
and contains:
- `src/` — all `.java` source files (the pattern implementation + a test
  class with a `main` method)
- `README.md` — scenario summary, how the pattern is applied, and run
  instructions

| # | Exercise | Pattern |
|---|----------|---------|
| 1 | Exercise1_SingletonPatternExample | Singleton |
| 2 | Exercise2_FactoryMethodPatternExample | Factory Method |
| 3 | Exercise3_BuilderPatternExample | Builder |
| 4 | Exercise4_AdapterPatternExample | Adapter |
| 5 | Exercise5_DecoratorPatternExample | Decorator |
| 6 | Exercise6_ProxyPatternExample | Proxy |
| 7 | Exercise7_ObserverPatternExample | Observer |
| 8 | Exercise8_StrategyPatternExample | Strategy |
| 9 | Exercise9_CommandPatternExample | Command |
| 10 | Exercise10_MVCPatternExample | MVC |
| 11 | Exercise11_DependencyInjectionExample | Dependency Injection |

## Requirements
JDK 8 or later.

## Running any exercise
```bash
cd <ExerciseFolder>/src
javac *.java
java <TestClassName>
```
Each exercise's own README states the exact test class name to run.

All 11 exercises have been compiled and executed successfully against
OpenJDK 21.
