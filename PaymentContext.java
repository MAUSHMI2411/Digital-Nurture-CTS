/**
 * Demonstrates using ProxyImage to load and display images with lazy
 * initialization and caching.
 */
public class ProxyTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("vacation_photo.png");

        System.out.println("Image object created, but not loaded yet.");

        System.out.println("\nFirst call to display():");
        image.display(); // triggers actual loading

        System.out.println("\nSecond call to display():");
        image.display(); // uses cached RealImage, no reload
    }
}
