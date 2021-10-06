package baseball.exception;

public class BaseballGameFailureException extends RuntimeException {

    public BaseballGameFailureException(String message) {
        super(String.format("[ERROR] %s",message));
    }


}
