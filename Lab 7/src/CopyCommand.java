public class CopyCommand implements Command {


    @Override
    public void execute() {
        System.out.println("execute copy");
    }

    @Override
    public void undo() {
        // Copy has no visible side effect → nothing to undo
    }
}
