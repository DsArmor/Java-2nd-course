package ex3;

public class CreateTextDocument implements ICreateDocument{

    @Override
    public IDocument createNew() {
        return new TextDocument();
    }

    @Override
    public IDocument createOpen() {
        return new TextDocument();
    }

    @Override
    public String name() {
        return "Text Document";
    }
}
