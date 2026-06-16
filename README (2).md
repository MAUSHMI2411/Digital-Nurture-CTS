/**
 * Abstract decorator. Holds a reference to a wrapped Notifier and delegates
 * to it, allowing subclasses to add behavior before/after delegation.
 */
public abstract class NotifierDecorator implements Notifier {

    protected final Notifier wrappedNotifier;

    public NotifierDecorator(Notifier wrappedNotifier) {
        this.wrappedNotifier = wrappedNotifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}
