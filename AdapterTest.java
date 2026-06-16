/**
 * Demonstrates sending notifications via multiple channels using
 * decorators stacked on top of a base EmailNotifier.
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Notifier emailOnly = new EmailNotifier();
        System.out.println("-- Email only --");
        emailOnly.send("Server CPU usage is high");

        Notifier emailAndSms = new SMSNotifierDecorator(new EmailNotifier());
        System.out.println("-- Email + SMS --");
        emailAndSms.send("Payment received");

        Notifier emailSmsAndSlack =
                new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        System.out.println("-- Email + SMS + Slack --");
        emailSmsAndSlack.send("Production deployment completed");
    }
}
