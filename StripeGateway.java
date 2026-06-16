/**
 * Adds SMS notification on top of whatever notifier it wraps.
 */
public class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier wrappedNotifier) {
        super(wrappedNotifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("SMS sent: " + message);
    }
}
