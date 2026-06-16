/**
 * RealSubject: loads an image from a (simulated) remote server. Loading is
 * expensive, which is exactly why we want to defer it via a proxy.
 */
public class RealImage implements Image {

    private final String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading \"" + fileName + "\" from remote server... (expensive operation)");
    }

    @Override
    public void display() {
        System.out.println("Displaying \"" + fileName + "\"");
    }
}
