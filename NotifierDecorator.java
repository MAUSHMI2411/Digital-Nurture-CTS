/**
 * Test class to verify that only one instance of Logger is created
 * and used across the application.
 */
public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Application started");

        Logger logger2 = Logger.getInstance();
        logger2.log("Processing request");

        System.out.println("logger1 == logger2 : " + (logger1 == logger2));
        System.out.println("Total logs recorded (shared state): " + logger1.getLogCount());
    }
}
