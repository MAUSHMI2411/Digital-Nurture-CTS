public class Logger {
    private static Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        return instance;
    }
}
