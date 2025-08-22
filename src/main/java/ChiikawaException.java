public class ChiikawaException extends Exception {
    public ChiikawaException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
