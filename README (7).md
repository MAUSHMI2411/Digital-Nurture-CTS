/**
 * Invoker: holds a reference to a Command and triggers it, without
 * knowing anything about what the command actually does or which
 * receiver it affects.
 */
public class RemoteControl {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command == null) {
            throw new IllegalStateException("No command set on the remote");
        }
        command.execute();
    }
}
