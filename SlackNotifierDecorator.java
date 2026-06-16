/**
 * Exercise 1: Implementing the Singleton Pattern
 *
 * Logger ensures only one instance exists throughout the application
 * lifecycle, so all parts of the application log through the same object.
 */
public class Logger {

    // The single instance, created only when first requested (lazy init).
    private static Logger instance;

    // Keeps a simple in-memory log so we can prove it's the same instance.
    private int logCount = 0;

    // Private constructor prevents instantiation from outside the class.
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Thread-safe accessor for the single instance.
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        logCount++;
        System.out.println("[LOG #" + logCount + "] " + message);
    }

    public int getLogCount() {
        return logCount;
    }
}
