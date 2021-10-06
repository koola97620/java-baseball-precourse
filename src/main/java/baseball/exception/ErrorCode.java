package baseball.exception;

public enum ErrorCode {
    NUMBER_BOUNDARY_ERROR("숫자는 1~9 사이의 숫자여야 합니다."),
    NUMBERS_LENGTH_ERROR("숫자의 길이는 3자리여야 합니다."),
    NUMBERS_DUPLICATION_ERROR("숫자는 서로 다른 숫자여야 합니다."),
    RESULT_SIZE_ERROR("게임결과는 3개 이하여야 합니다.")
    ;

    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
