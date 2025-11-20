public class PasteCommand implements Command {
    @Override
    public void execute() {
        System.out.println("execute paste");
    }

    @Override
    public void undo() {
        System.out.println("undo paste");
    }
}
