public class Document {
    public void open() {
        System.out.println("open");
    }

    public void close() {
        System.out.println("close");
    }

    public void save() {
        System.out.println("save");
    }

    public void cut() {
        CutCommand cut = new CutCommand();
        cut.execute();
    }

    public void copy() {
        CopyCommand copy = new CopyCommand();
        copy.execute();
    }

    public void paste() {
        PasteCommand paste = new PasteCommand();
        paste.execute();
    }
}
