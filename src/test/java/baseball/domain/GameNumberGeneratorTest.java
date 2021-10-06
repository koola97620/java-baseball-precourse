package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameNumberGeneratorTest {

    @DisplayName("임의의 수 3개를 생성한다")
    @Test
    void create() {
        GameNumberGenerator gameNumberGenerator = new GameNumberGenerator();
        assertThat(gameNumberGenerator.generate()).isNotNull();
    }

}