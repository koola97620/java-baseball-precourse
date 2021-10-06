package baseball.domain;

import baseball.util.NumberUtils;
import nextstep.utils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class GameNumberGenerator implements NumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int GAME_NUMBERS_SIZE = 3;

    @Override
    public GameNumbers generate() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < GAME_NUMBERS_SIZE) {
            set.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }
        return GameNumbers.of(NumberUtils.toList(set));
    }
}
