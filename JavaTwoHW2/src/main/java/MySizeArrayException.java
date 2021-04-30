import javax.naming.SizeLimitExceededException;

public class MySizeArrayException extends SizeLimitExceededException {
    public MySizeArrayException(String string) {
        super(string);
    }
}
