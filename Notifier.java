/**
 * Adds Slack notification on top of whatever notifier it wraps.
 */
public class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier wrappedNotifier) {
        super(wrappedNotifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Slack message posted: " + message);
    }
}
