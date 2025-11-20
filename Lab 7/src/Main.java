public class Main {
    public static void main(String[] args) {
        Document doc = new Document();
        Command cutCommand = new CutCommand();
        Command copyCommand = new CopyCommand();
        Command pasteCommand = new PasteCommand();

        doc.cut();
        doc.copy();
        doc.paste();
        cutCommand.undo();
    }
}
