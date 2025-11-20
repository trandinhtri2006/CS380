public class CutCommand implements Command {
    @Override
    public void execute() {
        System.out.println("execute cut");
    }

    @Override
    public void undo() {
        System.out.println("undo cut");
    }
}
