package baseball.domain;

import baseball.util.NumberUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    private BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame( () -> GameNumbers.of("123"));
    }

    @ParameterizedTest
    @CsvSource(value = {"312,0,3","123,3,0","124,2,0","142,1,1"})
    void gameStart(String numbers, int strikeCount, int ballCount) {
        GameNumbers gameNumbers = GameNumbers.of(NumberUtils.toList(numbers));

        Results results = baseballGame.start(gameNumbers);

        assertThat(results.getStrikeCount()).isEqualTo(strikeCount);
        assertThat(results.getBallCount()).isEqualTo(ballCount);
    }

}