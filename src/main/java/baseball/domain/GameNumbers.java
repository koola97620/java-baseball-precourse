package baseball.domain;

import baseball.exception.BaseballGameFailureException;
import baseball.exception.ErrorCode;
import baseball.util.NumberUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameNumbers {
    private static final int NUMBERS_LENGTH = 3;
    private final List<Number> numbers;

    private GameNumbers(List<Number> list) {
        validate(list);
        this.numbers = list;
    }

    public static GameNumbers of(List<Number> list) {
        return new GameNumbers(list);
    }

    public static GameNumbers of(String numberString) {
        return new GameNumbers(NumberUtils.toList(numberString));
    }

    private void validate(List<Number> list) {
        sizeCheck(list);
        duplicateCheck(list);
    }

    private void sizeCheck(List<Number> list) {
        if (list == null || list.size() != NUMBERS_LENGTH) {
            throw new BaseballGameFailureException(ErrorCode.NUMBERS_LENGTH_ERROR.getMessage());
        }
    }

    private void duplicateCheck(List<Number> list) {
        if (createSet(list).size() != NUMBERS_LENGTH) {
            throw new BaseballGameFailureException(ErrorCode.NUMBERS_DUPLICATION_ERROR.getMessage());
        }
    }

    private Set<Integer> createSet(List<Number> list) {
        Set<Integer> set = new HashSet<>();
        for (Number number : list) {
            set.add(number.getNumber());
        }
        return set;
    }
}
