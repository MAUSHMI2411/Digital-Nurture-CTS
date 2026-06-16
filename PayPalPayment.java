/**
 * Receiver: knows how to perform the actual work (turning a light on/off).
 */
public class Light {

    private final String location;
    private boolean on = false;

    public Light(String location) {
        this.location = location;
    }

    public void turnOn() {
        on = true;
        System.out.println(location + " light is ON");
    }

    public void turnOff() {
        on = false;
        System.out.println(location + " light is OFF");
    }

    public boolean isOn() {
        return on;
    }
}
