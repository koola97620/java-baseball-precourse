package baseball.domain;

import java.util.Arrays;

public enum Result {
    STRIKE(true, true),
    BALL(true, false),
    NOTHING(false, false)
    ;

    private boolean isContainNumber;
    private boolean isSamePosition;

    Result(boolean isContainNumber, boolean isSamePosition) {
        this.isContainNumber = isContainNumber;
        this.isSamePosition = isSamePosition;
    }

    public static Result of(boolean isContainNumber, boolean isSamePosition) {
        return Arrays.stream(values())
                .filter(result -> result.isContainNumber == isContainNumber && result.isSamePosition == isSamePosition)
                .findAny()
                .orElse(Result.NOTHING);
    }
}
