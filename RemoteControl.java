/**
 * Proxy: defers creating the expensive RealImage until display() is
 * actually called (lazy initialization), and caches it afterward so
 * later calls don't reload from the remote server.
 */
public class ProxyImage implements Image {

    private final String fileName;
    private RealImage realImage; // cached after first load

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName); // load + cache on first use
        } else {
            System.out.println("Using cached image for \"" + fileName + "\"");
        }
        realImage.display();
    }
}
