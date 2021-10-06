package baseball.domain;

import baseball.exception.BaseballGameFailureException;
import baseball.exception.ErrorCode;

import java.util.Objects;

public class Number {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int number;
    private final int position;

    private Number(int number, int position) {
        validate(number);
        this.number = number;
        this.position = position;
    }

    public static Number of(int number, int position) {
        return new Number(number, position);
    }

    public int getNumber() {
        return this.number;
    }

    public int getPosition() {
        return this.position;
    }

    private void validate(int number) {
        if (number > MAX_NUMBER || number < MIN_NUMBER) {
            throw new BaseballGameFailureException(ErrorCode.NUMBER_BOUNDARY_ERROR.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
